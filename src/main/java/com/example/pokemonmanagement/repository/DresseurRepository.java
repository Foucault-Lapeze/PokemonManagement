package com.example.pokemonmanagement.repository;

import com.example.pokemonmanagement.entity.Dresseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DresseurRepository extends JpaRepository<Dresseur, Long> {
}