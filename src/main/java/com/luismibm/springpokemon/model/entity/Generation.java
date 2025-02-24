package com.luismibm.springpokemon.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity @Table(name = "GENERATION")
public class Generation {

    @Id
    private long generation_id;
    private String generation_name;

    @OneToOne
    @JsonIgnoreProperties("generation")
    private Region region;

    @OneToMany(mappedBy = "generation")
    @JsonManagedReference
    private List<Starter> starters;

    public Generation(){}
    public Generation(long id, String name) {
        generation_id = id;
        generation_name = name;
    }

    public long getGeneration_id() {
        return generation_id;
    }

    public void setGeneration_id(long generation_id) {
        this.generation_id = generation_id;
    }

    public String getGeneration_name() {
        return generation_name;
    }

    public void setGeneration_name(String generation_name) {
        this.generation_name = generation_name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Starter> getStarters() {
        return starters;
    }

    public void setStarters(List<Starter> starters) {
        this.starters = starters;
    }

}