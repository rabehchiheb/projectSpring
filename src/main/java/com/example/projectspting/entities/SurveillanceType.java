package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.SortedSet;

@Data
@NoArgsConstructor
@Entity
@Table(name = "surveillance_type")
public class SurveillanceType implements Serializable {


    @Id
    @SequenceGenerator(name = "SURVEILLANCETYPE_ID_GENERATOR", sequenceName = "SURVEILLANCE_TYPE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SURVEILLANCETYPE_ID_GENERATOR")
    private Long id;
    @Column(name="label_fr")
    private String labelFr;
    @Column(name="label_en")
    private String labelEn;
    @Column(name="label_pr")
    private String labelPr;

    @OneToMany(mappedBy = "surveillanceType" , cascade = CascadeType.ALL ,
               orphanRemoval = true , fetch = FetchType.LAZY)
    private Set<Surveillance> surveillances;

}
