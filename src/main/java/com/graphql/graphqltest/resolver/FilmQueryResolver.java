package com.graphql.graphqltest.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.graphqltest.dto.FilmDTO;
import com.graphql.graphqltest.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilmQueryResolver implements GraphQLQueryResolver {
    @Autowired
FilmService filmService;

    public List<FilmDTO> getFilms(int pageNo, int size){
        return filmService.getALLFilms(pageNo, size);
    }
}
