package com.DIGIPEDIA.Digimon.Collection.repositories;

import com.DIGIPEDIA.Digimon.Collection.entities.AttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttributeRepository extends JpaRepository<AttributeEntity, Integer> {

    AttributeEntity findByAttributeId(Integer attributeId);
    AttributeEntity findByAttributeName(String attributeName);

    List<AttributeEntity> findAll();

}
