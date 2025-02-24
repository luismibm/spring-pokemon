package com.luismibm.springpokemon.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity @Table(name = "TYPE")
public class Type {

    @Id
    private long type_id;
    private String type_name;

    @ManyToMany(mappedBy = "types")
    private List<Starter> starter;

    public Type(){}
    public Type(long id, String name) {
        type_id = id;
        type_name = name;
    }

    public long getType_id() {
        return type_id;
    }

    public void setType_id(long type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public List<Starter> getStarter() {
        return starter;
    }

    public void setStarter(List<Starter> starter) {
        this.starter = starter;
    }

}