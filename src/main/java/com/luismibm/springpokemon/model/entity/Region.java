package com.luismibm.springpokemon.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity @Table(name = "REGION")
public class Region {

    @Id
    private long region_id;
    private String region_name;

    @OneToOne(mappedBy = "region")
    private Generation region;

    public Region(){}
    public Region(long id, String name) {
        region_id = id;
        region_name = name;
    }

    public long getRegion_id() {
        return region_id;
    }

    public void setRegion_id(long region_id) {
        this.region_id = region_id;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public Generation getRegion() {
        return region;
    }

    public void setRegion(Generation region) {
        this.region = region;
    }

}