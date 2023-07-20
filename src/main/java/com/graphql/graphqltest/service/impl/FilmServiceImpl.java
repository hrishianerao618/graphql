package com.graphql.graphqltest.service.impl;

import com.graphql.graphqltest.dto.ActorDTO;
import com.graphql.graphqltest.dto.FilmDTO;
import com.graphql.graphqltest.model.Actor;
import com.graphql.graphqltest.model.Film;
import com.graphql.graphqltest.repository.FilmRepository;
import com.graphql.graphqltest.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    FilmRepository filmRepository;

    @Override
    public List<FilmDTO> getALLFilms(int pageNo, int size) {
        PageRequest pageable = PageRequest.of(pageNo, size);
        return filmRepository.findAll(pageable).stream().map(
          film -> {
              FilmDTO dto = new FilmDTO();
              dto.setFilmId(film.getFilmId());
              dto.setDescription(film.getDescription());
              dto.setLength(film.getLength());
              dto.setRating(film.getRating());
              dto.setLanguage_id(film.getLanguage_id());

              Timestamp timestampRes = film .getLast_update();
              SimpleDateFormat dateFormatRes = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
              String dateString = dateFormatRes.format(timestampRes);
              dto.setLast_update(dateString);

              dto.setRelease_year(film.getRelease_year());
              dto.setRental_rate(film.getRental_rate());
              dto.setTitle(film.getTitle());
              dto.setRental_duration(film.getRental_duration());
              dto.setReplacement_cost(film.getReplacement_cost());
              dto.setSpecial_features(film.getSpecial_features());
              return dto;
          }
        ).collect(Collectors.toList());
    }

    @Override
    public FilmDTO createFilm(FilmDTO filmDTO) {
        Film film = new Film();
        film.setDescription(filmDTO.getDescription());
        film.setLength(filmDTO.getLength());
        film.setRating(filmDTO.getRating());
        film.setLanguage_id(filmDTO.getLanguage_id());
        //film.setLast_update(filmDTO.getLast_update());
        film.setRelease_year(filmDTO.getRelease_year());
        film.setSpecial_features(filmDTO.getSpecial_features());
        film.setRental_duration(filmDTO.getRental_duration());
        film.setTitle(filmDTO.getTitle());
        film.setReplacement_cost(filmDTO.getReplacement_cost());
        film.setSpecial_features(filmDTO.getSpecial_features());
        film.setRental_rate(filmDTO.getRental_rate());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        film.setLast_update(timestamp);

        Film filmModel = filmRepository.saveAndFlush(film);

        return Stream.of(filmModel)
                .map(e -> {
                    FilmDTO d = new FilmDTO();
                    d.setFilmId(e.getFilmId());
                    d.setDescription(e.getDescription());
                    d.setLength(e.getLength());
                    d.setRating(e.getRating());
                    d.setLanguage_id(e.getLanguage_id());

                    Timestamp timestampRes = e.getLast_update();
                    SimpleDateFormat dateFormatRes = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
                    String dateString = dateFormatRes.format(timestampRes);
                    d.setLast_update(dateString);

                    d.setRelease_year(e.getRelease_year());
                    d.setSpecial_features(e.getSpecial_features());
                    d.setRental_duration(e.getRental_duration());
                    d.setTitle(e.getTitle());
                    d.setReplacement_cost(e.getReplacement_cost());
                    d.setSpecial_features(e.getSpecial_features());
                    d.setRental_rate(e.getRental_rate());
                    return d;
                })
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<FilmDTO> getFilmsByYear(String year) {
        return filmRepository.findByReleaseYear(year).stream().map(
                film -> {
                    FilmDTO dto = new FilmDTO();
                    dto.setFilmId(film.getFilmId());
                    dto.setDescription(film.getDescription());
                    dto.setLength(film.getLength());
                    dto.setRating(film.getRating());
                    dto.setLanguage_id(film.getLanguage_id());

                    Timestamp timestampRes = film .getLast_update();
                    SimpleDateFormat dateFormatRes = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
                    String dateString = dateFormatRes.format(timestampRes);
                    dto.setLast_update(dateString);

                    dto.setRelease_year(film.getRelease_year());
                    dto.setRental_rate(film.getRental_rate());
                    dto.setTitle(film.getTitle());
                    dto.setRental_duration(film.getRental_duration());
                    dto.setReplacement_cost(film.getReplacement_cost());
                    dto.setSpecial_features(film.getSpecial_features());
                    return dto;
                }
        ).collect(Collectors.toList());
    }
}
