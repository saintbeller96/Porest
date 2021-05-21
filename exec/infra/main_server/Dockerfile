#자바 버전
FROM openjdk:11-jdk

#포트
EXPOSE 8081

#애플리케이션 추가 (jar)
ADD ./backend/porest-*.jar porest.jar

#실행 명령
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","porest.jar"]
