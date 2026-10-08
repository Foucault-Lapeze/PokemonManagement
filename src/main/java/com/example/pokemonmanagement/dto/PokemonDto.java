package com.example.pokemonmanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonDto {
    private Long id;
    private String nom;
    private String type;
    private int niveau;
}