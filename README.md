# ForoHub

ForoHub es una aplicación web para gestionar foros de discusión. Permite a los usuarios registrarse, iniciar sesión, crear y responder a temas de discusión, y mucho más.

## Características

- Registro y autenticación de usuarios
- Creación y gestión de temas de discusión
- Respuestas a temas de discusión
- Autenticación basada en JWT
- Documentación de la API con OpenAPI/Swagger

## Tecnologías Utilizadas

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- MySQL
- Flyway (para migraciones de base de datos)
- Swagger (para documentación de la API)

## Requisitos Previos

- Java 17 o superior
- Maven 3.6.0 o superior
- MySQL 8.0 o superior

## Configuración del Proyecto

1. Clona el repositorio:

   ```sh
   git clone https://github.com/tu-usuario/forohub.git
   cd forohub
   
2. Configura las variables de entorno en el archivo application.properties:
   
   ```sh
   spring.application.name=forohub
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.datasource.url=jdbc:mysql://${DB_HOST}/${DB_NAME}?createDatabaseIfNotExist=true
   spring.datasource.username=${DB_USER}spring.datasource.password=${DB_PASSWORD}

   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.format_sql=true

   server.error.include-stacktrace=never

   api.security.secret=${JWT_SECRET}
   
3. Ejecuta las migraciones de Flyway para configurar la base de datos:
   
   ```sh
   mvn flyway:migrate

4. Inicia la aplicación:
   
   ```sh
   mvn spring-boot:run

## Uso

Endpoints de la API
- /login - Autenticación de usuarios
- /usuarios - Gestión de usuarios
- /topicos - Gestión de temas de discusión
- /respuestas - Gestión de respuestas

## Documentación de la API

La documentación de la API está disponible en /swagger-ui.html una vez que la aplicación esté en funcionamiento.

## Contribuciones
Las contribuciones son bienvenidas. Por favor, abre un issue o envía un pull request para cualquier mejora o corrección.

## Licencia
Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo LICENSE para obtener más detalles.
