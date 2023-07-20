package com.graphql.graphqltest.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import com.graphql.graphqltest.dto.CityDTO;
import com.graphql.graphqltest.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityQueryResolver implements GraphQLQueryResolver {
    @Autowired
    CityService cityService;

    public CityDTO city(Integer cityId) {
        return cityService.getCityById(cityId);
    }
}
