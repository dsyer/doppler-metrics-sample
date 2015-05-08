FROM java:8
VOLUME /tmp
ADD ${project.artifactId}-${project.version}.jar /app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]