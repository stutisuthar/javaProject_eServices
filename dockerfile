FROM java:8
WORKDIR /
ADD target/services-0.0.1-SNAPSHOT.jar target/services-0.0.1-SNAPSHOT.jar
EXPOSE 80
CMD java -jar target/services-0.0.1-SNAPSHOT.jar