package com.luismibm.springpokemon.controller;

import com.luismibm.springpokemon.model.entity.Type;
import com.luismibm.springpokemon.model.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping("/types")
public class TypeRestController {

    @Autowired
    private TypeRepository typeRepository;

    @GetMapping
    public List<Type> getTypes() {
        return (List<Type>) typeRepository.findAll();
    }

}