package com.luismibm.springpokemon.controller;

import com.luismibm.springpokemon.model.entity.Generation;
import com.luismibm.springpokemon.model.repository.GenerationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping("/generations")
public class GenerationRestController {

    @Autowired
    private GenerationRepository generationRepository;

    @GetMapping
    public List<Generation> getGenerations() {
        return (List<Generation>) generationRepository.findAll();
    }

}