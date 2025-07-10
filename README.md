## 🔍 Spring AI Multitool

This project showcases the integration of Redis Vector Store with Spring AI to build advanced AI-powered features.

Features include:

🧠 RAG (Retrieval-Augmented Generation) leveraging Redis Vector Store and OpenAI for enhanced contextual responses

🔎 Vector similarity search using OpenAI embeddings for fast and relevant data retrieval

🖼️ Text-to-image generation powered by DALL·E for creative visuals

📸 AI-powered image description from uploaded images

🎙️ Speech-to-Text transcription using OpenAI’s audio recognition model

🔈 Text-to-Speech conversion that returns audio output for seamless voice interaction

📋 List extraction from LLM responses using Spring AI's ListOutputConverter for structured outputs (e.g., top movie
lists)

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

| Method | Endpoint          | Description                                         | Params                                        |
|--------|-------------------|-----------------------------------------------------|-----------------------------------------------|
| `GET`  | `/api/{message}`  | Simple chat completion                              | `message`: string                             |
| `POST` | `/api/ask`        | RAG-based Q&A from Redis vector DB                  | `query`: string                               |
| `POST` | `/api/product`    | Semantic product search                             | `text`: string                                |
| `POST` | `/api/embedding`  | Get embedding vector for a given text               | `text`: string                                |
| `POST` | `/api/similarity` | Semantic similarity between two texts               | `text1`, `text2`: string                      |
| `POST` | `/api/recommend`  | Movie recommender by type, year, lang               | `type`, `year`, `lang`: string                |
| `GET`  | `/image/{query}`  | Generate an image from text prompt                  | `query`: string                               |
| `POST` | `/image/describe` | Get AI-generated description of an image            | `query`: string, `file`: image file (`.jpeg`) |
| `POST` | `/api/stt`        | Speech to text transcription                        | `file`: audio file (`.mp3`, `.wav`, etc.)     |
| `POST` | `/api/tts`        | Convert text to speech (returns audio)              | `text`: string                                |
| `GET`  | `/movies`         | Get Array of top 5 movies using ListOutputConverter | `name`(actor): string                         |
