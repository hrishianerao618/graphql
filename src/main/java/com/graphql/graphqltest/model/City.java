package com.graphql.graphqltest.model;

import javax.persistence.*;

@Entity
@Table(name = "CITY")
public class City {
    @Id
    private Integer cityId ;
    private String city;
    private String lastUpdate;

    @ManyToOne
    @JoinColumn(name = "countryId")
    private Country country;

    public int getCityId() {
        return cityId;
    }

    public String getCity() {
        return city;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public Country getCountry() {
        return country;
    }

    public City(Integer cityId, String city, String lastUpdate, Country country) {
        this.cityId = cityId;
        this.city = city;
        this.lastUpdate = lastUpdate;
        this.country = country;
    }

    public City(){

    }
}
