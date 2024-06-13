FROM bitnami/java:17
WORKDIR /app
COPY target/*.jar app-java-forge-demo.jar
ENTRYPOINT ["java","-jar","app-java-forge-demo.jar"]
EXPOSE 8080