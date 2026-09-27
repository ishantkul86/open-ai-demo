FROM openjdk:23

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} openAIDemo.jar

ENTRYPOINT ["java","-jar","/demoApp.jar"]