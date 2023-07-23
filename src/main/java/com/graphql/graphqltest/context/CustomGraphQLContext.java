package com.graphql.graphqltest.context;

import graphql.kickstart.execution.context.GraphQLContext;
import graphql.kickstart.servlet.context.GraphQLServletContext;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dataloader.DataLoaderRegistry;
import org.springframework.stereotype.Component;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Getter
public class CustomGraphQLContext implements GraphQLServletContext {

    private String userId;
    private final GraphQLServletContext graphQLServletContext;

    @Override
    public List<Part> getFileParts() {
        return graphQLServletContext.getFileParts();
    }

    @Override
    public Map<String, List<Part>> getParts() {
        return graphQLServletContext.getParts();
    }

    @Override
    public HttpServletRequest getHttpServletRequest() {
        return graphQLServletContext.getHttpServletRequest();
    }

    @Override
    public HttpServletResponse getHttpServletResponse() {
        return graphQLServletContext.getHttpServletResponse();
    }

    @Override
    public Optional<Subject> getSubject() {
        return graphQLServletContext.getSubject();
    }

    @Override
    public @lombok.NonNull DataLoaderRegistry getDataLoaderRegistry() {
        return graphQLServletContext.getDataLoaderRegistry();
    }


}
