package com.graphql.graphqltest.service;

import com.graphql.graphqltest.dto.CountryDTO;
import com.graphql.graphqltest.model.Country;
import org.springframework.stereotype.Service;


public interface CountryService{
    public CountryDTO getCountryById(Integer countryId);
}
