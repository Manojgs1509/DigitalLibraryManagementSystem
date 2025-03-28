
FROM maven:3.8.5-openjdk-17 AS build

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim

# Copy the JAR file from the target directory to the Docker image
COPY --from=build  target/DigitalLibraryBookManagementSystem-0.0.1-SNAPSHOT.jar DigitalLibraryBookManagementSystem.jar

# Expose port 8080 (the port your app runs on)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "DigitalLibraryBookManagementSystem.jar"]


