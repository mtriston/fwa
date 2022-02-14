#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM tomcat:jdk8-openjdk

ARG WAR_FILE=/home/app/target/*.war
COPY --from=build ${WAR_FILE} /usr/local/tomcat/webapp/fwa-app.war

EXPOSE 8080
CMD ["catalina.sh", "run"]