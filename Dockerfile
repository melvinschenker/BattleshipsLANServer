# Use an official OpenJDK runtime as a parent image
FROM arm32v7/eclipse-temurin:17-jre

# Set the working directory in the container
WORKDIR /app

RUN ls -l .

# Copy the compiled classes into the container at /app
COPY ./out/production/BattleshipsLANServer/ /app

# Run the application
ENTRYPOINT ["java", "Main.java"]
