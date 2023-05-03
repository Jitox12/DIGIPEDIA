package com.DIGIPEDIA.Digimon.Collection.dao;


import java.io.IOException;
import java.util.List;

public interface DigimonSkillDao {
    public void createDigimonSkillDao(Integer digimonId, List<Integer> skillIdList) throws IOException;

}
