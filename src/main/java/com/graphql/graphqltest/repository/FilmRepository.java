package com.graphql.graphqltest.repository;

import com.graphql.graphqltest.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    public Page<Film> findAll(Pageable pageable);
}
