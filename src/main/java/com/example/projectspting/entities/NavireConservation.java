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
@Table
public class NavireConservation implements Serializable {

    @Id
    @SequenceGenerator(name = "NAVIRE_CONSERVATION_ID_GENERATOR", sequenceName = "NAVIRE_CONSERVATION_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "NAVIRE_CONSERVATION_ID_GENERATOR")
    private Long id;

    @ManyToOne
    @JoinColumn(name="mode_conservation")
    private ModeConservation modeConservation;
    private BigDecimal puissanceFrig;
    private BigDecimal capaciteCongelation;
    private Integer nbreCale;
    private BigDecimal capaciteCale;
    private boolean modifier;
    @ManyToOne
    private Utilisateur utilisateur;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModif;
    @ManyToOne
    @JoinColumn(name="navire")
    private Navire navire;


}
