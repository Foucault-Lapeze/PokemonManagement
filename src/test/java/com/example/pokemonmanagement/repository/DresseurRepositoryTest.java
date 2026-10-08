package com.example.pokemonmanagement.repository;

import com.example.pokemonmanagement.entity.Dresseur;
import com.example.pokemonmanagement.entity.Pokemon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DresseurRepositoryTest {

    @Autowired
    private DresseurRepository dresseurRepository;

    @Test
    void should_persist_and_find_dresseur_when_saved() {
        Dresseur nouveau = new Dresseur();
        nouveau.setNom("Pierre");
        nouveau.setRegion("Kanto");

        Dresseur saved = dresseurRepository.save(nouveau);
        Optional<Dresseur> retrieved = dresseurRepository.findById(saved.getId());

        assertTrue(retrieved.isPresent());
        assertEquals("Pierre", retrieved.get().getNom());
    }
}