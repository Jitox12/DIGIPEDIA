package com.DIGIPEDIA.Digimon.Collection.repositories;

import com.DIGIPEDIA.Digimon.Collection.entities.AttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AttributeRepository extends JpaRepository<AttributeEntity, Integer> {

    Optional<AttributeEntity> findByAttributeId(Integer attributeId);
    Optional<AttributeEntity> findByAttributeName(String attributeName);

    List<AttributeEntity> findAll();

}
