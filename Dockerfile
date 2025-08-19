FROM eclipse-temurin:24-jre
WORKDIR /app

RUN addgroup --system app && adduser --system --ingroup app appuser
USER appuser


COPY build/libs/*.jar app.jar


ENV JAVA_OPTS="" \
    SPRING_PROFILES_ACTIVE=default

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS -jar app.jar"]