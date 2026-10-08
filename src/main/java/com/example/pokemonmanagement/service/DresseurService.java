package com.example.pokemonmanagement.service;

import com.example.pokemonmanagement.dto.DresseurDto;
import com.example.pokemonmanagement.entity.Dresseur;
import com.example.pokemonmanagement.entity.Pokemon;
import com.example.pokemonmanagement.repository.DresseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DresseurService implements IDresseurService {

    @Autowired
    private DresseurRepository repository;

    @Override
    public DresseurDto toDto(Dresseur entity) {
        DresseurDto dto = new DresseurDto();
        dto.setName(entity.getNom());

        List<Pokemon> pokemons = entity.getPokemons();
        dto.setNbPokemon(pokemons != null ? pokemons.size() : 0);
        dto.setLevelDresseur(calculerNiveau(pokemons));

        return dto;
    }

    private int calculerNiveau(List<Pokemon> pokemons) {
        if (pokemons == null || pokemons.isEmpty()) {
            return 1;
        }

        int niveauTotal = 0;
        Set<String> typesDistincts = new HashSet<>();
        int bonusElite = 0;

        for (Pokemon p : pokemons) {
            niveauTotal += p.getNiveau();
            typesDistincts.add(p.getType());
            if (p.getNiveau() >= 50) {
                bonusElite += 10;
            }
        }

        if (typesDistincts.size() >= 3) {
            niveauTotal += 20;
        }

        return niveauTotal + bonusElite;
    }

    @Override
    public List<DresseurDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public DresseurDto getById(Long id) {
        return toDto(repository.findById(id).orElseThrow());
    }

    @Override
    public Boolean exist(Long id) {
        return repository.existsById(id);
    }
}