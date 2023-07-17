package com.graphql.graphqltest.resolver;

import com.graphql.graphqltest.dto.CategoryDTO;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class GraphQLResolver implements com.coxautodev.graphql.tools.GraphQLQueryResolver {
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
}
