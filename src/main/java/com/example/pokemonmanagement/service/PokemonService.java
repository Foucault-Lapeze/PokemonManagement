package com.example.pokemonmanagement.service;

import com.example.pokemonmanagement.dto.PokemonDto;
import com.example.pokemonmanagement.entity.Pokemon;
import com.example.pokemonmanagement.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonService implements IPokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Override
    public List<PokemonDto> getAllPokemons() {
        return pokemonRepository.findAll().stream()
                .map(this::toPokemonDto)
                .collect(Collectors.toList());
    }

    @Override
    public PokemonDto getPokemonById(Long id) {
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow();
        return toPokemonDto(pokemon);
    }

    @Override
    public Boolean existPokemon(Long id) {
        return pokemonRepository.existsById(id);
    }

    @Override
    public List<PokemonDto> getPokemons(Long dresseurId) {
        return pokemonRepository.findByDresseurId(dresseurId).stream()
                .map(this::toPokemonDto)
                .collect(Collectors.toList());
    }

    private PokemonDto toPokemonDto(Pokemon entity) {
        PokemonDto dto = new PokemonDto();
        dto.setId(entity.getId());
        dto.setNom(entity.getNom());
        dto.setType(entity.getType());
        dto.setNiveau(entity.getNiveau());
        return dto;
    }
}