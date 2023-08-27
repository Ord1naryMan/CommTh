FROM amazoncorretto:17-alpine-jdk
LABEL authors="ord1naryman"

WORKDIR /app

COPY target/CommTh.jar /app/CommTh.jar

EXPOSE 8080

COPY target/CommTh.jar CommTh.jar
ENTRYPOINT ["java","-jar","/app/CommTh.jar"]