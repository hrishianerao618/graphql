package com.graphql.graphqltest.resolver;

import com.graphql.graphqltest.dto.ActorDTO;
import com.graphql.graphqltest.dto.CategoryDTO;
import com.graphql.graphqltest.dto.CityDTO;
import com.graphql.graphqltest.dto.CountryDTO;
import com.graphql.graphqltest.model.Country;
import com.graphql.graphqltest.service.ActorService;
import com.graphql.graphqltest.service.CityService;
import com.graphql.graphqltest.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class GraphQLResolver<C> implements com.coxautodev.graphql.tools.GraphQLQueryResolver {
    @Autowired
    CountryService countryService;

    @Autowired
    ActorService actorService;
    public String firstGraphQuery(){
        System.out.println("Here");
        return "first GraphQlResolver";
    }

    public String secondGraphQuery(String firstParam,String secondParam){
        return "second GraphQlResolver "+firstParam+ " "+secondParam;
    }

    public CategoryDTO getCategory(){
       return new CategoryDTO(1, "Automobile",  "23-03-23");
    }

    public List<Integer> getSampleArr(){
        return Arrays.asList(1,2,3,4);
    }

    public CountryDTO country(Integer countryId){
        return  countryService.getCountryById(countryId);
    }

    public ActorDTO actor(Integer actorId){
        return actorService.getActor(actorId);
    }
}
