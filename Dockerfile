FROM openjdk:11
ADD /target/football-0.0.1-SNAPSHOT.jar football-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "football-0.0.1-SNAPSHOT.jar"]