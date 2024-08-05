FROM arm32v7/eclipse-temurin:17-jre

WORKDIR /app

COPY src/ /app/src/

RUN mkdir /app/bin

RUN javac -d /app/bin /app/src/Main.java /app/src/**/*.java

WORKDIR /app/bin

ENTRYPOINT ["java", "Main"]
