package com.luismibm.springpokemon.controller;

import com.luismibm.springpokemon.model.entity.Region;
import com.luismibm.springpokemon.model.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @RequestMapping("/regions")
public class RegionRestController {

    @Autowired
    private RegionRepository regionRepository;

    @GetMapping
    public List<Region> getRegions() {
        return (List<Region>) regionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> getRegionById(@PathVariable Long id){
        Optional<Region> r = regionRepository.findById(id);
        if (r.isPresent()) {
            return ResponseEntity.ok().body(r.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Region createRegion(@RequestBody Region region) {
        return regionRepository.save(region);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Region> updateRegion(@PathVariable Long id, @RequestBody Region updatedRegion) {
        Optional<Region> r = regionRepository.findById(id);
        if (r.isPresent()) {
            Region region = r.get();
            region.setRegion_name(updatedRegion.getRegion_name());
            return ResponseEntity.ok().body(regionRepository.save(region));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteRegion(@PathVariable Long id) {
        regionRepository.deleteById(id);
    }

}