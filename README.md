### 1. Springboot application implementing the simplest authorization service
Springboot application implementing the simplest authorization service and demonstrating handling 
of different exceptions thrown in controller using @ExceptionHandler annotated methods.
Java version set to 8 to allow using application jar in customized Docker container based on openjdk:8-jdk-alpine.<br>
Dockerfile in project root defines docker image building.
To test (on Windows host):<br>
1. Build application jar using `maven clean package`
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
#### 3.1 nginx runs in docker container but spring app runs on host machine (no docker-compose)
Standard official `nginx` docker image used with no modification. 
Docker-compose was not used for this setup, just docker.<br> 
To test (on Windows host):<br>
1. Launch springboot application on host machine
2. Verify the `proxy_pass` in /nginx-config/default.conf is set to `http://host.docker.internal:8080`. nginx container
needs to use `host.docker.internal` to access the host
4. From project root folder run `.\dockerun-nginx.cmd`
5. In web browser go to http://localhost/signing - this is nginx container response.
6. Fill out the form with values mentioned above and submit. New page opens displaying authorities JSON - this is
   springboot application (running in host) response

#### 3.2 nginx runs in docker container and spring app runs in docker container (using docker-compose)
Official `nginx` docker image used with no modification. Nginx configuration is done by binding host folders
containing nginx .conf file and `authform.html` to container folders using the `volume:` option in `docker-compose.yaml`.
Both binding commands in volumes directive do OVERWRITE all the files in corresponding container folder before
starting nginxserv service.<br>
Docker image defined in Dockerfile (see above in step 1) used for springboot app.
To test (on Windows host):<br>
1. Verify the `proxy_pass` in /nginx-config/default.conf is set to `springbootapp`. This is app container network name 
inside docker-compose internal network, and nginx container needs to use it to access springbootgapp container
2. From the project root folder run: `docker-compose up`
3. In web browser go to http://localhost/signing - this is nginx container response.
4. Fill out the form with values mentioned above and submit. New page opens displaying authorities JSON - this is
   springboot container response