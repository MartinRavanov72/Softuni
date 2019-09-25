package org.softuni.mostwanted.domain.dtos.json;

import com.google.gson.annotations.Expose;

public class DistrictJSONImportDto {
    @Expose
    private String name;

    @Expose
    private String townName;

    public DistrictJSONImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }
}
