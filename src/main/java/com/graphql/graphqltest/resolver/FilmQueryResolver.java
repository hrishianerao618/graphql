package com.graphql.graphqltest.resolver;

import com.fasterxml.jackson.core.format.DataFormatDetector;
import com.graphql.graphqltest.context.CustomGraphQLContext;
import com.graphql.graphqltest.dto.FilmDTO;
import com.graphql.graphqltest.service.FilmService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.SelectedField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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

    public CompletableFuture<List<FilmDTO>> getFilmsByYear(String year, DataFetchingEnvironment dataFetchingEnvironment) {
        CustomGraphQLContext context = dataFetchingEnvironment.getContext();
        logger.log(Level.INFO, "getUserId from Context {}"+ context.getUserId());

        List<String> setFields = dataFetchingEnvironment.getSelectionSet().getFields().stream()
                .map(SelectedField::getName).collect(Collectors.toList());
        //this will give the fields which are actually selected by clients, with help of this fields we can make Hibernate Query to fetch only desired results
        System.out.println("Fields:"+setFields);
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
