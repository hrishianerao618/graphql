package com.graphql.graphqltest.resolver;

import com.graphql.graphqltest.dto.CityDTO;
import com.graphql.graphqltest.dto.CountryDTO;
import com.graphql.graphqltest.service.CountryService;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityFieldResolver implements GraphQLResolver<CityDTO> {
    @Autowired
    CountryService countryService;

    public CountryDTO getCountry(CityDTO cityDTO) {
        return countryService.getCountryById(cityDTO.getCountry());
    }
}
