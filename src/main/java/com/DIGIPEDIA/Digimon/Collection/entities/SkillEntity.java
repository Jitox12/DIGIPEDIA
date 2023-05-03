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
@Table(name = "skill")
public class SkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private Integer skillId;

    @Column(name = "skill_name")
    private String skillName;

    @Column(name = "skill_description")
    private String skillDescription;

    @Column(name = "skill_type_id")
    private Integer skillTypeId;
    @Column(name = "attribute_id")
    private Integer attributeId;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "digimon_skill",
            joinColumns = {@JoinColumn(name = "skill_id", referencedColumnName = "skill_id")},
            inverseJoinColumns = {@JoinColumn(name = "digimon_id", referencedColumnName = "digimon_id")})
    private List<DigimonEntity> digimons;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_type_id",insertable = false, updatable = false)
    private SkillTypeEntity skill_type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attribute_id",insertable = false, updatable = false)
    private AttributeEntity attribute;

}
