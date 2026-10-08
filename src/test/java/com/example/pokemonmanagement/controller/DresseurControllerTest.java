package com.example.pokemonmanagement.controller;

import com.example.pokemonmanagement.dto.DresseurDto;
import com.example.pokemonmanagement.service.IDresseurService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DresseurController.class)
class DresseurControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IDresseurService dresseurService;

    @Test
    void should_return_200_ok_when_dresseur_exists() throws Exception {
        DresseurDto dto = new DresseurDto();
        dto.setName("Sacha");
        dto.setLevelDresseur(190);
        dto.setNbPokemon(3);

        when(dresseurService.exist(1L)).thenReturn(true);
        when(dresseurService.getById(1L)).thenReturn(dto);

        // Act & Assert
        mockMvc.perform(get("/dresseurs/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Sacha"))
                .andExpect(jsonPath("$.levelDresseur").value(190))
                .andExpect(jsonPath("$.nbPokemon").value(3));
    }
}