FROM openjdk:8-oracle
COPY target/*.jar app.jar
CMD ["--server.port=8080"]
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]