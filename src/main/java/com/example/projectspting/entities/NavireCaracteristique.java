package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "navire_caracteristique")
@NamedQuery(name = "NavireCaracteristique.findAll", query = "SELECT n FROM NavireCaracteristique n")
public class NavireCaracteristique implements Serializable {
    @Id
    @SequenceGenerator(name = "NAVIRE_CARACTERISTIQUE_ID_GENERATOR",
                       sequenceName = "NAVIRE_CARACTERISTIQUE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NAVIRE_CARACTERISTIQUE_ID_GENERATOR")
    private Long id;
    private BigDecimal autonomie;
    private String coque;
    private String couleur;
    private BigDecimal creux;
    @Temporal(TemporalType.DATE)
    private Date dateDernierCarenage;
    @Temporal(TemporalType.DATE)
    private Date dateDernierJaugeage;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModif;
    private String frequenceAppelRadio;
    private String frequenceRadioTravail;
    private BigDecimal gtums;
    private BigDecimal jaugeNette;
    private BigDecimal largeurHt;
    private BigDecimal longueurHt;
    private String marqueMoteur;
    private boolean modifier;
    private String moyenPropulsion;
    private String moyensDetection;
    private String moyenNavigation;
    private String moyensTransmission;
    private Integer nbreMarineTranger;
    private Integer nbreMarinNat;
    private Integer nbreMoteur;
    private Boolean nouvelle;
    private String numBalise;
    private String observJaugeage;
    private BigDecimal puissance;
    private String societeClassification;
    private BigDecimal tiranteau;
    private BigDecimal tjb;
    private String typeMoteur;
    private BigDecimal vitesseTransit;

    @ManyToOne
    @JoinColumn(name="nature")
    private NatureNavire natureNavire;

    @ManyToOne
    @JoinColumn(name="type_balise")
    private TypeBalise typeBalise;
    @ManyToOne
    private Navire navire ;
}
