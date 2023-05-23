package com.DIGIPEDIA.Digimon.Collection.dao.daoImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.DigimonTypeAttributeDao;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeAttributeDto.CDigimonTypeAttributeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonTypeAttributeEntity;
import com.DIGIPEDIA.Digimon.Collection.exceptions.BadRequestException;
import com.DIGIPEDIA.Digimon.Collection.repositories.DigimonTypeAttributeRepository;
import com.DIGIPEDIA.Digimon.Collection.utils.Base64CoderUtils;
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
    public void createSkillDao(CDigimonTypeAttributeDto digimonTypeAttributeDto) throws IOException {

        byte[] bytes = Base64CoderUtils.base64Decoder(digimonTypeAttributeDto.getDigimonTypeAttributeImgDto());

        DigimonTypeAttributeEntity digimonTypeAttributeEntity = DigimonTypeAttributeEntity.builder()
                .digimonTypeId(digimonTypeAttributeDto.getDigimonTypeIdDto())
                .attributeId(digimonTypeAttributeDto.getAttributeIdDto())
                .digimonTypeAttributeImg(bytes)
                .digimonTypeAttributeName(digimonTypeAttributeDto.getDigimonTypeAttributeNameDto())
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
