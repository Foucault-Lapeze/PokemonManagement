package com.example.pokemonmanagement.controller;

import com.example.pokemonmanagement.dto.DresseurDto;
import com.example.pokemonmanagement.service.IDresseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dresseurs")
public class DresseurController {

    @Autowired
    private IDresseurService service;

    @GetMapping("/{id}")
    public ResponseEntity<DresseurDto> getDresseurById(@PathVariable Long id) {
        if (!service.exist(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        DresseurDto dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DresseurDto>> getAllDresseurs() {
        List<DresseurDto> dtos = service.getAll();
        return ResponseEntity.ok(dtos);
    }
}