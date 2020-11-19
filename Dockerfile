FROM alpine/git
WORKDIR /app
RUN git clone https://github.com/Shantanu1990/Football-app.git

FROM maven:3.5-jdk-8-alpine as build (2)
WORKDIR /app
COPY --from=clone /app/Football-app /app (3)
RUN mvn clean install

FROM openjdk:11
WORKDIR /app
COPY --from=build /app/target/football-0.0.1-SNAPSHOT.jar /app
CMD ["java -jar football-0.0.1-SNAPSHOT.jar"]