package com.graphql.graphqltest.repository;

import com.graphql.graphqltest.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{
    public Optional<Country> findById(Integer countryId);
}
