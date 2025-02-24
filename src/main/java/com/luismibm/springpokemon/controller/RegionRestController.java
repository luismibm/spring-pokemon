package com.luismibm.springpokemon.controller;

import com.luismibm.springpokemon.model.entity.Region;
import com.luismibm.springpokemon.model.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController@RequestMapping("/regions")
public class RegionRestController {

    @Autowired
    private RegionRepository regionRepository;

    @GetMapping
    public List<Region> getRegions() {
        return (List<Region>) regionRepository.findAll();
    }

}