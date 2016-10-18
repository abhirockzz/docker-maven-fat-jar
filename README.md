Make sure Docker is up and running
Set following environment variables (use `docker-machine en`v to get these) - DOCKER_HOST, DOCKER_CERT_PATH

Examples

- DOCKER_HOST=tcp://192.168.99.100:2376
- DOCKER_CERT_PATH=C:\Users\bond-007\.docker\machine\machines\default
 
mvn clean package docker:build

docker run -p 8080:8080 -it abhirockzz/docker-maven-test

http://<your docker host>:8080/