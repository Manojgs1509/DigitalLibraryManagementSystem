# Use the official OpenJDK image as a base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory to the Docker image
COPY target/DigitalLibraryBookManagementSystem-0.0.1-SNAPSHOT.jar /app/DigitalLibraryBookManagementSystem.jar

# Expose port 8080 (the port your app runs on)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "DigitalLibraryBookManagementSystem.jar"]
