package com.DIGIPEDIA.Digimon.Collection.repositories;

import com.DIGIPEDIA.Digimon.Collection.entities.InvolutionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InvolutionRepository extends JpaRepository<InvolutionEntity, Integer> {
    @Query("SELECT \n" +
            "\tCASE \n" +
            "\t\tWHEN EXISTS (SELECT 1 FROM EvolutionEntity e Where e.digimonId= ?1 AND e.digimonEvolvedId = ?2) THEN TRUE \n" +
            "\t\tWHEN EXISTS (SELECT 1 FROM InvolutionEntity i Where i.digimonId= ?1 AND i.digimonInvolvedId = ?2) THEN TRUE \n" +
            "\tELSE FALSE \n" +
            "END AS resultado \n" +
            "FROM InvolutionEntity ")
    Boolean noRepeatInvolve(Integer digimonId, Integer digimonInvolvedId);
}