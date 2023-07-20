package com.graphql.graphqltest.dto;

import java.sql.Timestamp;
import java.time.OffsetDateTime;

public class ActorDTO {
    public Integer actorId;
    private String firstName ;
    private String lastName ;
    private OffsetDateTime lastUpdate ;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public OffsetDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public ActorDTO() {
    }

}
