package com.telusko.SpringAIRedisVectorStore.config;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.vectorstore.redis.RedisVectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPooled;

@Configuration
public class AppConfig {

    @Bean
    public JedisPooled jedispooled() {
        return new JedisPooled("localhost", 6379);
    }

    @Bean
    public VectorStore vectorStore(JedisPooled jedispooled, EmbeddingModel embeddingModel) {
        return RedisVectorStore.builder(jedispooled, embeddingModel)
                .indexName("product-index")
                .initializeSchema(true)
                .build();
    }
}
