package com.example.pokemonmanagement.repository;

import com.example.pokemonmanagement.entity.Dresseur;
import com.example.pokemonmanagement.entity.Pokemon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
class PokemonRepositoryTest {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private DresseurRepository dresseurRepository;

    @Test
    void should_return_pokemon_list_when_dresseur_has_pokemons() {
        Dresseur dresseur = new Dresseur();
        dresseur.setNom("Sacha");
        Dresseur savedDresseur = dresseurRepository.save(dresseur);

        Pokemon pokemon = new Pokemon();
        pokemon.setNom("Pikachu");
        pokemon.setDresseur(savedDresseur);
        pokemonRepository.save(pokemon);

        Pokemon pokemon1 = new Pokemon();
        pokemon1.setNom("Dracaufeu");
        pokemon1.setDresseur(savedDresseur);
        pokemonRepository.save(pokemon1);

        List<Pokemon> pokemons = pokemonRepository.findByDresseurId(savedDresseur.getId());

        assertFalse(pokemons.isEmpty());
        assertEquals(2, pokemons.size());
    }
}