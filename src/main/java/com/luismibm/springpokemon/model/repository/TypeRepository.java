package com.luismibm.springpokemon.model.repository;

import com.luismibm.springpokemon.model.entity.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends CrudRepository<Type, Long> { }