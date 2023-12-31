package com.graphql.graphqltest.service.impl;

import com.graphql.graphqltest.dto.CountryDTO;
import com.graphql.graphqltest.exception.DataNotFoundException;
import com.graphql.graphqltest.model.Country;
import com.graphql.graphqltest.repository.CountryRepository;
import com.graphql.graphqltest.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    CountryRepository countryRepository;
    @Override
    public CountryDTO getCountryById(Integer countryId) {
        Optional<Country> countryModelOptional = countryRepository.findById(countryId);
        Country countryModel = countryModelOptional.orElseThrow(()-> new DataNotFoundException("Country Not Found"));
        return Stream.of(countryModel)
                .map(e -> {
                    CountryDTO d = new CountryDTO(e.getCountryId(),e.getCountry(), e.getLastUpdate());
                    return d;
                })
                .findFirst()
                .orElse(null);
    }
}
