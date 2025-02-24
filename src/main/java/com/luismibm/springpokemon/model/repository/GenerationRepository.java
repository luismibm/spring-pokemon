package com.luismibm.springpokemon.model.repository;

import com.luismibm.springpokemon.model.entity.Generation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenerationRepository extends CrudRepository<Generation, Long> { }