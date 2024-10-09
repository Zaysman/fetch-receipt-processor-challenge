#Use an official OpenJDK runtime as the base image
FROM openjdk:21-jdk-slim

#Set the working directory inside the container
WORKDIR /app

#Copy the jar file from you local machine to the container
COPY target/receipt_processor_challenge-0.0.1-SNAPSHOT.jar /app/receipt_processor_challenge-0.0.1-SNAPSHOT.jar

#Expose the port on which the application will run. 8080 is the default port for Spring Boot Applications
EXPOSE 8080 

#Define the command to run your application
CMD ["java", "-jar", "/app/receipt_processor_challenge-0.0.1-SNAPSHOT.jar"]