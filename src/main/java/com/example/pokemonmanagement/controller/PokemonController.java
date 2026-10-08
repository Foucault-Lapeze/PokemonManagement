package com.example.pokemonmanagement.controller;

import com.example.pokemonmanagement.dto.PokemonDto;
import com.example.pokemonmanagement.service.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    @Autowired
    private IPokemonService pokemonService;

    @GetMapping("/all")
    public ResponseEntity<List<PokemonDto>> getAllPokemons() {
        List<PokemonDto> pokemons = pokemonService.getAllPokemons();
        return ResponseEntity.ok(pokemons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonDto> getPokemonById(@PathVariable Long id) {
        if (!pokemonService.existPokemon(id)) {
            return ResponseEntity.notFound().build();
        }
        PokemonDto dto = pokemonService.getPokemonById(id);
        return ResponseEntity.ok(dto);
    }

}