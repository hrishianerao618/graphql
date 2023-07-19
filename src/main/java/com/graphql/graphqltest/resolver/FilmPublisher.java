package com.graphql.graphqltest.resolver;

import com.graphql.graphqltest.dto.FilmDTO;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Sinks;

@Component
public class FilmPublisher {

    private final Sinks.Many<FilmDTO> processor;// streams data

    public FilmPublisher() {
        this.processor = Sinks.many().replay().all();//all elements pushed to this sink are replayed to new subscribers
    }


    public Publisher<FilmDTO> getRecentFilm() {
        return this.processor.asFlux();//process all what comes without filtering
    }
    public Publisher<FilmDTO> get2018YearFilm() {
        return this.processor.asFlux().filter(filmDTO -> filmDTO.getRelease_year().equals("2018"));//process all what comes without filtering with year as 2018
    }


    public void publish(FilmDTO filmDTO1) {
        this.processor.emitNext(filmDTO1, Sinks.EmitFailureHandler.FAIL_FAST);
    }


}
