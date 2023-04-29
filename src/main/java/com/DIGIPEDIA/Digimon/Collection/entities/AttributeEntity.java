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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "digimon_type_attribute",
            joinColumns = {@JoinColumn(name = "attribute_id", referencedColumnName = "attribute_id")},
            inverseJoinColumns = {@JoinColumn(name = "digimon_type_id", referencedColumnName = "digimon_type_id")})
    private List<DigimonTypeAttributeEntity> digimonTypeAttribute;

    @OneToMany(mappedBy = "attribute")
    private List<SkillEntity> skills;


}
