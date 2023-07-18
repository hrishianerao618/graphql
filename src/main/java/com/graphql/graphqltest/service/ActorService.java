package com.graphql.graphqltest.service;

import com.graphql.graphqltest.dto.ActorDTO;
import com.graphql.graphqltest.model.Actor;
import org.springframework.stereotype.Service;

public interface ActorService{
    public ActorDTO saveActor(ActorDTO actorDTO);

    public ActorDTO getActor(Integer actorId);
}
