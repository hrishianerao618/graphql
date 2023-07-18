package com.graphql.graphqltest.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.graphqltest.dto.ActorDTO;
import com.graphql.graphqltest.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActorMutationResolver implements GraphQLMutationResolver {
    @Autowired
ActorService actorService;

    public ActorDTO createActor(ActorDTO actorDTO){
        System.out.print("Actor ID insert started!!");
        ActorDTO actorDTORes = actorService.saveActor(actorDTO);
        System.out.print("Actor ID inserted: "+actorDTORes.getActorId());
        return actorDTORes;
    }
}
