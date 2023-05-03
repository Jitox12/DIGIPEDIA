package com.DIGIPEDIA.Digimon.Collection.repositories;

import com.DIGIPEDIA.Digimon.Collection.entities.DigimonFamilyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DigimonFamilyRepository extends JpaRepository<DigimonFamilyEntity, Integer> {
    Optional<DigimonFamilyEntity> findByDigimonFamilyId(Integer digimonFamilyId);
    Optional<DigimonFamilyEntity> findByDigimonFamilyName(String digimonFamilyName);
    List<DigimonFamilyEntity> findAll();
}
