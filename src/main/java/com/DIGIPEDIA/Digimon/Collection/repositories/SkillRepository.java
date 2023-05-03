package com.DIGIPEDIA.Digimon.Collection.repositories;

import com.DIGIPEDIA.Digimon.Collection.entities.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkillRepository extends JpaRepository<SkillEntity, Integer> {
    Optional<SkillEntity> findBySkillId(Integer skillId);
    Optional<SkillEntity> findBySkillName(String skillName);
    List<SkillEntity> findAll();
}
