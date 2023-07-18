FROM eclipse-temurin:11

RUN mkdir /opt/app

COPY ./target/crud-books-0.0.1-SNAPSHOT.jar /opt/app

CMD ["java","-jar","/opt/app/crud-books-0.0.1-SNAPSHOT.jar"]