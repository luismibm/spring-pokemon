package com.luismibm.springpokemon.controller;

import com.luismibm.springpokemon.model.entity.Starter;
import com.luismibm.springpokemon.model.repository.StarterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @RequestMapping("/starters")
public class StarterRestController {

    @Autowired
    private StarterRepository starterRepository;

    @GetMapping
    public List<Starter> getStarters() {
        return (List<Starter>) starterRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Starter> getStarterById(@PathVariable Long id) {
        Optional<Starter> s = starterRepository.findById(id);
        if (s.isPresent()) {
            return ResponseEntity.ok().body(s.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Starter createStarter(@RequestBody Starter starter) {
        return starterRepository.save(starter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Starter> updateStarter(@PathVariable Long id, @RequestBody Starter updatedStarter) {
        Optional<Starter> s = starterRepository.findById(id);
        if (s.isPresent()) {
            Starter starter = s.get();
            starter.setStarter_name(updatedStarter.getStarter_name());
            return ResponseEntity.ok().body(starterRepository.save(starter));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteStarter(@PathVariable Long id) {
        starterRepository.deleteById(id);
    }

}
