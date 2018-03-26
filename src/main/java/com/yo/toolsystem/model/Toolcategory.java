package com.yo.toolsystem.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Toolcategory {

    private Integer id;

    @NotNull
    @Size(min = 1,max = 16)
    private String category;

    public Toolcategory(Integer id, String category) {
        this.id = id;
        this.category = category;
    }

    public Toolcategory() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

}