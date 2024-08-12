
FROM gradle:8.9.0-jdk21-alpine AS builder

WORKDIR /app

COPY --chown=gradle:gradle settings.gradle gradle.properties
COPY --chown=gradle:gradle src/ src/
COPY --chown=gradle:gradle build.gradle build.gradle

RUN gradle dependencies --no-daemon

RUN gradle build -x test --no-daemon

FROM openjdk:21-jdk-slim

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]