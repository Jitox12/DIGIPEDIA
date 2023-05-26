package com.DIGIPEDIA.Digimon.Collection.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "digimon")
public class DigimonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "digimon_id")
    private Integer digimonId;
    @Column(name = "digimon_memory")
    private Integer digimonMemory;
    @Column(name = "digimon_name")
    private String digimonName;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "digimon_img", columnDefinition = "bigint")
    private byte[] digimonImg;

    @Column(name = "digimon_passive")
    private String digimonPassive;

    @Column(name = "digimon_family_id")
    private Integer digimonFamilyId;

    @Column(name = "digimon_type_attribute_id")
    private Integer digimonTypeAttributeId;

    @ManyToMany
    @JoinTable(
            name = "digimon_skill",
            joinColumns = {@JoinColumn(name = "digimon_id", referencedColumnName = "digimon_id")},
            inverseJoinColumns = {@JoinColumn(name = "skill_id", referencedColumnName = "skill_id")})
    private List<SkillEntity> skills;

    @ManyToOne
    @JoinColumn(name = "digimon_family_id",insertable = false, updatable = false)
    private DigimonFamilyEntity digimon_family;

    @ManyToOne
    @JoinColumn(name = "digimon_type_attribute_id",insertable = false, updatable = false)
    private DigimonTypeAttributeEntity digimon_type_attribute;
}