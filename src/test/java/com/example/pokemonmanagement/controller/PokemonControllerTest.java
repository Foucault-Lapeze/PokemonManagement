package com.example.pokemonmanagement.controller;

import com.example.pokemonmanagement.dto.PokemonDto;
import com.example.pokemonmanagement.service.IPokemonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PokemonController.class)
class PokemonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IPokemonService pokemonService;

    @Test
    void should_return_200_and_pokemon_list_when_get_all_is_called() throws Exception {
        PokemonDto p1 = new PokemonDto(); p1.setNom("Pikachu");
        PokemonDto p2 = new PokemonDto(); p2.setNom("Bulbizarre");

        when(pokemonService.getAllPokemons()).thenReturn(List.of(p1, p2));

        mockMvc.perform(get("/pokemons/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].nom").value("Pikachu"))
                .andExpect(jsonPath("$[1].nom").value("Bulbizarre"));
    }
}