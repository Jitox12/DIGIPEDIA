package com.DIGIPEDIA.Digimon.Collection.services.servicesImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.DigimonDao;
import com.DIGIPEDIA.Digimon.Collection.dao.EvoInvoDao;
import com.DIGIPEDIA.Digimon.Collection.dto.involutionDto.CInvolutionDto;
import com.DIGIPEDIA.Digimon.Collection.entities.DigimonEntity;
import com.DIGIPEDIA.Digimon.Collection.exceptions.EvolveException;
import com.DIGIPEDIA.Digimon.Collection.services.InvolutionService;
import com.DIGIPEDIA.Digimon.Collection.utils.FamilyCatcher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
public class InvolutionServiceImpl implements InvolutionService {

    private final FamilyCatcher familyCatcher;
    private final DigimonDao digimonDao;
    private final EvoInvoDao evoInvoDao;

    public InvolutionServiceImpl(DigimonDao digimonDao, EvoInvoDao evoInvoDao,FamilyCatcher familyCatcher) {
        this.digimonDao = digimonDao;
        this.evoInvoDao = evoInvoDao;
        this.familyCatcher = familyCatcher;
    }

    @Transactional
    @Override
    public void involveDigimonService(CInvolutionDto involutionDto) {
        try{
            DigimonEntity digimon = digimonDao.findDigimonByIdDao(involutionDto.getDigimonIdDto());
            DigimonEntity involvedDigimon = digimonDao.findDigimonByIdDao(involutionDto.getDigimonInvolvedIdDto());

            Boolean familyResponse = familyCatcher.familyInvolvedCatcher(digimon.getDigimon_family().getDigimonFamilyName(), involvedDigimon.getDigimon_family().getDigimonFamilyName());

            if(!familyResponse){
                throw new EvolveException("it is necessary to a inferior family to involve");
            }

            evoInvoDao.InvoDao(involutionDto);

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
