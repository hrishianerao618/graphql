package com.graphql.graphqltest.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer actorId ;
    private String firstName ;
    private String lastName ;
    private Timestamp lastUpdate ;

    public Actor() {
    }

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

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }
}
