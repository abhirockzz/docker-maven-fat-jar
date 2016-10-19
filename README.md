### This example

- uses Jersey Grizzly connector to build a simple REST app
- packages this as a (Uber) JAR using Maven
- the Maven build process pushes this as a Docker image (thanks to the plugin)

### Steps

- Make sure Docker is up and running
- Set following environment variables (use `docker-machine env` to get these) - DOCKER_HOST (e.g. tcp://192.168.99.100:2376), DOCKER_CERT_PATH (e.g. C:\Users\bond-007\.docker\machine\machines\default)
- mvn clean package docker:build
- `docker run -p 8080:8080 -it abhirockzz/docker-maven-test`
- http://<DOCKER_HOST>:8080/
