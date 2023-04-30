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
@Table(name = "skill_type")
public class SkillTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_type_id")
    private Integer skillTypeId;

    @Column(name = "skill_type_name")
    private String skillTypeName;

    @OneToMany(mappedBy = "skill_type")
    private List<SkillEntity> skills;
}
