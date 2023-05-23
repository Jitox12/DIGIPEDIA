package com.DIGIPEDIA.Digimon.Collection.dao.daoImpl;

import com.DIGIPEDIA.Digimon.Collection.dao.InvolutionDao;
import com.DIGIPEDIA.Digimon.Collection.entities.InvolutionEntity;
import com.DIGIPEDIA.Digimon.Collection.repositories.InvolutionRepository;
import org.springframework.stereotype.Component;

@Component
public class InvolutionDaoImpl implements InvolutionDao {
    private  final InvolutionRepository involutionRepository;

    public InvolutionDaoImpl(InvolutionRepository involutionRepository) {
        this.involutionRepository = involutionRepository;
    }

    @Override
    public void involveDigimon(Integer digimonId, Integer digimonInvolveId) {
        InvolutionEntity involution = InvolutionEntity.builder().digimonId(digimonId).digimonInvolvedId(digimonInvolveId).build();
        involutionRepository.save(involution);
    }

    @Override
    public boolean verifyInvolve(Integer digimonId, Integer digimonInvolveId) {
        boolean invoVerify = involutionRepository.noRepeatInvolve(digimonId,digimonInvolveId);;
        return invoVerify;
    }
}
