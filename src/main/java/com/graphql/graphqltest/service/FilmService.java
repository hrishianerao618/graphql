package com.graphql.graphqltest.service;

import com.graphql.graphqltest.dto.FilmDTO;

import java.util.List;

public interface FilmService {
    public List<FilmDTO> getALLFilms(int pageNo, int size);

    FilmDTO createFilm(FilmDTO filmDTO);

    List<FilmDTO> getFilmsByYear(String year);
}
