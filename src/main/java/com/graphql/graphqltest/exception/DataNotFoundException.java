package com.graphql.graphqltest.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphQLException;
import graphql.language.SourceLocation;
import graphql.servlet.GraphQLErrorHandler;

import java.util.List;
import java.util.Map;

public class DataNotFoundException extends RuntimeException implements GraphQLError {

    String errorMsg;
    public DataNotFoundException(String errorMsg){
        super(errorMsg);
        this.errorMsg = errorMsg;
    }


    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }

    @Override
    public List<Object> getPath() {
        return GraphQLError.super.getPath();
    }

    @Override
    public Map<String, Object> toSpecification() {
        return GraphQLError.super.toSpecification();
    }

    @Override
    public Map<String, Object> getExtensions() {
        return GraphQLError.super.getExtensions();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
      //  return super.getStackTrace(); //original
        return null;// to stop stacktrace from displaying to client
    }
}
