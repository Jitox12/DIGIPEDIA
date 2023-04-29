package com.DIGIPEDIA.Digimon.Collection.dao.daoImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.DigimonFamilyDao;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto.CDigimonFamilyDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonFamilyEntity;
import com.DIGIPEDIA.Digimon.Collection.exceptions.BadRequestException;
import com.DIGIPEDIA.Digimon.Collection.repositories.DigimonFamilyRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class DigimonFamilyDaoImpl implements DigimonFamilyDao {

    private final DigimonFamilyRepository digimonFamilyRepository;

    public DigimonFamilyDaoImpl(DigimonFamilyRepository digimonFamilyRepository) {
        this.digimonFamilyRepository = digimonFamilyRepository;
    }

    @Override
    public void createDigimonFamilyDao(CDigimonFamilyDto cDigimonFamilyDto) throws IOException {
        DigimonFamilyEntity digimonFamily = DigimonFamilyEntity
                .builder()
                .digimonFamilyName(cDigimonFamilyDto.getDigimonFamilyNameDto())
                .build();

        digimonFamilyRepository.save(digimonFamily);
    }

    @Override
    public List<DigimonFamilyEntity> findAllDigimonFamilyDao() throws IOException {
        List<DigimonFamilyEntity> digimonFamilyList;
        digimonFamilyList = digimonFamilyRepository.findAll();

        return digimonFamilyList;
    }

    @Override
    public DigimonFamilyEntity findDigimonFamilyByIdDao(Integer digimonFamilyId) throws IOException {
        DigimonFamilyEntity digimonFamily;
        digimonFamily = digimonFamilyRepository.findByDigimonFamilyId(digimonFamilyId)
                .orElseThrow(()-> new BadRequestException("attribute with id ".concat(String.valueOf(digimonFamilyId))));

        return digimonFamily;
    }

    @Override
    public DigimonFamilyEntity findDigimonFamilyByNameDao(String digimonFamilyName) throws IOException {
        DigimonFamilyEntity digimonFamily;
        digimonFamily = digimonFamilyRepository.findByDigimonFamilyName(digimonFamilyName)
                .orElseThrow(()-> new BadRequestException("attribute with id ".concat(digimonFamilyName)));

        return digimonFamily;
    }
}