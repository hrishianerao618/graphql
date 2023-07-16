package com.graphql.graphqltest.resolver;

import org.springframework.stereotype.Component;

@Component
public class GraphQLResolver implements com.coxautodev.graphql.tools.GraphQLQueryResolver {
    public String firstGraphQuery(){
        System.out.println("Here");
        return "first GraphQlResolver";
    }
}
