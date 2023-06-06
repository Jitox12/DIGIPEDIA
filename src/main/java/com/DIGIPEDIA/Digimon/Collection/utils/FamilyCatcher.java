package com.DIGIPEDIA.Digimon.Collection.utils;

import com.DIGIPEDIA.Digimon.Collection.config.DigivolutionCodes;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FamilyCatcher {

    private final DigivolutionCodes digivolutionCodes ;

    public FamilyCatcher(DigivolutionCodes digivolutionCodes) {
        this.digivolutionCodes = digivolutionCodes;
    }

    public Boolean familyEvolvedCatcher(String digimonFamily, String digimonEvolvedFamily) {
        String result = digivolutionCodes.getEvolution().get(digimonFamily);
        return !Objects.isNull(result) && result.equalsIgnoreCase(digimonEvolvedFamily);
    }

    public Boolean familyInvolvedCatcher(String digimonFamily, String digimonInvolvedFamily) {
        String result = digivolutionCodes.getInvolution().get(digimonFamily);
        return !Objects.isNull(result) && result.equalsIgnoreCase(digimonInvolvedFamily);
    }
}