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
@Table(name = "attribute")
public class AttributeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attribute_id")
    private Integer attributeId;

    @Column(name = "attribute_name")
    private String attributeName;

    @OneToMany(mappedBy = "attribute")
    private List<DigimonTypeEntity> digimonTypes;

    @OneToMany(mappedBy = "attribute")
    private List<SkillEntity> skills;
}
