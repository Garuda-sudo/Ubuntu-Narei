# Use a base image with Java and a Linux distribution, such as OpenJDK or AdoptOpenJDK.
# Choose an appropriate tag depending on the version of Java you need.
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the compiled Spring Boot application JAR file from the host into the container
COPY target/ubuntu-back-end-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port that your Spring Boot application will be running on
EXPOSE 8080

# Define any environment variables if required
# ENV ENV_VARIABLE_NAME=ENV_VARIABLE_VALUE

# Run the Spring Boot application when the container starts
CMD ["java", "-jar", "app.jar"]
