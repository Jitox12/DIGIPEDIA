package com.DIGIPEDIA.Digimon.Collection.repositories;

import com.DIGIPEDIA.Digimon.Collection.entities.InvolutionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InvolutionRepository extends JpaRepository<InvolutionEntity, Integer> {

    @Query("SELECT COUNT(i.digimonId) FROM InvolutionEntity i WHERE i.digimonId = ?1")
    Integer countEvolutions(Integer digimonId);

}
