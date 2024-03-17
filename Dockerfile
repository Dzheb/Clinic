# Use a base image with Java 18
FROM openjdk:18

# Copy the JAR package into the image
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} clinic-0.0.1-SNAPSHOT.jar

# Expose the application port
EXPOSE 9000

# Run the App
ENTRYPOINT ["java", "-jar", "/clinic-0.0.1-SNAPSHOT.jar"]
