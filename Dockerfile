# Используем JDK 21 для сборки
FROM eclipse-temurin:21 AS build

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем файлы проекта
COPY . .

# Делаем Gradlew исполняемым
RUN chmod +x ./gradlew

# Собираем приложение
RUN ./gradlew clean build -x check -x test

# Запускаем финальный контейнер
FROM eclipse-temurin:21 AS runtime
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar

# Запуск Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]