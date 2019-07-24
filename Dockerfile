FROM openjdk:8
EXPOSE 8080
ADD /build/libs/dockerDemo-0.0.1-SNAPSHOT.jar dockerDemo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "dockerDemo-0.0.1-SNAPSHOT.jar"]
