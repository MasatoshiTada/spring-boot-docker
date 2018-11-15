FROM openjdk:8u171

COPY target/boot-api-0.0.1-SNAPSHOT.jar /usr/src/myapp.jar

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://192.168.100.106:5432/edu_spring_db\
    SPRING_DATASOURCE_USERNAME=edu\
    SPRING_DATASOURCE_PASSWORD=edu

WORKDIR /usr/src

EXPOSE 8090

CMD java -jar myapp.jar