package com.graphql.graphqltest.config;

import com.graphql.graphqltest.directive.UppercaseDirective;
import graphql.kickstart.tools.boot.SchemaDirective;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DirectiveConfig {
    @Bean
    public SchemaDirective upperCaseDirective(){
        return  new SchemaDirective("uppercase", new UppercaseDirective());
    }
}
