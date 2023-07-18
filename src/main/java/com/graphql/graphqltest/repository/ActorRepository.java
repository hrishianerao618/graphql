package com.graphql.graphqltest.repository;

import com.graphql.graphqltest.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
public Actor findByActorId(Integer actorId);
}
