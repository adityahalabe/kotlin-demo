To build docker build
 - mvn clean package docker:build

Stop container
- docker stop kotlin-demo

Remove container
- docker rm kotlin-demo

Running mysql image
- docker run -p 6603:3306 --name=docker-mysql --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=kotlin_demo" mysql

Running spring boot image
 docker run -d \
    --name kotlin-demo \
    --link docker-mysql:mysql \
    -p 8080:8080 \
    -e DATABASE_HOST=docker-mysql \
    -e DATABASE_PORT=6603 \
    -e DATABASE_NAME=kotlin_demo \
    -e DATABASE_USER=root \
    -e DATABASE_PASSWORD=root \
    g00glen00b/kotlin-demo

See running containers
	docker ps