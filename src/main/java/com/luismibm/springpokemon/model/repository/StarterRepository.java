package com.luismibm.springpokemon.model.repository;

import com.luismibm.springpokemon.model.entity.Starter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarterRepository extends CrudRepository<Starter, Long> { }
