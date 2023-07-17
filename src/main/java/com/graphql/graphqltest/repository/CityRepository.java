package com.graphql.graphqltest.repository;

import com.graphql.graphqltest.model.City;
import com.graphql.graphqltest.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    public List<City> findAllByCountryCountryId(Integer countryId);
}
