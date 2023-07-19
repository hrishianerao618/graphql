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

    @Override
    public Integer getCountOfCities(CountryDTO countryDTO){
        return cityRepository.findAllByCountryCountryId(countryDTO.getCountryId()).size();
    }

    @Override
    public CityDTO getCityById(Integer cityId) {
        City city = cityRepository.findById(cityId).get();
        CityDTO cityDTO = new CityDTO();
        cityDTO.setCity(city.getCity());
        cityDTO.setLastUpdate(city.getLastUpdate());
        cityDTO.setCityId(city.getCityId());
        cityDTO.setCountry(city.getCountry().getCountryId());
        return cityDTO;

    }

}
