FROM openjdk:17-jdk-alpine
COPY build/libs /app
ENTRYPOINT ["java","-jar","/app/gateway.war"]