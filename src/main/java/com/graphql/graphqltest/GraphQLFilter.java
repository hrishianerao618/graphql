package com.graphql.graphqltest;

import com.graphql.graphqltest.resolver.FilmQueryResolver;
import graphql.kickstart.servlet.core.GraphQLServletListener;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class GraphQLFilter implements GraphQLServletListener {//use to intercept HTTP graphql calls
    Logger logger = Logger.getLogger(GraphQLFilter.class.getName());
    private final Clock clock = Clock.systemDefaultZone();
    @Override
    public RequestCallback onRequest(HttpServletRequest request, HttpServletResponse response) {
        Instant startTime = Instant.now();
        return new RequestCallback() {
            @Override
            public void onError(HttpServletRequest request, HttpServletResponse response, Throwable throwable) {
                RequestCallback.super.onError(request, response, throwable);
            }

            @Override
            public void onSuccess(HttpServletRequest request, HttpServletResponse response) {
                RequestCallback.super.onSuccess(request, response);
            }

            @Override
            public void onFinally(HttpServletRequest request, HttpServletResponse response) {
                logger.log(Level.INFO,"Total Time taken: "+ Duration.between(startTime,Instant.now()).toString());
            }
        };
    }
}
