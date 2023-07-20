package com.graphql.graphqltest.exception.handler;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;

import java.util.List;
import java.util.stream.Collectors;

public class CustomExceptionHandler implements GraphQLErrorHandler {
    @Override
    public boolean errorsPresent(List<GraphQLError> errors) {
        return GraphQLErrorHandler.super.errorsPresent(errors);
    }

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> list) {
        return list.stream().map(this::getError).collect(Collectors.toList());
    }

    private GraphQLError getError(GraphQLError graphQLError) {
        if(graphQLError instanceof ExceptionWhileDataFetching){//ExceptionWhileDataFetching is customer exception available in graphql handler
            ExceptionWhileDataFetching ex = (ExceptionWhileDataFetching) graphQLError;

            if(ex.getException() instanceof  GraphQLError){
                return ex;
            }
        }

        return graphQLError;
    }
}
