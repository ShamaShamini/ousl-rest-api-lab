# Student Management Spring Boot API

This project is based on the uploaded Spring Boot Application PDF. The Java code is separated into application, controller, entity, and repository files so it is easier to manage in VS Code.

## Requirements
- JDK 17
- Apache Maven 3.8+
- Docker Desktop (for the local PostgreSQL database)

## 1. Start PostgreSQL with Docker

Run this in Command Prompt or PowerShell:

```powershell
docker run --name ousl-postgres -e POSTGRES_DB=ousl_db -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=StudentPass123 -p 5432:5432 -d postgres:16
```

If the container already exists, start it with:

```powershell
docker start ousl-postgres
```

The local database settings are in `src/main/resources/application.yml`. If you choose a different PostgreSQL username or password, update `DB_USER` and `DB_PASS` there or set those environment variables.

## 2. Open the project in VS Code

Open the `student-service` folder (the folder containing `pom.xml`).

## 3. Run the application

Open Terminal > New Terminal in VS Code and run:

```powershell
mvn spring-boot:run
```

Wait until the console says the application has started. It listens on port 8080.

## 4. Test the API

GET all students:

```http
GET http://localhost:8080/api/students
```

POST a student (send JSON with `Content-Type: application/json`):

```json
{
  "name": "Kamal",
  "course": "Software Engineering"
}
```

Send the POST request to:

```http
POST http://localhost:8080/api/students
```

You can test using the VS Code Thunder Client extension, Postman, or curl.

Health endpoint:

```http
GET http://localhost:8080/actuator/health
```

## 5. Build and run with Docker (optional)

Build the image from the project folder:

```powershell
docker build -t student-service .
```

If the app itself runs in Docker and PostgreSQL is another Docker container, they need a shared Docker network and the datasource host must be the PostgreSQL container name rather than `localhost`. The Dockerfile is included, but the simplest first run is to run PostgreSQL in Docker and the Spring Boot app directly from VS Code.

## Important
- The PDF's original YAML indentation was inconsistent in the extracted text; this project uses valid YAML indentation.
- The local PostgreSQL URL uses `sslmode=disable`. The PDF used `sslmode=require`, which is generally unsuitable for a default local PostgreSQL container.
- `StudentPass123` is only a local development example. Do not use it as a production password.
- The API currently supports listing and adding students, matching the supplied PDF. It does not include update or delete endpoints.
