# Usa la imagen oficial de Amazon Corretto 17
FROM amazoncorretto:17

# Crea un directorio de trabajo para la aplicación
WORKDIR /app

# Copia todos los archivos del proyecto al contenedor
COPY . .

# Otorga permisos de ejecución al wrapper de Gradle
RUN chmod +x ./gradlew

# Ejecuta el wrapper de Gradle para compilar el proyecto y generar el JAR
RUN ./gradlew clean build -x test

# Expone el puerto en el que corre Spring Boot (por defecto 8080)
EXPOSE 8080

# Comando para correr la aplicación usando el JAR generado
CMD ["sh", "-c", "java -jar target/*.jar"]