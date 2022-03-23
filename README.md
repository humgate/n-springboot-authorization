### 1. Springboot application implementing the simplest authorization service
Springboot application implementing the simplest authorization service and demonstrating handling 
of different exceptions thrown in controller using @ExceptionHandler annotated methods.
Java version set to 8 to allow using application jar in customized Docker container based on openjdk:8-jdk-alpine.<br>
Dockerfile in project root defines docker image building.
docker-compose.yml describes docker compose manifest.
To test (on Windows host):<br>
1. Build application jar using maven clean package
2. Build spring application docker image by running the following command from the project root (folder 
containing Dockerfile):<br>
`docker build -t humga/springbootapp .`
3. Run docker container by the following command from the project root:<br>
`docker run -p 8080:8080 humga/springbootapp`

Three test users hardcoded in UserRepository for testing the app:<br>
user = "Vasya"; password = "123" ; Authorities = READ,WRITE<br>
user ="Masha"; password = "234"; Authorities = READ,WRITE,DELETE<br>
user = "Grisha"; password = "567"; Authotities = Empty<br>

### 2. Nginx proxie working with authorization server from above both on the same OS (Ubuntu 20.04.4)
Nginx server configured to return authorization form when URI is http://localhost/signing but proxying all
other requests to the authorization server application developed earlier. Nginx conf file
(nginx-ubuntu20.04.4.conf) added in the project root, authform.html located in resources. Tested ok on Ubuntu 20.04.
To test (on Ubuntu host):<br>
1. Rename nginx-ubuntu20.04.4.conf to nginx.conf and replace etc/nginx/nginx.conf with it
2. Copy authorization page from project root to user home (/home/humgate)
3. Start springboot app and start nginx server
4. In web browser go to http://localhost/signing. Authorization page opens - this is nginx response.
5. Fill out the form with values mentioned above and submit. New page opens displaying authorities JSON - this is 
springboot application response

### 3. Using Docker containers for running applications 
#### 3.1 nginx runs in docker container but spring app runs on host machine (feature/docker-compose)
Standard official `nginx` docker image used with no modification. 
Docker-compose was not used for this set up, just docker.<br> 
To test (on Windows host):<br>
1. Launch springboot application on host machine
2. From project root folder run `.\dockerun-nginx.cmd`
3. In web browser go to http://localhost/signing -  this is nginx container response.
4. Fill out the form with values mentioned above and submit. New page opens displaying authorities JSON - this is
   springboot application (running in host)response
 