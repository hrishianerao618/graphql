package com.graphql.graphqltest.service.impl;

import com.graphql.graphqltest.dto.CityDTO;
import com.graphql.graphqltest.dto.CountryDTO;
import com.graphql.graphqltest.model.City;
import com.graphql.graphqltest.model.Country;
import com.graphql.graphqltest.repository.CityRepository;
import com.graphql.graphqltest.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityRepository cityRepository;
    @Override
    public List<CityDTO> getAllCitiesByCountryId(CountryDTO countryDTO) {
        System.out.println("countryDTO:"+countryDTO);
        return cityRepository.findAllByCountryCountryId(countryDTO.getCountryId()).stream()
                .map(entity -> {
                    CityDTO dto = new CityDTO(entity.getCityId(),entity.getCity(),entity.getLastUpdate());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
