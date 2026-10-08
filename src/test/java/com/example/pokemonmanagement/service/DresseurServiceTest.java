package com.example.pokemonmanagement.service;

import com.example.pokemonmanagement.dto.DresseurDto;
import com.example.pokemonmanagement.entity.Dresseur;
import com.example.pokemonmanagement.entity.Pokemon;
import com.example.pokemonmanagement.repository.DresseurRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DresseurServiceTest {

    @Mock
    private DresseurRepository dresseurRepository;

    @InjectMocks
    private DresseurService dresseurService;

    @Test
    void should_return_level_1_when_dresseur_has_zero_pokemon() {
        Dresseur dresseur = new Dresseur();
        dresseur.setNom("Jeune Dresseur");
        dresseur.setPokemons(new ArrayList<>());

        DresseurDto result = dresseurService.toDto(dresseur);

        assertEquals(1, result.getLevelDresseur());
        assertEquals(0, result.getNbPokemon());
    }

    @Test
    void should_apply_diversity_and_elite_bonus_when_dresseur_has_qualifying_pokemons() {
        Dresseur dresseur = new Dresseur();
        dresseur.setNom("Maître");

        Pokemon p1 = new Pokemon(); p1.setType("Feu"); p1.setNiveau(50); // lvl 50 + 10 (Élite) = 60
        Pokemon p2 = new Pokemon(); p2.setType("Eau"); p2.setNiveau(40); // lvl 40
        Pokemon p3 = new Pokemon(); p3.setType("Plante"); p3.setNiveau(60); // lvl 60 + 10 (Élite) = 70

        dresseur.setPokemons(List.of(p1, p2, p3));

        DresseurDto result = dresseurService.toDto(dresseur);

        assertEquals(190, result.getLevelDresseur());
        assertEquals(3, result.getNbPokemon());
    }

    @Test
    void should_return_dresseur_dto_when_get_is_called() {

        Dresseur dresseur = new Dresseur();
        dresseur.setId(1L);
        dresseur.setNom("Sacha");
        dresseur.setPokemons(new ArrayList<>());

        when(dresseurRepository.findById(1L)).thenReturn(Optional.of(dresseur));

        DresseurDto result = dresseurService.getById(1L);

        assertEquals("Sacha", result.getName());
        assertEquals(1, result.getLevelDresseur());
    }
}