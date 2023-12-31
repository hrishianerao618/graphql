package com.graphql.graphqltest.resolver;

import graphql.kickstart.tools.GraphQLResolver;
import com.graphql.graphqltest.dto.CityDTO;
import com.graphql.graphqltest.dto.CountryDTO;
import com.graphql.graphqltest.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryFieldResolver implements GraphQLResolver<CountryDTO> {
    @Autowired
    CityService cityService;
    public List<CityDTO> getCities(CountryDTO countryDTO){
        return cityService.getAllCitiesByCountryId(countryDTO);
    }

    public Integer getCountCity(CountryDTO countryDTO){
        return cityService.getCountOfCities(countryDTO);
    }
}
