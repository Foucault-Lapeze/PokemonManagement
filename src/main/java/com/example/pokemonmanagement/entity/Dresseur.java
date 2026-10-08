package com.example.pokemonmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "dresseur")
public class Dresseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String region;

    @OneToMany(mappedBy = "dresseur", cascade = CascadeType.ALL)
    private List<Pokemon> pokemons = new ArrayList<>();
}