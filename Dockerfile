FROM arm64v8/eclipse-temurin

WORKDIR /app

COPY src/ /app/src/

RUN mkdir /app/bin

RUN javac -d /app/bin /app/src/Main.java /app/src/**/*.java

WORKDIR /app/bin

ENTRYPOINT ["java", "Main"]
