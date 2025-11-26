FROM gradle:8.10-jdk21 AS builder

WORKDIR /app

COPY build.gradle.kts settings.gradle.kts ./
RUN gradle dependencies --no-daemon || true

COPY src ./src
RUN gradle build --no-daemon --build-cache --configuration-cache

FROM eclipse-temurin:21-jre AS runtime

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]