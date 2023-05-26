package com.DIGIPEDIA.Digimon.Collection.dao.daoImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.DigimonSkillDao;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonSkillEntity;
import com.DIGIPEDIA.Digimon.Collection.repositories.DigimonSkillRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DigimonSkillDaoImpl implements DigimonSkillDao {


    private final DigimonSkillRepository digimonSkillRepository;

    public DigimonSkillDaoImpl(DigimonSkillRepository digimonSkillRepository) {
        this.digimonSkillRepository = digimonSkillRepository;
    }

    @Override
    @Transactional
    public void createDigimonSkillDao(Integer digimonId, List<Integer> skillIdList) throws IOException {
        List<DigimonSkillEntity> digimonSkillList = new ArrayList<>();
        skillIdList.forEach((Integer skillId) -> {
            digimonSkillList.add(DigimonSkillEntity.builder()
                    .digimonId(digimonId)
                    .skillId(skillId)
                    .build());
        });

        digimonSkillRepository.saveAll(digimonSkillList);
    }
}
