package com.DIGIPEDIA.Digimon.Collection.repositories;

import com.DIGIPEDIA.Digimon.Collection.entities.InvolutionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InvolutionRepository extends JpaRepository<InvolutionEntity, Integer> {
    @Query(" SELECT\n" +
            "    CASE\n" +
            "        WHEN EXISTS (SELECT 1 FROM EvolutionEntity e WHERE e.digimonId = ?1 AND e.digimonEvolvedId = ?2) THEN FALSE\n" +
            "        WHEN EXISTS (SELECT 1 FROM InvolutionEntity i WHERE i.digimonId = ?1 AND i.digimonInvolvedId = ?2) THEN FALSE\n" +
            "        ELSE TRUE\n" +
            "    END AS resultado\n" +
            "FROM EvolutionEntity")
    Boolean noRepeatInvolve(Integer digimonId, Integer digimonInvolvedId);
}