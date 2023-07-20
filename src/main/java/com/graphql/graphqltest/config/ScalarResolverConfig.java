package com.graphql.graphqltest.config;

import graphql.Scalars;
import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScalarResolverConfig {

    @Bean
    public GraphQLScalarType DateTime() {
        return ExtendedScalars.DateTime;
    }

    @Bean
    public GraphQLScalarType SpecialLink() {
        return ExtendedScalars.newAliasedScalar("SpecialLink").aliasedScalar(Scalars.GraphQLString).build();
    }

}
