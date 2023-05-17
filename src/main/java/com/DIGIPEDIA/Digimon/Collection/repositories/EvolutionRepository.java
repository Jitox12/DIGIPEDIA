package com.DIGIPEDIA.Digimon.Collection.repositories;


import com.DIGIPEDIA.Digimon.Collection.entities.EvolutionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EvolutionRepository extends JpaRepository<EvolutionEntity, Integer> {


    @Query("SELECT COUNT(e.digimonId) FROM EvolutionEntity e WHERE e.digimonId = ?1")
    Integer countEvolutions(Integer digimonId);

    //@Query("SELECT COUNT(*) > 0 AS result FROM EvolutionEntity e, InvolutionEntity i WHERE (e.digimonId = ?1 AND e.digimonEvolvedId = ?2) And (e.digimonId = ?2 AND i.digimonInvolvedId = ?1) ")
    @Query(" SELECT\n" +
            "    CASE\n" +
            "        WHEN EXISTS (SELECT 1 FROM EvolutionEntity e WHERE e.digimonId = ?1 AND e.digimonEvolvedId = ?2) THEN FALSE\n" +
            "        WHEN EXISTS (SELECT 1 FROM InvolutionEntity i WHERE i.digimonId = ?1 AND i.digimonInvolvedId = ?2) THEN FALSE\n" +
            "        ELSE TRUE\n" +
            "    END AS resultado\n" +
            "FROM EvolutionEntity")
    Boolean noRepeatEvolve(Integer digimonId, Integer digimonEvolvedId);

}
