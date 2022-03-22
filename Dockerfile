# Our docker image will be based on openjdk:14-jdk-alpine image
# The project is set up for JDK14, so lets take appropriate docker image.
FROM openjdk:14-jdk-alpine

# Our docker container will expose 8080 port
# Regardless of this, container needs to be run with -p 8080:8080 ports mapping option
EXPOSE 8080

# Add our application jar to the image
ADD target/springboot-authorization-0.0.1-SNAPSHOT.jar springbootauthapp
# Command line for launching out application in container

#Command to launch the appliction in container
ENTRYPOINT ["java","-jar","/springbootauthapp"]

# Image build command from the folder containing this Dockerfile:
# docker build -t humga/springbootapp .

# Container launch command:
# docker run -p 8080:8080 humga/springbootapp

