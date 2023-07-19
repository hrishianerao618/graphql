package com.graphql.graphqltest.service;

import com.graphql.graphqltest.dto.CityDTO;
import com.graphql.graphqltest.dto.CountryDTO;
import com.graphql.graphqltest.model.City;
import com.graphql.graphqltest.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CityService {
    public List<CityDTO> getAllCitiesByCountryId(CountryDTO countryDTO);
    public Integer getCountOfCities(CountryDTO countryDTO);

    public CityDTO getCityById(Integer cityId);

}
