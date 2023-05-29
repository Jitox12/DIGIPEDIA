package com.DIGIPEDIA.Digimon.Collection.dao.daoImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.EvoInvoDao;
import com.DIGIPEDIA.Digimon.Collection.dao.EvolutionDao;
import com.DIGIPEDIA.Digimon.Collection.dao.InvolutionDao;
import com.DIGIPEDIA.Digimon.Collection.dto.evolutionDto.CEvolutionDto;
import com.DIGIPEDIA.Digimon.Collection.dto.involutionDto.CInvolutionDto;
import com.DIGIPEDIA.Digimon.Collection.exceptions.BadRequestException;
import com.DIGIPEDIA.Digimon.Collection.exceptions.EvolveException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;

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
    public void EvoDao(CEvolutionDto evolutionDto) throws IOException {
        boolean evoVerify = evolutionDao.verifyEvolve(evolutionDto.getDigimonIdDto(), evolutionDto.getDigimonEvolvedIdDto());
        boolean invoVerify = involutionDao.verifyInvolve(evolutionDto.getDigimonIdDto(), evolutionDto.getDigimonEvolvedIdDto());

        if (!evoVerify && !invoVerify) {
            evolutionDao.evolveDigimon(evolutionDto.getDigimonIdDto(), evolutionDto.getDigimonEvolvedIdDto());
            involutionDao.involveDigimon(evolutionDto.getDigimonEvolvedIdDto(), evolutionDto.getDigimonIdDto());

        } else {
            throw new EvolveException("The evolution already exists");
        }
    }

    @Override
    @Transactional
    public void InvoDao(CInvolutionDto involutionDto) throws IOException {
        boolean evoVerify = evolutionDao.verifyEvolve(involutionDto.getDigimonIdDto(), involutionDto.getDigimonInvolvedIdDto());
        boolean invoVerify = involutionDao.verifyInvolve(involutionDto.getDigimonIdDto(), involutionDto.getDigimonInvolvedIdDto());

        if (!evoVerify && !invoVerify) {
            evolutionDao.evolveDigimon(involutionDto.getDigimonInvolvedIdDto(),involutionDto.getDigimonIdDto());
            involutionDao.involveDigimon(involutionDto.getDigimonIdDto(),involutionDto.getDigimonInvolvedIdDto());
        } else {
            throw new BadRequestException("The involution already exists or it is not valid");
        }
    }
}