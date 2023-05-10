package com.DIGIPEDIA.Digimon.Collection.TestData;


import com.DIGIPEDIA.Digimon.Collection.entities.*;

import java.util.List;

public class MaxEntityData extends EntityTestData {

    //Data corresponding to GADTO, Max for entity creation
    public static AttributeEntity maxCreateAttributeEntity() {
        List<DigimonTypeAttributeEntity> digimonTypeAttributeEntityList = MinEntityData.minCreateDigimonTypeAttributeEntityList();
        List<SkillEntity> skillEntityList = MinEntityData.minCreateSkillEntityList();

        return AttributeEntity
                .builder()
                .attributeId(1)
                .attributeName("Fuego")
                .attributeImg(img)
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
                .digimonName("Agumon")
                .digimonImg(img)
                .digimonPassive("Fueguito")
                .digimonFamilyId(1)
                .digimon_family(digimonFamily)
                .digimon_type_attribute(digimonTypeAttribute)
                .digimonTypeAttributeId(1)
                .skills(skillList)
                .build();

    }
    public static DigimonFamilyEntity maxCreateDigimonFamily(){
        List<DigimonEntity> digimonList = MinEntityData.minCreateDigimonEntityList();

        return DigimonFamilyEntity.builder()
                .digimonFamilyId(1)
                .digimonFamilyName("Bebé")
                .digimons(digimonList)
                .build();
    }
    public static SkillEntity maxCreateSkillEntity() {
        SkillTypeEntity skillType = MinEntityData.minCreateSkillTypeEntity();
        AttributeEntity attribute = MinEntityData.minCreateAttributeEntity();
        List<DigimonEntity> digimonList = MinEntityData.minCreateDigimonEntityList();

        return SkillEntity.builder()
                .skillId(1)
                .skillName("Placaje")
                .skillDescription("Golpe")
                .skillTypeId(1)
                .skill_type(skillType)
                .attribute(attribute)
                .digimons(digimonList)
                .build();
    }
    public static DigimonTypeAttributeEntity maxCreateDigimonTypeAttributeEntity() {
        List<DigimonEntity> digimonList = MinEntityData.minCreateDigimonEntityList();

        return DigimonTypeAttributeEntity.builder()
                .digimonTypeAttributeId(1)
                .digimonTypeId(1)
                .attributeId(1)
                .digimonTypeAttributeName("Virus")
                .digimonTypeAttributeImg(img)
                .digimons(digimonList)
                .build();
    }
    public static DigimonTypeEntity maxCreateDigimonTypeEntity(){
        List<DigimonTypeAttributeEntity> digimonTypeAttributeList = MinEntityData.minCreateDigimonTypeAttributeEntityList();

        return DigimonTypeEntity.builder()
                .digimonTypeId(1)
                .digimonTypeName("Virus")
                .digimonTypeAttribute(digimonTypeAttributeList)
                .build();
    }
    public static SkillTypeEntity maxCreateSkillTypeEntity(){
    List<SkillEntity> skillList = MinEntityData.minCreateSkillEntityList();

        return SkillTypeEntity.builder()
                .skillTypeId(1)
                .skillTypeName("Normal")
                .skills(skillList)
                .build();
    }
}