package com.graphql.graphqltest.service.impl;

import com.graphql.graphqltest.dto.FilmDTO;
import com.graphql.graphqltest.repository.FilmRepository;
import com.graphql.graphqltest.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
              dto.setFulltext(film.getFulltext());
              dto.setLength(film.getLength());
              dto.setRating(film.getRating());
              dto.setLanguage_id(film.getLanguage_id());
              dto.setLast_update(film.getLast_update());
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
