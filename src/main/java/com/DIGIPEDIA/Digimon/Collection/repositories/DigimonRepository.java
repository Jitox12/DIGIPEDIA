package com.DIGIPEDIA.Digimon.Collection.repositories;

import com.DIGIPEDIA.Digimon.Collection.entities.DigimonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DigimonRepository extends JpaRepository<DigimonEntity, Integer> {
    Optional<DigimonEntity> findByDigimonId(Integer digimonId);
    Optional<DigimonEntity> findByDigimonName(String digimonName);
    List<DigimonEntity> findAll();

}
