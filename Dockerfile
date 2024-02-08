#FROM ubuntu:latest
#LABEL authors="christopher"
#
#ENTRYPOINT ["top", "-b"]

# Use JDK 17 base image
FROM adoptopenjdk:17-jdk-hotspot

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot application JAR from the GitHub repository
COPY target/nalmart-backend-01.jar /app/nalmart-backend-01-0.0.1-SNAPSHOT.jar

# Expose the port that your Spring Boot application listens on
EXPOSE 8080

# Command to run your Spring Boot application when the container starts
CMD ["java", "-jar", "nalmart-backend-01.jar"]
