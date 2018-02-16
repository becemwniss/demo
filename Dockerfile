FROM java:8
VOLUME /tmp
ADD target/demo-0.0.1-SNAPSHOT.jar journal.jar
ENV SPRING_PROFILES_ACTIVE docker
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/journal.jar"]