package com.luismibm.springpokemon.controller;

import com.luismibm.springpokemon.model.entity.Type;
import com.luismibm.springpokemon.model.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @RequestMapping("/types")
public class TypeRestController {

    @Autowired
    private TypeRepository typeRepository;

    @GetMapping
    public List<Type> getTypes() {
        return (List<Type>) typeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Type> getTypeById(@PathVariable Long id) {
        Optional<Type> t = typeRepository.findById(id);
        if (t.isPresent()) {
            return ResponseEntity.ok().body(t.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Type createType(@RequestBody Type type) {
        return typeRepository.save(type);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Type> updateType(@PathVariable Long id, @RequestBody Type updatedType) {
        Optional<Type> t = typeRepository.findById(id);
        if (t.isPresent()) {
            Type type = t.get();
            type.setType_name(updatedType.getType_name());
            return ResponseEntity.ok().body(typeRepository.save(type));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteType(@PathVariable Long id) {
        typeRepository.deleteById(id);
    }

}