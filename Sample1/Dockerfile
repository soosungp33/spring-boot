# Start with a base image containing Java runtime
FROM java:8

RUN apt update
RUN apt install openjdk-8-jre
RUN apt install openjdk-8-jdk
RUN apt install maven
RUN apt install tomcat8

RUN git clone https://github.com/COALA-OJ/spring-boot.git
RUN cd spring-boot
RUN git checkout release
RUN git pull
RUN cd Sample1

RUN mvn package

RUN java -jar webb-1.0.0-BUILD-SNAPSHOT.jar