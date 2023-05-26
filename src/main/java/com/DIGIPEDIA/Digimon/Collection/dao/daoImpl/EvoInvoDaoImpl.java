package com.DIGIPEDIA.Digimon.Collection.dao.daoImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.EvoInvoDao;
import com.DIGIPEDIA.Digimon.Collection.dao.EvolutionDao;
import com.DIGIPEDIA.Digimon.Collection.dao.InvolutionDao;
import com.DIGIPEDIA.Digimon.Collection.dto.evolutionDto.CEvolutionDto;
import com.DIGIPEDIA.Digimon.Collection.exceptions.BadRequestException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class EvoInvoDaoImpl implements EvoInvoDao {
    private final EvolutionDao evolutionDao;
    private final InvolutionDao involutionDao;

    public EvoInvoDaoImpl(EvolutionDao evolutionDao, InvolutionDao involutionDao) {
        this.evolutionDao = evolutionDao;
        this.involutionDao = involutionDao;
    }

    @Override
    @Transactional
    public void EvoDao(CEvolutionDto evolutionDto) {
        boolean evoVerify = evolutionDao.verifyEvolve(evolutionDto.getDigimonIdDto(),evolutionDto.getDigimonEvolvedIdDto());
        boolean invoVerify = involutionDao.verifyInvolve(evolutionDto.getDigimonIdDto(),evolutionDto.getDigimonEvolvedIdDto());

        if (evoVerify && invoVerify){
            evolutionDao.evolveDigimon(evolutionDto.getDigimonIdDto(),evolutionDto.getDigimonEvolvedIdDto());
            involutionDao.involveDigimon(evolutionDto.getDigimonEvolvedIdDto(),evolutionDto.getDigimonIdDto());
        }else{
            throw new BadRequestException("The evolution already exists or it is not valid");
        }
    }
    @Override
    @Transactional
    public void InvoDao(Integer digimonId, Integer digimonInvoId) {
        boolean evoVerify = evolutionDao.verifyEvolve(digimonId,digimonInvoId);
        boolean invoVerify = involutionDao.verifyInvolve(digimonId,digimonInvoId);

        if (evoVerify && invoVerify){
            evolutionDao.evolveDigimon(digimonId,digimonInvoId);
            involutionDao.involveDigimon(digimonId,digimonInvoId);
        }else{
            throw new BadRequestException("The involution already exists or it is not valid");
        }
    }
}