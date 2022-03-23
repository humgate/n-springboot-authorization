### 1. Springboot application implementing the simplest authorization service (master branch)
Springboot application implementing the simplest authorization service and demonstrating handling 
of different exceptions thrown in controller using @ExceptionHandler annotated methods.
Java version set to 8 to allow using application jar in Docker container based on openjdk:8-jdk-alpine.
Dockerfile in project root describes docker image building.
docker-compose.yml describes docker compose manifest.

Three test users hardcoded in UserRepository for testing:

        user = "Vasya"; password = "123" ; Authorities = READ,WRITE
        user ="Masha"; password = "234"; Authorities = READ,WRITE,DELETE
        user = "Grisha"; password = "567"; Authotities = Empty

### 2. Nginx proxie working with authorization server from above both on the same OS (feature/authform branch)
Nginx server configured to return authorization form when URI is http://localhost/signing but proxying all
other requests to the authorization server application developed earlier (master branch). nginx.conf file 
added in the project root, authform.html located in resources. Tested ok on Ubuntu 20.04 with nginx.conf 
configured to look for authorization page in the root of user home (/home/humgate) -defined in nginx-ubuntu20.04.4.conf

### 3. Using Docker containers for running applications 
#### 3.1 nginx runs in docker container but spring app runs on host machine (not using docker-compose)
Standard official `nginx` docker image used with no modification.<br>
To test (on Windows host):<br>
1. launch springboot application on host machine
2. from project root folder run `.\dockerun-nginx.cmd`
3. in web browser go to http://localhost/signing and fill out the form with values mentioned above. This is nginx working 
from container). Submit.
4. new page opens displaying authorities JSON. It is springboot application response 
 