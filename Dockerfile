FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./target/cooperforte-service-0.0.1-SNAPSHOT.jar torcedores-cooperforte.jar
ENTRYPOINT ["java","-jar","/torcedores-cooperforte.jar"]