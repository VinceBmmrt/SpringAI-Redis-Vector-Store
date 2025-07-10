## 🔍 Spring AI Multitool

This project demonstrates how to integrate Redis Vector Store with Spring AI

🧠 RAG (Retrieval-Augmented Generation) with Redis Vector Store & OpenAI

🔎 Vector similarity search using OpenAI embeddings

🖼️ Image generation from text prompts (via DALL·E)

📸 Image description from uploaded visuals (Vision model)

🎙️ Speech-to-Text audio transcription (Whisper)

🗣️ Text-to-Speech voice synthesis

## Requirements

- Java 17 or higher
- Docker installed (to run Redis Stack)

## Running Redis Stack

To use vector search features, start Redis Stack with this command:

```bash
docker run -d --name redis-stack -p 6379:6379 redis/redis-stack:latest
```

## Configuration

Copy application.example.properties to application.properties and fill in your settings such as Redis connection details
and OpenAI API key.

## 🚀 API Endpoints

| Method | Endpoint          | Description                              | Params                                        |
|--------|-------------------|------------------------------------------|-----------------------------------------------|
| `GET`  | `/api/{message}`  | Simple chat completion                   | `message`: string                             |
| `POST` | `/api/ask`        | RAG-based Q&A from Redis vector DB       | `query`: string                               |
| `POST` | `/api/product`    | Semantic product search                  | `text`: string                                |
| `POST` | `/api/embedding`  | Get embedding vector for a given text    | `text`: string                                |
| `POST` | `/api/similarity` | Semantic similarity between two texts    | `text1`, `text2`: string                      |
| `POST` | `/api/recommend`  | Movie recommender by type, year, lang    | `type`, `year`, `lang`: string                |
| `POST` | `/api/stt`        | Speech to text transcription             | `file`: audio file (`.mp3`, `.wav`, etc.)     |
| `GET`  | `/image/{query}`  | Generate an image from text prompt       | `query`: string                               |
| `POST` | `/image/describe` | Get AI-generated description of an image | `query`: string, `file`: image file (`.jpeg`) |

