@REM run command for nginx docker container launch in Docker on Windows host
@REM uses Windows cmd syntax
@REM first -v binds host folder to container folder, so container can use static html files from it
@REM second -v overwrites nginx container config (default.conf) with the hosts one
docker run -it ^
    --rm ^
    -d ^
    -v D:\JProjects\netology\springboot\springboot-authorization\src\main\resources\static:/usr/share/nginx/html ^
    -v D:\JProjects\netology\springboot\springboot-authorization\nginx-config\default.conf:/etc/nginx/conf.d/default.conf ^
    -p 80:80 ^
    --name nginxserv ^
    nginx