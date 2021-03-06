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
FROM tomcat:jdk11-openjdk-slim

ARG WAR_FILE=/home/app/target/*.war
COPY --from=build ${WAR_FILE} /usr/local/tomcat/webapps/cinema.war
CMD ["jar -xvf /usr/local/tomcat/webapps/cinema.war", "sh"]
EXPOSE 8080
CMD ["catalina.sh", "run"]