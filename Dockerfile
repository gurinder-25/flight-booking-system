# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim


# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/flight-booking-system-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
