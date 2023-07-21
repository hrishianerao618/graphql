package com.graphql.graphqltest.directive;

import graphql.schema.*;
import graphql.schema.idl.SchemaDirectiveWiring;
import graphql.schema.idl.SchemaDirectiveWiringEnvironment;

import java.util.Objects;


public class UppercaseDirective implements SchemaDirectiveWiring {
    @Override
    public GraphQLFieldDefinition onField(SchemaDirectiveWiringEnvironment<GraphQLFieldDefinition> env) {
        GraphQLFieldDefinition field = env.getElement();
        GraphQLFieldsContainer parentType = env.getFieldsContainer();
        DataFetcher originalDataFetcher = env.getCodeRegistry().getDataFetcher(parentType, field);

        DataFetcher dataFetcher = DataFetcherFactories.wrapDataFetcher(originalDataFetcher, ((dataFetchingEnvironment, value) -> {
            if (Objects.isNull(value))
                return null;
            return ((String) value).toUpperCase();
        }
        ));

        FieldCoordinates fieldCoordinates = FieldCoordinates.coordinates(parentType, field);
        env.getCodeRegistry().dataFetcher(fieldCoordinates,dataFetcher);
        return field;
    }
}