package com.DIGIPEDIA.Digimon.Collection.repositories;

import com.DIGIPEDIA.Digimon.Collection.entities.DigimonTypeAttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DigimonTypeAttributeRepository extends JpaRepository<DigimonTypeAttributeEntity, Integer> {

    Optional<DigimonTypeAttributeEntity> findByDigimonTypeAttributeId(Integer digimonTypeAttributeId);
    Optional<DigimonTypeAttributeEntity> findByDigimonTypeAttributeName(String digimonTypeAttributeName);
    List<DigimonTypeAttributeEntity> findAll();
}
