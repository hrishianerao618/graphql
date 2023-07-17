package com.graphql.graphqltest.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "COUNTRY", schema = "PUBLIC")
public class Country {
    @Id
    private Integer countryId ;
    private String country;
    private String lastUpdate ;
    @OneToMany(mappedBy = "country")
    private List<City> cities;

    public Country(){

    }

    public Country(Integer countryId, String country, String lastUpdate, List<City> cities) {
        this.countryId = countryId;
        this.country = country;
        this.lastUpdate = lastUpdate;
        this.cities = cities;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public String getCountry() {
        return country;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public List<City> getCities() {
        return cities;
    }
}
