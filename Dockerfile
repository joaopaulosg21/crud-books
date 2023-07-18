FROM eclipse-temurin:11

RUN mkdir /opt/app

COPY /home/runner/work/crud-books/crud-books/target/crud-books-0.0.1-SNAPSHOT.jar /opt/app

CMD ["java","-jar","/opt/app/crud-books-0.0.1-SNAPSHOT.jar"]