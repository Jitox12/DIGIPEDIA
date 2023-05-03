package com.DIGIPEDIA.Digimon.Collection.repositories;

import com.DIGIPEDIA.Digimon.Collection.entities.SkillTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkillTypeRepository extends JpaRepository<SkillTypeEntity, Integer> {
    Optional<SkillTypeEntity> findBySkillTypeId(Integer skillTypeId);
    Optional<SkillTypeEntity> findBySkillTypeName(String skillTypeName);
    List<SkillTypeEntity> findAll();
}
