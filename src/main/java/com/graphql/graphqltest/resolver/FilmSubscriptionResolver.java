package com.graphql.graphqltest.resolver;

import com.graphql.graphqltest.dto.FilmDTO;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilmSubscriptionResolver implements GraphQLSubscriptionResolver {
    @Autowired
    FilmPublisher filmPublisher;
    public Publisher<FilmDTO> getRecentFilm(){
        return filmPublisher.getRecentFilm();
    }

    public Publisher<FilmDTO> getYear2018Film(){
        return filmPublisher.get2018YearFilm();
    }
}
