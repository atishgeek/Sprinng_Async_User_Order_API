FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/Spring_User_Order_Async_API.jar async_src.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /async_src.jar
