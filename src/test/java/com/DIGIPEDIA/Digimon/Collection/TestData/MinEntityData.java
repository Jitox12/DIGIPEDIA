package com.DIGIPEDIA.Digimon.Collection.TestData;

import com.DIGIPEDIA.Digimon.Collection.entities.*;

import java.util.ArrayList;
import java.util.List;

public class MinEntityData extends EntityTestData {

    //data corresponding to GDTO, Minimum for entity creation

    public static SkillTypeEntity minCreateSkillTypeEntity() {

        return SkillTypeEntity.builder()
                .skillTypeId(1)
                .skillTypeName("Normal")
                .build();
    }
    public static AttributeEntity minCreateAttributeEntity() {

        return AttributeEntity
                .builder()
                .attributeId(1)
                .attributeName("Fuego")
                .attributeImg(img)
                .build();
    }
    public static DigimonTypeAttributeEntity minCreateDigimonTypeAttributeEntity() {
        return DigimonTypeAttributeEntity
                .builder()
                .digimonTypeAttributeId(1)
                .digimonTypeId(1)
                .attributeId(1)
                .digimonTypeAttributeName("Virus")
                .digimonTypeAttributeImg(img)
                .build();
    }
    public static DigimonFamilyEntity minCreateDigimonFamilyEntity() {
        return DigimonFamilyEntity
                .builder()
                .digimonFamilyId(1)
                .digimonFamilyName("Campeon")
                .build();
    }
    public static DigimonTypeEntity minCreateDigimonTypeEntity(){
        return DigimonTypeEntity.builder()
                .digimonTypeId(1)
                .digimonTypeName("Virus")
                .build();
    }

    //LIST
    public static List<SkillEntity> minCreateSkillEntityList() {
        List<SkillEntity> skillList = new ArrayList<>();
        SkillTypeEntity skillType = MinEntityData.minCreateSkillTypeEntity();

        AttributeEntity attribute = MinEntityData.minCreateAttributeEntity();

        skillList.add(SkillEntity.builder()
                .skillId(1)
                .skillName("Placaje")
                .skillDescription("Golpe")
                .skillTypeId(1)
                .skill_type(skillType)
                .attribute(attribute)
                .build()
        );
        return skillList;
    }
    public static List<DigimonEntity> minCreateDigimonEntityList() {
        List<DigimonEntity> digimonList = new ArrayList<>();
        DigimonTypeAttributeEntity digimonTypeAttribute = minCreateDigimonTypeAttributeEntity();
        DigimonFamilyEntity digimonFamily = minCreateDigimonFamilyEntity();

        digimonList.add(DigimonEntity
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
                .build()
        );
        return digimonList;
    }
    public static List<DigimonTypeAttributeEntity> minCreateDigimonTypeAttributeEntityList() {
        List<DigimonTypeAttributeEntity> digimonTypeAttributeList = new ArrayList<>();

        digimonTypeAttributeList.add(DigimonTypeAttributeEntity.builder()
                .digimonTypeAttributeId(1)
                .digimonTypeId(1)
                .attributeId(1)
                .digimonTypeAttributeName("Virus")
                .digimonTypeAttributeImg(img)
                .build()
        );

        return digimonTypeAttributeList;
    }
}
