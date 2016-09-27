# Using rpi image with java 8
FROM java:8
#FROM hypriot/rpi-java

FROM java:8
VOLUME /tmp
# Build number hard-coded so far
ADD cloud-v1.0.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 8080  
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]