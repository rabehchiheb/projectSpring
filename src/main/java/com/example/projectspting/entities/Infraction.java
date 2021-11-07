package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ction")
public class Infraction implements Serializable {

    @Id
    @SequenceGenerator(name = "INFRACTION_ID_GENERATOR", sequenceName = "INFRACTION_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INFRACTION_ID_GENERATOR")
    private Long id;
    private String label;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModif;
    private String commentaire;
    private String capitaine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "infraction_nature")
    private InfractionNature infractionNature;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date")
    private Date date;

    @Column(name="agent_verbalisateur")
    private String agentVerbalisateur;

    private boolean modifier;

    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="categorie")
    private SurveillanceCategorie surveillanceCategorie;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="navire")
    private Navire navire;

}
