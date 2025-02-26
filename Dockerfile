# 1️⃣ Usamos una imagen de Maven con OpenJDK 17
FROM maven:3.9.6-eclipse-temurin-17 AS build

# 2️⃣ Establecemos el directorio de trabajo
WORKDIR /app

# 3️⃣ Copiamos el archivo pom.xml y descargamos dependencias
COPY pom.xml .
RUN mvn dependency:go-offline -B

# 4️⃣ Copiamos el código fuente y construimos la aplicación
COPY src ./src
RUN mvn package -DskipTests

# 5️⃣ Usamos una imagen más ligera para ejecutar el JAR
FROM eclipse-temurin:17-jre

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# 6️⃣ Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
