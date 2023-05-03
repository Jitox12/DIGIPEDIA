package com.DIGIPEDIA.Digimon.Collection.dao.daoImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.DigimonTypeAttributeDao;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto.CDigimonTypeAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonTypeAttributeEntity;
import com.DIGIPEDIA.Digimon.Collection.exceptions.BadRequestException;
import com.DIGIPEDIA.Digimon.Collection.repositories.DigimonTypeAttributeRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class DigimonTypeAttributeDaoImpl implements DigimonTypeAttributeDao {

    private final DigimonTypeAttributeRepository digimonTypeAttributeRepository;

    public DigimonTypeAttributeDaoImpl(DigimonTypeAttributeRepository digimonTypeAttributeRepository) {
        this.digimonTypeAttributeRepository = digimonTypeAttributeRepository;
    }

    @Override
    public void createSkillDao(CDigimonTypeAttributeDto digimonTypeAttribute) throws IOException {
        DigimonTypeAttributeEntity digimonTypeAttributeEntity = DigimonTypeAttributeEntity.builder()
                .digimonTypeId(digimonTypeAttribute.getDigimonTypeIdDto())
                .attributeId(digimonTypeAttribute.getAttributeIdDto())
                .digimonTypeAttributeImg(digimonTypeAttribute.getDigimonTypeAttributeImgDto())
                .digimonTypeAttributeName(digimonTypeAttribute.getDigimonTypeAttributeNameDto())
                .build();

        digimonTypeAttributeRepository.save(digimonTypeAttributeEntity);
    }

    @Override
    public List<DigimonTypeAttributeEntity> findAllDigimonTypeAttributeDao() throws IOException {

        List<DigimonTypeAttributeEntity> digimonTypeAttributeList;
        digimonTypeAttributeList = digimonTypeAttributeRepository.findAll();

        return digimonTypeAttributeList;
    }

    @Override
    public DigimonTypeAttributeEntity findDigimonTypeAttributeByIdDao(Integer digimonTypeAttributeId) throws IOException {
        DigimonTypeAttributeEntity digimonTypeAttributeEntity;
        digimonTypeAttributeEntity = digimonTypeAttributeRepository.findByDigimonTypeAttributeId(digimonTypeAttributeId)
                .orElseThrow(()-> new BadRequestException("Digimon Type Attribute Id: ".concat(String.valueOf(digimonTypeAttributeId))));

        return digimonTypeAttributeEntity;
    }

    @Override
    public DigimonTypeAttributeEntity findDigimonTypeAttributeByNameDao(String digimonTypeAttributeName) throws IOException {
        DigimonTypeAttributeEntity digimonTypeAttributeEntity;
        digimonTypeAttributeEntity = digimonTypeAttributeRepository.findByDigimonTypeAttributeName(digimonTypeAttributeName)
                .orElseThrow(()-> new BadRequestException("Digimon Type Attribute Name: ".concat(digimonTypeAttributeName)));

        return digimonTypeAttributeEntity;
    }
}
