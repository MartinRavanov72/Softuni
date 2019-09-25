package org.softuni.mostwanted.domain.dtos.json;

import com.google.gson.annotations.Expose;

public class TownJSONImportDto {
    @Expose
    private String name;

    public TownJSONImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
