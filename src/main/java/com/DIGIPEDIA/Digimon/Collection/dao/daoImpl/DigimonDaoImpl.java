package com.DIGIPEDIA.Digimon.Collection.dao.daoImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.DigimonDao;
import com.DIGIPEDIA.Digimon.Collection.dao.DigimonSkillDao;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonDto.CDigimonDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonEntity;
import com.DIGIPEDIA.Digimon.Collection.exceptions.BadRequestException;
import com.DIGIPEDIA.Digimon.Collection.repositories.DigimonRepository;
import com.DIGIPEDIA.Digimon.Collection.utils.Base64CoderUtils;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class DigimonDaoImpl implements DigimonDao {

    private final DigimonRepository digimonRepository;
    private final DigimonSkillDao digimonSkillDao;

    public DigimonDaoImpl(DigimonRepository digimonRepository, DigimonSkillDao digimonSkillDao) {
        this.digimonRepository = digimonRepository;
        this.digimonSkillDao = digimonSkillDao;
    }


    @Override
    public void createDigimonDao(CDigimonDto cDigimonDto) throws IOException {
        byte[] bytes = Base64CoderUtils.base64Decoder(cDigimonDto.getDigimonImgDto());

        DigimonEntity digimon = DigimonEntity.builder()
                .digimonMemory(cDigimonDto.getDigimonMemoryDto())
                .digimonName(cDigimonDto.getDigimonNameDto())
                .digimonPassive(cDigimonDto.getDigimonPassiveDto())
                .digimonImg(bytes)
                .digimonFamilyId(cDigimonDto.getDigimonFamilyIdDto())
                .digimonTypeAttributeId(cDigimonDto.getDigimonTypeAttributeIdDto())
                .build();

        DigimonEntity digimonSaved = digimonRepository.save(digimon);
        try{
            digimonSkillDao.createDigimonSkillDao(digimonSaved.getDigimonId(), cDigimonDto.getSkillIdDto());
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DigimonEntity> findAllDigimonDao() throws IOException {
        List<DigimonEntity> digimonList;
        digimonList = digimonRepository.findAll().stream().filter((Objects::nonNull)).collect(Collectors.toList());

        return digimonList;
    }

    @Transactional
    @Override
    public DigimonEntity findDigimonByIdDao(Integer digimonId) throws IOException {
        DigimonEntity digimon;

        digimon = digimonRepository.findByDigimonId(digimonId)
                .orElseThrow(()-> new BadRequestException("Digimon Id: ".concat(String.valueOf(digimonId))));

        return digimon;
    }

    @Transactional
    @Override
    public List<DigimonEntity> findEvolveDigimonList(Integer digimonId){
        List<DigimonEntity> digimonEvolveList = digimonRepository.evolveDigimonList(digimonId);

        return digimonEvolveList;
    }

    @Transactional
    @Override
    public List<DigimonEntity> findInvolveDigimonList(Integer digimonId){
        List<DigimonEntity> digimonInvolveList = digimonRepository.involveDigimonList(digimonId);

        return digimonInvolveList;
    }

    @Transactional
    @Override
    public DigimonEntity findDigimonByNameDao(String digimonName) throws IOException {
        DigimonEntity digimon;

        digimon = digimonRepository.findByDigimonName(digimonName)
                .orElseThrow(()-> new BadRequestException("Digimon Name: ".concat(digimonName)));

        return digimon;
    }
}
