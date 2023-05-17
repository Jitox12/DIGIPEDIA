package com.DIGIPEDIA.Digimon.Collection.dao;

import com.DIGIPEDIA.Digimon.Collection.TestData.Dto.CDtoTestData;
import com.DIGIPEDIA.Digimon.Collection.TestData.Entity.MaxEntityData;
import com.DIGIPEDIA.Digimon.Collection.TestData.TestData;
import com.DIGIPEDIA.Digimon.Collection.dao.daoImpl.DigimonFamilyDaoImpl;
import com.DIGIPEDIA.Digimon.Collection.dto.digimonFamilyDto.CDigimonFamilyDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonEntity;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonFamilyEntity;
import com.DIGIPEDIA.Digimon.Collection.repositories.DigimonFamilyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class DigimonFamilyDaoTest {

    @Mock
    private DigimonFamilyRepository digimonFamilyRepository;

    @InjectMocks
    private DigimonFamilyDaoImpl digimonFamilyDao;

    @Test
    void findDigimonFamilyById() throws IOException {
        Integer digimonFamilyId = TestData.genericId;
        DigimonFamilyEntity digimonFamily = MaxEntityData.maxCreateDigimonFamily();
        digimonFamily.setDigimonFamilyId(digimonFamilyId);
        Mockito.when(digimonFamilyRepository.findByDigimonFamilyId(digimonFamilyId))
                .thenReturn(Optional.of(digimonFamily));

        DigimonFamilyEntity digimonFamilyRes = digimonFamilyDao.findDigimonFamilyByIdDao(digimonFamilyId);

        assertEquals(digimonFamilyRes.getDigimonFamilyId(), digimonFamilyId);

        assertNotNull(digimonFamilyRes.getDigimonFamilyName());
        assertNotNull(digimonFamilyRes.getDigimonFamilyId());
        assertNotNull(digimonFamilyRes);
    }

    @Test
    void findDigimonFamilyByName() throws IOException {
        String digimonFamilyName = TestData.digimonFamilyName;
        Integer digimonFamilyId = TestData.genericId;

        DigimonFamilyEntity digimonFamily = MaxEntityData.maxCreateDigimonFamily();
        digimonFamily.setDigimonFamilyId(digimonFamilyId);

        Mockito.when(digimonFamilyRepository.findByDigimonFamilyName(digimonFamilyName))
                .thenReturn(Optional.of(digimonFamily));

        DigimonFamilyEntity digimonFamilyRes = digimonFamilyDao.findDigimonFamilyByNameDao(digimonFamilyName);

        assertEquals(digimonFamilyRes.getDigimonFamilyName(), digimonFamilyName);

        assertNotNull(digimonFamilyRes.getDigimonFamilyName());
        assertNotNull(digimonFamilyRes.getDigimonFamilyId());
        assertNotNull(digimonFamilyRes);
    }

    @Test
    void findAllDigimonFamilyDao() throws IOException {
        Integer digimonFamilyId = TestData.genericId;

        DigimonFamilyEntity digimonFamily = MaxEntityData.maxCreateDigimonFamily();
        digimonFamily.setDigimonFamilyId(digimonFamilyId);

        List<DigimonFamilyEntity> digimonFamilyList = new ArrayList<>();
        digimonFamilyList.add(digimonFamily);
        digimonFamilyList.add(digimonFamily);
        digimonFamilyList.add(digimonFamily);

        Mockito.when(digimonFamilyRepository.findAll()).thenReturn(digimonFamilyList);

        List<DigimonFamilyEntity> digimonFamilyListRes = digimonFamilyDao.findAllDigimonFamilyDao();

        assertNotNull(digimonFamilyListRes);

        digimonFamilyListRes.forEach(family -> {
            assertNotNull(family);
            assertNotNull(family.getDigimonFamilyId());
            assertNotNull(family.getDigimonFamilyName());
        });

    }

    @Test
    void createDigimonFamilyDaoTest() throws IOException {
        Integer digimonFamilyId = TestData.genericId;

        DigimonFamilyEntity digimonFamily = MaxEntityData.maxCreateDigimonFamily();
        digimonFamily.setDigimonFamilyId(digimonFamilyId);


        CDigimonFamilyDto digimonFamilyDto = CDtoTestData.createDigimonFamilyDto();


        Mockito.when(digimonFamilyRepository.save(Mockito.any()))
                .thenReturn(digimonFamily);

        digimonFamilyDao.createDigimonFamilyDao(digimonFamilyDto);
    }
}
