# SpringAI Redis Vector Store with RAG

This project demonstrates how to integrate Redis Vector Store with Spring AI to enable vector similarity searches.

## Requirements

- Java 17 or higher
- Docker installed (to run Redis Stack)

## Running Redis Stack

To use vector search features, start Redis Stack with this command:

```bash
docker run -d --name redis-stack -p 6379:6379 redis/redis-stack:latest
```

## Configuration
Copy application.example.properties to application.properties and fill in your settings such as Redis connection details and OpenAI API key.
