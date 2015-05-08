/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.actuate.metrics.doppler;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.ObjectUtils;

/**
 * @author Vinicius Carvalho
 * @author Dave Syer
 */
@ConfigurationProperties("spring.metrics.doppler")
public class DopplerProperties {

	/**
	 * Host that metron or doppler is running on.
	 */
	private String host = "192.168.11.11";

	/**
	 * Port to send metrics on the host. Metron always listens on 3457, but doppler
	 * sometimes sits on 3458 (e.g. in lattice).
	 */
	private int port = 3457;

	/**
	 * Key identifying origin of metrics. Set to something unique for your application and
	 * instance.
	 */
	private String origin = "spring.application." + ObjectUtils.getIdentityHexString(this);

	/**
	 * Secret to use if signing messages (only necessary if sending directly to doppler).
	 */
	private String secret;

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getSecret() {
		return this.secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return this.port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
