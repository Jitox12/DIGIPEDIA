package com.DIGIPEDIA.Digimon.Collection.services.servicesImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.DigimonDao;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.CDigimonDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.EvoInvoDigimonDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.GADigimonDto;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.GDigimonDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonEntity;
import com.DIGIPEDIA.Digimon.Collection.exceptions.BadRequestException;
import com.DIGIPEDIA.Digimon.Collection.mappers.DigimonMapper;
import com.DIGIPEDIA.Digimon.Collection.services.DigimonService;
import com.DIGIPEDIA.Digimon.Collection.utils.FormatUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DigimonServiceImpl implements DigimonService {

    private final DigimonDao digimonDao;
    private final DigimonMapper digimonMapper;

    public DigimonServiceImpl(DigimonDao digimonDao, DigimonMapper digimonMapper) {
        this.digimonDao = digimonDao;
        this.digimonMapper = digimonMapper;
    }

    @Override
    public void createDigimon(CDigimonDto cDigimonDto) {

        if (Objects.isNull(cDigimonDto)) {
            throw new BadRequestException("CDigimonFamilyDto  is null");
        }
        String upperCaseDigimonName = FormatUtils.UpperCase(cDigimonDto.getDigimonNameDto());
        cDigimonDto.setDigimonNameDto(upperCaseDigimonName);

        try {
            digimonDao.createDigimonDao(cDigimonDto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Transactional
    @Override
    public EvoInvoDigimonDto findDigimonById(Integer digimonId) {

        try {
            DigimonEntity digimon = digimonDao.findDigimonByIdDao(digimonId);
            GADigimonDto digimonDto = digimonMapper.digimontoGADigimonDto(digimon);

            List<DigimonEntity> digimonEvolvedList = digimonDao.findEvolveDigimonList(digimonId);
            List<DigimonEntity> digimonInvolvedList =  digimonDao.findInvolveDigimonList(digimonId);

            List<GDigimonDto> digimonEvolvedListDto = digimonEvolvedList.stream().map(digimonMapper::digimontoGDigimonDto).collect(Collectors.toList());
            List<GDigimonDto> digimonInvolvedListDto = digimonInvolvedList.stream().map(digimonMapper::digimontoGDigimonDto).collect(Collectors.toList());

            EvoInvoDigimonDto fullDigimonDetails = digimonMapper.digimonEvolveListAndDigimonInvolveListAndDigimon(digimonEvolvedListDto, digimonDto, digimonInvolvedListDto);

            return fullDigimonDetails;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public GADigimonDto findDigimonByName(String digimonName) {
        try {
            GADigimonDto digimonDto;
            DigimonEntity digimon;

            digimon = digimonDao.findDigimonByNameDao(digimonName);
            digimonDto = digimonMapper.digimontoGADigimonDto(digimon);

            return digimonDto;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GDigimonDto> findAllDigimon() {
        try {
            List<GDigimonDto> digimonDtoList;
            List<DigimonEntity> digimonList;

            digimonList = digimonDao.findAllDigimonDao();
            digimonDtoList = digimonList.stream().map(digimonMapper::digimontoGDigimonDto).collect(Collectors.toList());

            return digimonDtoList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
