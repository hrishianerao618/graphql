package com.graphql.graphqltest.dto;

public class CategoryDTO {
    private int categoryId;
    private String name;
    private String lastUpdate;

    public CategoryDTO(int categoryId, String name, String lastUpdate) {
        this.categoryId = categoryId;
        this.name = name;
        this.lastUpdate = lastUpdate;
    }
}
