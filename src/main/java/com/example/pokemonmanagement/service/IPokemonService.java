package com.example.pokemonmanagement.service;

import com.example.pokemonmanagement.dto.PokemonDto;
import java.util.List;

public interface IPokemonService {
    List<PokemonDto> getAllPokemons();
    PokemonDto getPokemonById(Long id);
    Boolean existPokemon(Long id);

    List<PokemonDto> getPokemons(Long dresseurId);
}