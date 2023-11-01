FROM tomcat:10.1.15-jre17-temurin-jammy

COPY target/planes-app#1.0.war /usr/local/tomcat/webapps/airport.war

EXPOSE 8080

CMD ["catalina.sh", "run"]