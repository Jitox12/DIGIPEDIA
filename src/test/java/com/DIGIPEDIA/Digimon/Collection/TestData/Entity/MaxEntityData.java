package com.DIGIPEDIA.Digimon.Collection.TestData.Entity;


import com.DIGIPEDIA.Digimon.Collection.TestData.TestData;
import com.DIGIPEDIA.Digimon.Collection.entities.*;

import java.util.ArrayList;
import java.util.List;

public class MaxEntityData extends TestData {

    //Data corresponding to GADTO, Max for entity creation
    public static AttributeEntity maxCreateAttributeEntity() {
        List<DigimonTypeAttributeEntity> digimonTypeAttributeEntityList = MinEntityData.minCreateDigimonTypeAttributeEntityList();
        List<SkillEntity> skillEntityList = MinEntityData.minCreateSkillEntityList();

        return AttributeEntity
                .builder()
                .attributeName(attributeName)
                .attributeImg(imgDecode)
                .digimonTypesAttribute(digimonTypeAttributeEntityList)
                .skills(skillEntityList)
                .build();
    }

    public static DigimonEntity maxCreateDigimonEntity() {

        List<SkillEntity> skillList = MinEntityData.minCreateSkillEntityList();
        DigimonTypeAttributeEntity digimonTypeAttribute = MinEntityData.minCreateDigimonTypeAttributeEntity();
        DigimonFamilyEntity digimonFamily = MinEntityData.minCreateDigimonFamilyEntity();

        return DigimonEntity
                .builder()
                .digimonFamilyId(1)
                .digimonMemory(5)
                .digimonName(digimonName)
                .digimonImg(imgDecode)
                .digimonPassive(digimonPassive)
                .digimonFamilyId(1)
                .digimon_family(digimonFamily)
                .digimon_type_attribute(digimonTypeAttribute)
                .digimonTypeAttributeId(1)
                .skills(skillList)
                .build();

    }

    public static DigimonFamilyEntity maxCreateDigimonFamily() {
        List<DigimonEntity> digimonList = MinEntityData.minCreateDigimonEntityList();

        return DigimonFamilyEntity.builder()
                .digimonFamilyName(digimonFamilyName)
                .digimons(digimonList)
                .build();
    }

    public static SkillEntity maxCreateSkillEntity() {
        SkillTypeEntity skillType = MinEntityData.minCreateSkillTypeEntity();
        AttributeEntity attribute = MinEntityData.minCreateAttributeEntity();
        List<DigimonEntity> digimonList = MinEntityData.minCreateDigimonEntityList();

        return SkillEntity.builder()
                .skillName(skillName)
                .skillDescription(skillDescription)
                .skillTypeId(1)
                .skill_type(skillType)
                .attribute(attribute)
                .digimons(digimonList)
                .build();
    }

    public static List<DigimonSkillEntity> maxCreateDigimonSkillEntity() {
        List<DigimonSkillEntity> digimonSkillList = new ArrayList<>();

        idList.add(1);
        idList.add(2);
        idList.add(3);

        idList.forEach((Integer skillId) -> {
            digimonSkillList.add(DigimonSkillEntity.builder()
                    .digimonId(genericId)
                    .skillId(skillId)
                    .build());
        });
        return digimonSkillList;
    }

    public static DigimonTypeAttributeEntity maxCreateDigimonTypeAttributeEntity() {
        List<DigimonEntity> digimonList = MinEntityData.minCreateDigimonEntityList();

        return DigimonTypeAttributeEntity.builder()
                .digimonTypeId(1)
                .attributeId(1)
                .digimonTypeAttributeName(digimonTypeName)
                .digimonTypeAttributeImg(imgDecode)
                .digimons(digimonList)
                .build();
    }

    public static DigimonTypeEntity maxCreateDigimonTypeEntity() {
        List<DigimonTypeAttributeEntity> digimonTypeAttributeList = MinEntityData.minCreateDigimonTypeAttributeEntityList();

        return DigimonTypeEntity.builder()
                .digimonTypeName(digimonTypeName)
                .digimonTypeAttribute(digimonTypeAttributeList)
                .build();
    }

    public static SkillTypeEntity maxCreateSkillTypeEntity() {
        List<SkillEntity> skillList = MinEntityData.minCreateSkillEntityList();

        return SkillTypeEntity.builder()
                .skillTypeName(skillTypeName)
                .skills(skillList)
                .build();
    }
}