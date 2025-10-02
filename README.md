# Chat Storage Service (Spring Boot) - Minimal Skeleton

This is a minimal, ready-to-run Spring Boot project implementing a chat storage microservice skeleton
for the Backend Developer Case Study. It provides basic session and message APIs with API key auth.

## Features included
- Create/list/delete chat sessions (in-memory storage)
- Add/retrieve messages for a session
- API key authentication via `X-API-KEY` header (value from `APP_API_KEY` env)
- Global exception handling
- Dockerfile included
- `.env.example` included

## Run locally (with Maven)
```bash
mvn clean package
mvn spring-boot:run
```
Or run the built jar:
```bash
mvn clean package
java -jar target/chat-storage-service-0.0.1-SNAPSHOT.jar
```

## Run with Docker
```bash
mvn clean package
docker build -t chat-service .
docker run -e APP_API_KEY=secret123 -p 8080:8080 chat-service
```

## APIs (examples)
All requests must include header: `X-API-KEY: secret123` (or your value)

- `POST /api/sessions?name=MyChat` -> create session
- `GET /api/sessions` -> list sessions
- `DELETE /api/sessions/{id}` -> delete session
- `POST /api/sessions/{id}/messages` -> add message (JSON body)
  ```json
  { "sender":"user", "content":"hello", "context":"optional" }
  ```
- `GET /api/sessions/{id}/messages` -> get messages

## Notes
- Storage is in-memory (ConcurrentHashMap). Suitable for demo / interview submission.
- For production: swap to a persistent DB, add rate limiting, logging, Swagger, tests.
