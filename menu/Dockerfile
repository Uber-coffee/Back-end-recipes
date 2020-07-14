FROM openjdk:11
ADD target/auth*.jar menu_service.jar
ENTRYPOINT ["java", "-jar", "menu_service.jar"]