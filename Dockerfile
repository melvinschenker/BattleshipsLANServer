FROM openjdk:16
COPY ./out/production/BattleshipsLANServer/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "Main"]
