FROM alpine/git as clone
WORKDIR /app
RUN git clone https://github.com/Shantanu1990/Football-app.git

FROM maven:3.6.1-jdk-11 as build
WORKDIR /app
COPY --from=clone /app/Football-app /app
RUN mvn clean install

FROM openjdk:11
WORKDIR /app
COPY --from=build /app/target/football-0.0.1-SNAPSHOT.jar /app
ENTRYPOINT ["java", "-jar", "/app/football-0.0.1-SNAPSHOT.jar"]