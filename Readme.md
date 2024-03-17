* Запуск проекта в Docker:
* 
1.  Создать jar файл проекта командой в терминале -
mvn clean package
2. Создать  Dockerfile в папке проекта
* содержание Dockerfile
* # Use a base image with Java 18
FROM openjdk:18

# Copy the JAR package into the image
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} clinic-0.0.1-SNAPSHOT.jar

# Expose the application port
EXPOSE 9000

# Run the App
ENTRYPOINT ["java", "-jar", "/clinic-0.0.1-SNAPSHOT.jar"]
3. Создать в папке проекта файл .env
Содержание файла .env
   MYSQL_DATABASE=clinic
   MYSQL_PASSWORD=root
4. Создать в папке проекта файл docker-compose.yml
Содержание файла docker-compose.yml
version: '3.7'
services:
app:
build:
context: .
dockerfile: Dockerfile
ports:
- 9000:9000
depends_on:
mysqldb:
condition: service_healthy
environment:
- SPRING_DATASOURCE_URL=jdbc:mysql://mysqldb:3306/${MYSQL_DATABASE}
- SPRING_DATASOURCE_USERNAME=root
- SPRING_DATASOURCE_PASSWORD=${MYSQL_PASSWORD}
networks:
- springboot-mysql-network
mysqldb:
image: mysql:8.0.33
ports:
- 3306:3306
environment:
- MYSQL_DATABASE=${MYSQL_DATABASE}
- MYSQL_ROOT_PASSWORD=${MYSQL_PASSWORD}
volumes:
- mysql-data:/var/lib/mysql
networks:
- springboot-mysql-network
healthcheck:
test: ["CMD", "mysqladmin" ,"ping", "-h", "localhost"]
retries: 10
interval: 3s
timeout: 30s
volumes:
mysql-data:
networks:
springboot-mysql-network:
name: springboot-mysql-network 
5. docker build .
6. docker-compose up