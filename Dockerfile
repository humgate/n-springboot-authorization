# Our docker image will be based on openjdk:8-jdk-alpine image
# Also chaged maven pom.xml project property to <java.version>1.8</java.version>
FROM openjdk:8-jdk-alpine

# Our docker container will expose 8080 port
# Regardless of this, container needs to be run with -p 8080:8080 ports mapping option
EXPOSE 8080

# Add our application jar to the image
ADD target/springboot-authorization-0.0.1-SNAPSHOT.jar springbootauthapp
# Command line for launching our application in container

#Command to launch the appliction in container
ENTRYPOINT ["java","-jar","/springbootauthapp"]