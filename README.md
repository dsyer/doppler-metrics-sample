Sample app for pushing Spring Boot metrics to [doppler](https://github.com/cloudfoundry/loggregator) (a.k.a. loggregator).

## Prerequisites

You need Java (8) and Maven (3) to build the app. You also need some extended features for the Spring Boot Actuator currently residing in [the `feature/metrics` branch of a fork of Spring Boot](https://github.com/dsyer/spring-boot/tree/feature/metrics):

```
$ git clone https://github.com/dsyer/spring-boot
$ git checkout feature/metrics
$ export JAVA_HOME=/path/to/jdk1.8.0 # if it isn't already
$ mvn install -P prepare -DskipTests=true
$ mvn install -DskipTests=true
```

(This stuff will be merged into Spring Boot 1.3.0 at some point.)

## Running the Application Locally

If you have network connectivity into a doppler host (e.g. a Vagrant VM at 192.168.11.11), you can run the app locally and pump metrics:

```
$ export DOPPLER_HOST=192.168.11.11
$ mvn spring-boot:run
```

and hit the home page a few times (you get a 404, but that generates metrics): [http://localhost:8080](http://localhost:8080). By default the app will send metrics as unsigned UDP messages to the `metron` port 3457. You can also have it send signed messages directly to doppler if you know the secret for the signature:

```
$ export DOPPLER_HOST=192.168.11.11
$ export DOPPLER_PORT=3458
$ export DOPPLER_SECRET=loggregator-secret
$ mvn spring-boot:run
```

In lattice `doppler` listens on port 3458. In PCF I believe it listens on 3457 as well.

See `src/main/resources/application.properties` for configuration options.

## The Firehose

There is a utility at [https://github.com/cloudfoundry/noaa](https://github.com/cloudfoundry/noaa) that you can use to cat the loggregator data. Make sure `go` is installed and `GO_PATH` is set then do this:

```
$ go get github.com/cloudfoundry/noaa
$ cd $GOPATH/src/github.com/cloudfoundry/noaa
$ vi firehose_sample/main.go
... edit the file and change the address to match your doppler server
$ go build -o bin/firehose_sample firehose_sample/main.go
$ bin/firehose_sample
... lots of logs
^C
$ bin/firehose_sample | grep metrics-sample.*ValueMetric
... metrics only from the sample app
```

I modified the sample so that it pulls the doppler address from an environment variable, e.g.

```
const DefaultDopplerAddress = "ws://doppler.192.168.11.11.xip.io"

...

func main() {
    DopplerAddress :=  os.Getenv("DOPPLER_ADDRESS")
    if (len(DopplerAddress) == 0) {
        DopplerAddress = DefaultDopplerAddress
    }
    ...
```


## It's not Working

I know. The `metron` process only listens on 127.0.0.1, and the `doppler` process only listens on an internal network as well (e.g. 10.0.2.15), so you probably can't reach either of them. You can see the processes if you can ssh into the VM they are running on and do a `netstat`:

```
$ sudo netstat -ulnp
...
udp        0      0 10.0.2.15:3458          0.0.0.0:*      2825/doppler
...
udp        0      0 127.0.0.1:3457          0.0.0.0:*      2789/metron
...
```

(The example above was in a Vagrant VM running lattice.)

You can use `nc` to capture a metric message, e.g. for `metron`

```
$ nc -u -l 192.168.11.11 3457
```

listens on the external address which the app is sending data to. It will accept one message and then stop (for reasons I don't understand), so you have to CTRL-C out of the netcat process. You can redirect the result to a file, in case you might want to replay it later:

```
$ nc -u -l 192.168.11.11 3457 > u.dat
^C
$ hexdump u.dat
0000000 0e0a 656d 7274 6369 2d73 6173 706d 656c
0000010 0610 ef30 9ecf d39b 4a29 0a2e 631c 756f
0000020 746e 7265 732e 6174 7574 2e73 3034 2e34
0000030 7473 7261 732d 6174 1172 0000 0000 0000
0000040 3ff0 051a 6f63 6e75 0074
0000049
```

To replay it you can do this:

```
$ cat u.dat | nc -u 127.0.0.1 3457
```

and it will show up in the doppler firehose.

### Attempting to Bridge UDP to Metron

You'd think this would work (on the VM that runs doppler):

```
$ mkfifo pipe
$ nc -k -u -l 192.168.11.11 3457 0<pipe | tee p.log | nc -u 127.0.0.1 3457 1>pipe
```

and it does (sort of), but you only ever get one measurement (log message) coming out on the firehose. Kill the process and start again and you get another.

### Tunnels and Netcats

For TCP you can set up a chat between 2 nc processes, but with UDP it seems to stop after the first message.

```$ nc -k -l 127.0.0.1 1234
```

and

```$ echo foo | nc 127.0.0.1 1234
```

Do the echo 3 times and you get `foofoofoo` on the first console. But it doesn't work the same way with `nc -u` - you only get one foo.

### IPTables

This appears to work (in VirtualBox, for EC2 use `eth0` instead of `eth1`):

```
$ sudo bash -c 'echo 1 >  /proc/sys/net/ipv4/conf/eth1/route_localnet'
$ sudo iptables -t nat -A PREROUTING -p udp -i eth1 --dport 3457 -j DNAT --to-destination 127.0.0.1:3457
```

## Useful Links

[https://github.com/cloudfoundry/dropsonde-protocol](https://github.com/cloudfoundry/dropsonde-protocol)
[http://www.cloudcredo.com/cloud-foundry-firehose-and-friends/](http://www.cloudcredo.com/cloud-foundry-firehose-and-friends/)
