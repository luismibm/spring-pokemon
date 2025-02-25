package com.luismibm.springpokemon.controller;

import com.luismibm.springpokemon.model.entity.Generation;
import com.luismibm.springpokemon.model.repository.GenerationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @RequestMapping("/generations")
public class GenerationRestController {

    @Autowired
    private GenerationRepository generationRepository;

    @GetMapping
    public List<Generation> getGenerations() {
        return (List<Generation>) generationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Generation> getGenerationById(@PathVariable(value = "id") Long id) {
        Optional<Generation> g = generationRepository.findById(id);
        if (g.isPresent()) {
            return ResponseEntity.ok().body(g.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Generation createGeneration(@RequestBody Generation g) {
        return generationRepository.save(g);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Generation> updateGeneration(@PathVariable Long id, @RequestBody Generation updatedGeneration) {
        Optional<Generation> optionalGeneration = generationRepository.findById(id);
        if (optionalGeneration.isPresent()) {
            Generation generation = optionalGeneration.get();
            generation.setGeneration_name(updatedGeneration.getGeneration_name());
            return ResponseEntity.ok().body(generationRepository.save(generation));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteGeneration(@PathVariable Long id) {
        generationRepository.deleteById(id);
    }

}