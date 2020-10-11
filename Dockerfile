FROM openjdk:8

WORKDIR /loadbalancer/bin

ENV PORT 6000

COPY /target/classes /loadbalancer/bin/classes
COPY /target/dependency /loadbalancer/bin/dependency

CMD ["java","-cp","./classes:./dependency/*","masiv.App"]
