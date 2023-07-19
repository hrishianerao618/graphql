package com.graphql.graphqltest.dto;

import com.graphql.graphqltest.model.Country;

public class CityDTO {
    private int cityId ;
    private String city;
    private String lastUpdate;

    private Integer countryId;

    public CityDTO(int cityId, String city, String lastUpdate) {
        this.cityId = cityId;
        this.city = city;
        this.lastUpdate = lastUpdate;
    }

    public int getCityId() {
        return cityId;
    }

    public String getCity() {
        return city;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getCountry() {
        return countryId;
    }

    public void setCountry(Integer countryId) {
        this.countryId = countryId;
    }

    public CityDTO() {
    }
}
