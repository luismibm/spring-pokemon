package com.luismibm.springpokemon.model.repository;

import com.luismibm.springpokemon.model.entity.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends CrudRepository<Region, Long> { }
