package com.DIGIPEDIA.Digimon.Collection.dao.daoImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.DigimonTypeDao;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonTypeDto.CDigimonTypeDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonTypeEntity;
import com.DIGIPEDIA.Digimon.Collection.exceptions.BadRequestException;
import com.DIGIPEDIA.Digimon.Collection.repositories.DigimonTypeRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
@Component
public class DigimonTypeDaoImpl implements DigimonTypeDao {

    private final DigimonTypeRepository digimonTypeRepository;

    public DigimonTypeDaoImpl(DigimonTypeRepository digimonTypeRepository) {
        this.digimonTypeRepository = digimonTypeRepository;
    }

    @Override
    public void createDigimonTypeDao(CDigimonTypeDto digimonTypeDto) throws IOException {
        DigimonTypeEntity digimonType = DigimonTypeEntity.builder()
                .digimonTypeName(digimonTypeDto.getDigimonTypeNameDto())
                .build();

        digimonTypeRepository.save(digimonType);
    }

    @Override
    public List<DigimonTypeEntity> findAllDigimonTypeDao() throws IOException {
        List<DigimonTypeEntity> digimonTypeList;

        digimonTypeList = digimonTypeRepository.findAll();

        return digimonTypeList;
    }

    @Override
    public DigimonTypeEntity findDigimonTypeByIdDao(Integer digimonTypeId) throws IOException {
        DigimonTypeEntity digimonType;
        digimonType = digimonTypeRepository.findByDigimonTypeId(digimonTypeId)
                .orElseThrow(()-> new BadRequestException("Digimon Type Id: ".concat(String.valueOf(digimonTypeId))));

        return digimonType;
    }

    @Override
    public DigimonTypeEntity findDigimonTypeByNameDao(String digimonTypeName) throws IOException {
        DigimonTypeEntity digimonType;
        digimonType = digimonTypeRepository.findByDigimonTypeName(digimonTypeName)
                .orElseThrow(()-> new BadRequestException("Digimon Type Name: ".concat(digimonTypeName)));

        return digimonType;
    }
}
