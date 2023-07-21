package com.graphql.graphqltest.resolver;

import com.graphql.graphqltest.dto.FilmDTO;
import com.graphql.graphqltest.service.FilmService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class FilmQueryResolver implements GraphQLQueryResolver {
    Logger logger = Logger.getLogger(FilmQueryResolver.class.getName());

    private final ExecutorService executor = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()//instead of hardcoding number of threads
    );
    @Autowired
    FilmService filmService;

    public CompletableFuture<List<FilmDTO>> getFilms(int pageNo, int size) {

        return CompletableFuture.supplyAsync(
                () -> {
                    logger.log(Level.INFO, "getFilms Called");
                    List<FilmDTO> filmDTO = filmService.getALLFilms(pageNo, size);
                    logger.log(Level.INFO, "getFilms Ended");
                    return filmDTO;
                }, executor
        );

    }

    public CompletableFuture<List<FilmDTO>> getFilmsByYear(String year) {
        return CompletableFuture.supplyAsync(
                () -> {
                    logger.log(Level.INFO, "getFilmsByYear Called");
                    List<FilmDTO> filmDTO = filmService.getFilmsByYear(year);
                    logger.log(Level.INFO, "getFilmsByYear Ended");
                    return filmDTO;
                }, executor
        );

    }
}
