package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name="autorisation")
@NamedQuery(name="AutorisationPeche.findAll", query="SELECT a FROM Autorisation a")
public class Autorisation implements Serializable {

    @Id
    @SequenceGenerator(name="AUTORISATION_PECHE_ID_GENERATOR", sequenceName="AUTORISATION_PECHE_ID_SEQ")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="AUTORISATION_PECHE_ID_GENERATOR")
    private Long id;
    private String numLicence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pays")
    private Unitgeo unitgeo;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
    private Date dateFin;


    @ManyToOne
    @JoinColumn(name = "type_autorisation")
    private TypeAutorisation typeAutorisation;

    @ManyToOne
    @JoinColumn(name = "type_peche")
    private TypePeche typePeche ;

    private String statut;
    private String options;
    private BigDecimal tailleMinmaille;
    private String zone;
    private Boolean alaPoche;
    private String autreDispositifs;
    private String autreTypePeches;
    private Boolean auxailes;
    private Boolean modifier;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModif;

    @ManyToOne
    @JoinColumn(name = "utilisateur")
    private Utilisateur utilisateur ;
    private BigDecimal cout;
    @Transient
    private boolean valideLicence;

    @ManyToMany(mappedBy = "autorisations")
    private Set<Engin> engins ;

    @ManyToMany
    private Set<EspecePoisson> especePoissons;


}
