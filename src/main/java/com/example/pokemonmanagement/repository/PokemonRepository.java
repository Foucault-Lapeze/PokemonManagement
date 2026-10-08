package com.example.pokemonmanagement.repository;

import com.example.pokemonmanagement.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    List<Pokemon> findByDresseurId(Long dresseurId);
}