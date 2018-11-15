FROM openjdk:8u171

COPY target/boot-ui-0.0.1-SNAPSHOT.jar /usr/src/myapp.jar

ENV API_SERVICE_URI=http://192.168.100.106:8090/api/employees

WORKDIR /usr/src

EXPOSE 8080

CMD java -jar myapp.jar