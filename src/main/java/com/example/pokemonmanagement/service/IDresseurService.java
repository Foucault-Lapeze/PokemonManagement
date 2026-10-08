package com.example.pokemonmanagement.service;

import com.example.pokemonmanagement.dto.DresseurDto;
import com.example.pokemonmanagement.entity.Dresseur;
import java.util.List;

public interface IDresseurService {
    DresseurDto toDto(Dresseur entity);
    List<DresseurDto> getAll();
    DresseurDto getById(Long id);
    Boolean exist(Long id);
}