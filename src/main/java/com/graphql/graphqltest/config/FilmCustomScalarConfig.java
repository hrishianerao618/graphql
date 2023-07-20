package com.graphql.graphqltest.config;

import graphql.language.StringValue;
import graphql.schema.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Configuration
public class FilmCustomScalarConfig {

    @Bean
    public GraphQLScalarType  year(){
        return new GraphQLScalarType("year", "films By Year", new Coercing() {
            @Override
            public Object serialize(Object result) throws CoercingSerializeException {
                if(result instanceof StringValue){
                    return result.toString();
                }
                throw new CoercingSerializeException();
            }

            @Override
            public Object parseValue(Object result) throws CoercingParseValueException {//used when passing inputs from args of graphql query
                System.out.println("Hello There:");
                if(result instanceof  StringValue){
                    String year = result.toString();
                    System.out.println("Year:"+ year);
                    if(Pattern.matches("(?:200[0-9]|201[0-9]|2020)",year)){
                        return result.toString();
                    }
                }
                throw new CoercingParseValueException("Invalid year , year should be between 2000-2020");
            }

            @Override
            public Object parseLiteral(Object result) throws CoercingParseLiteralException {//used when setting inputs from args of graphql query
                System.out.println("Hello:");
                if(result instanceof  StringValue){
                    String year = result.toString();

                    if(Pattern.matches("(?:200[0-9]|201[0-9]|2020)",year)){
                        return result.toString();
                    }
                }
                throw new CoercingParseLiteralException("Invalid year , year should be between 2000-2020");
            }
        });
    }
}
