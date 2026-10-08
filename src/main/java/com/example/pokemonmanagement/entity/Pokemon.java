package com.example.pokemonmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String type;
    private int niveau;

    @ManyToOne
    @JoinColumn(name = "dresseur_id")
    private Dresseur dresseur;
}