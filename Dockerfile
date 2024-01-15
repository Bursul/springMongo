FROM openjdk:17
# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the application when the container launches
CMD ["java", "-jar", "/app/build/libs/springmongo-0.0.1.jar"]

#FROM openjdk:11
#ADD target/*.jar springmongo
#ENTRYPOINT ["java", "-jar","springmongo"]
#EXPOSE 8080