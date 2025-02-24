package com.luismibm.springpokemon.controller;

import com.luismibm.springpokemon.model.entity.Starter;
import com.luismibm.springpokemon.model.repository.StarterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping("/starters")
public class StarterRestController {

    @Autowired
    private StarterRepository starterRepository;

    @GetMapping
    public List<Starter> getStarters() {
        return (List<Starter>) starterRepository.findAll();
    }

}
