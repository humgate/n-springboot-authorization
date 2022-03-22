Springboot application implementing the simplest authorization service and demonstrating handling 
of different exceptions thrown in controller using @ExceptionHandler annotated methods.

Three test users hardcoded in UserRepository for testing:

        user = "Vasya"; password = "123" ; Authorities = READ,WRITE
        user ="Masha"; password = "234"; Authorities = READ,WRITE,DELETE
        user = "Grisha"; password = "567"; Authotities = Empty

### 2. Nginx proxie working with authorization server from above (feature/authform branch)
Nginx server configured to return authorization form when URI is http://localhost/signing but proxying all
other requests to the authorization server application developed earlier (master branch). nginx.conf file 
added in the project root, authform.html located in resources. Tested ok on Ubuntu 20.04 with nginx.conf 
configured to look for authorization page in the root of user home (/home/humgate)

Java version set to 8 to allow using application jar in Docker container based on openjdk:8-jdk-alpine.
Dockerfile in project root describes docker image building.
docker-compose.yml describes docker compose manifest. 