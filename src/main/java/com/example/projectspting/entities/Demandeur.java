package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "demandeur")
public class Demandeur implements Serializable {

    @Id
    @SequenceGenerator(name="DEMANDEUR_ID_GENERATOR", sequenceName="DEMANDEUR_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEMANDEUR_ID_GENERATOR")
    private Long id;
    private String 	nomResp;
    private String prenomResp;

    private String rc;
    private String qualite;
    private String adresse;


    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModif;
    private boolean modifier;
    @ManyToOne
    private Utilisateur utilisateur;
    private String societe;

    @ManyToOne
    @JoinColumn(name="pays")
    private Unitgeo unitgeo;

    @ManyToOne
    @JoinColumn(name="raison_sociale")
    private RaisonSociale raisonSociale;
    @OneToMany(mappedBy = "proprietaire")
    private Set<Navire> navires ;

}
