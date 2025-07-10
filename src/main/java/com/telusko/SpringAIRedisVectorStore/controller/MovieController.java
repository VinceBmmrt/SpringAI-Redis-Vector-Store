package com.telusko.SpringAIRedisVectorStore.controller;

import com.telusko.SpringAIRedisVectorStore.Movie;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    private ChatClient chatClient;

    public MovieController(OpenAiChatModel chatModel) {
        this.chatClient = ChatClient.create(chatModel);
    }

    @GetMapping("movies")
    public List<String> getMovies(@RequestParam String name) {

        List<String> movies = chatClient.prompt()
                .user(u -> u.text("List top 5 movies of {name}").param("name", name))
                .call()
                .entity(new ListOutputConverter(new DefaultConversionService()));

        return movies;
    }

    @GetMapping("/movie")
    public Movie getMovieData(@RequestParam String name) {

        BeanOutputConverter<Movie> opCon = new BeanOutputConverter<Movie>(Movie.class);

        Movie movie = chatClient.prompt()
                .user(u -> u.text("Get me the best movie of {name}").param("name", name))
                .call()
                .entity(new BeanOutputConverter<Movie>(Movie.class));

        return movie;
    }

    @GetMapping("/moviesList")
    public List<Movie> getMovieList(@RequestParam String name) {

        BeanOutputConverter<List<Movie>> opCon = new BeanOutputConverter<List<Movie>>(
                new ParameterizedTypeReference<List<Movie>>() {
                });

        List<Movie> movies = chatClient.prompt()
                .user(u -> u.text("Top 5 movies of {name}").param("name", name))
                .call()
                .entity(new BeanOutputConverter<List<Movie>>(new ParameterizedTypeReference<List<Movie>>() {
                }));

        return movies;


    }
}