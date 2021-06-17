# User Service

#### Build the JAR using Maven
``
mvn clean package install
``

#### Build the Docker Image using the Dockerfile
``
docker build -t nikkinicholasromero/spring-jwt-demo .
``

#### Push the Docker Image to Docker Hub
``
docker push nikkinicholasromero/spring-jwt-demo
``

#### Start a Docker Container using the Docker Image
``
docker run --name spring-jwt-demo-container -d -p 8080:8080 nikkinicholasromero/spring-jwt-demo
``
