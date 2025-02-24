package com.luismibm.springpokemon.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity @Table(name = "STARTER")
public class Starter {

    @Id
    private long starter_id;
    private String starter_name;

    @ManyToOne
    @JoinColumn(name = "generation_id")
    private Generation generation;

    @ManyToMany @JoinTable(
            name = "STARTER-TYPE",
            joinColumns = @JoinColumn(name = "type_id"),
            inverseJoinColumns = @JoinColumn(name = "starter_id")
    )
    List<Type> types;

    public Starter(){}
    public Starter(long id, String name) {
        starter_id = id;
        starter_name = name;
    }

    public long getStarter_id() {
        return starter_id;
    }

    public void setStarter_id(long starter_id) {
        this.starter_id = starter_id;
    }

    public String getStarter_name() {
        return starter_name;
    }

    public void setStarter_name(String starter_name) {
        this.starter_name = starter_name;
    }

    public Generation getGeneration() {
        return generation;
    }

    public void setGeneration(Generation generation) {
        this.generation = generation;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

}