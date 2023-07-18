package com.graphql.graphqltest.service.impl;

import com.graphql.graphqltest.dto.ActorDTO;
import com.graphql.graphqltest.dto.CountryDTO;
import com.graphql.graphqltest.model.Actor;
import com.graphql.graphqltest.repository.ActorRepository;
import com.graphql.graphqltest.service.ActorService;
import com.sun.istack.internal.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;

@Service
public class ActorServiceImpl implements ActorService {
    @Autowired
    ActorRepository actorRepository;

    @Override
    public ActorDTO saveActor(ActorDTO actorDTO) {
        Actor actor = new Actor();
        actor.setFirstName(actorDTO.getFirstName());
        actor.setLastName(actorDTO.getLastName());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        actor.setLastUpdate(timestamp);
        Actor actorModel = actorRepository.saveAndFlush(actor);
        System.out.print("Actor: "+actorModel.getActorId());
        return Stream.of(actor)
                .map(e -> {
                    ActorDTO d = new ActorDTO();
                    d.setActorId(e.getActorId());
                    d.setFirstName(e.getFirstName());
                    d.setLastName(e.getLastName());
                    Timestamp timestampRes = e.getLastUpdate();
                    SimpleDateFormat dateFormatRes = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
                    String dateString = dateFormatRes.format(timestampRes);
                    d.setLastUpdate(dateString);
                    return d;
                })
                .findFirst()
                .orElse(null);

    }

    @Override
    public ActorDTO getActor(Integer actorId) {
        Actor actor = actorRepository.findByActorId(actorId);
        return Stream.of(actor)
                .map(e -> {
                    ActorDTO d = new ActorDTO();
                    d.setActorId(e.getActorId());
                    d.setFirstName(e.getFirstName());
                    d.setLastName(e.getLastName());
                    Timestamp timestamp = e.getLastUpdate();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
                    String dateString = dateFormat.format(timestamp);
                    d.setLastUpdate(dateString);
                    return d;
                })
                .findFirst()
                .orElse(null);
    }
}
