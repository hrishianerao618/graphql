package com.graphql.graphqltest.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.graphqltest.dto.FilmDTO;
import com.graphql.graphqltest.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilmMutationResolver implements GraphQLMutationResolver {
    @Autowired
    FilmService filmService;

    @Autowired
    FilmPublisher filmPublisher;

    public FilmDTO createFilm(FilmDTO filmDTO) {
        FilmDTO filmDTO1 = filmService.createFilm(filmDTO);
        filmPublisher.publish(filmDTO1);
        return filmDTO1;

    }
}