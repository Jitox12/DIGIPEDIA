package com.DIGIPEDIA.Digimon.Collection.repositories;

import com.DIGIPEDIA.Digimon.Collection.entities.DigimonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface DigimonRepository extends JpaRepository<DigimonEntity, Integer> {
    Optional<DigimonEntity> findByDigimonId(Integer digimonId);
    Optional<DigimonEntity> findByDigimonName(String digimonName);
    List<DigimonEntity> findAll();
}
