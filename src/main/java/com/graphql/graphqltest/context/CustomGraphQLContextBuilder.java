package com.graphql.graphqltest.context;

import graphql.kickstart.execution.context.GraphQLContext;
import graphql.kickstart.execution.context.GraphQLContextBuilder;
import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.servlet.context.DefaultGraphQLWebSocketContext;
import graphql.kickstart.servlet.context.GraphQLServletContextBuilder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.websocket.server.HandshakeRequest;

@Component
public class CustomGraphQLContextBuilder implements GraphQLServletContextBuilder {

    @Override
    public GraphQLContext build(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String userId = httpServletRequest.getHeader("user_id");
        DefaultGraphQLServletContext defaultGraphQLServletContext = DefaultGraphQLServletContext.createServletContext()
                .with(httpServletRequest)
                .with(httpServletResponse)
                .build();
        return new CustomGraphQLContext(userId,defaultGraphQLServletContext);
    }

    @Override
    public GraphQLContext build(Session session, HandshakeRequest handshakeRequest) {
        return DefaultGraphQLWebSocketContext.createWebSocketContext().
                with(session)
                .with(handshakeRequest)
                .build();
    }


    @Override
    public GraphQLContext build() {
        return null;
    }
}
