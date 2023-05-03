package com.DIGIPEDIA.Digimon.Collection.repositories;

import com.DIGIPEDIA.Digimon.Collection.entities.DigimonTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DigimonTypeRepository extends JpaRepository<DigimonTypeEntity, Integer> {

    Optional<DigimonTypeEntity> findByDigimonTypeId(Integer digimonTypeId);
    Optional<DigimonTypeEntity> findByDigimonTypeName(String digimonTypeName);
    List<DigimonTypeEntity> findAll();
}
