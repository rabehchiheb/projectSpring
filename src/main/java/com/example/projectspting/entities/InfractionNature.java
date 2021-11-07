package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "infraction_nature")
public class InfractionNature implements Serializable {

    @Id
    @SequenceGenerator(name = "INFRACTIONNATURE_ID_GENERATOR", sequenceName = "INFRACTION_NATURE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INFRACTIONNATURE_ID_GENERATOR")
    private Integer id;

    @Column(name="label_fr")
    private String labelFr;
    @Column(name="label_en")
    private String labelEn;
    @Column(name="label_pr")
    private String labelPr;
    @OneToMany(mappedBy = "infractionNature")
    private Set<Infraction> infractions ;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gravite")
    private Gravite gravite;
}
