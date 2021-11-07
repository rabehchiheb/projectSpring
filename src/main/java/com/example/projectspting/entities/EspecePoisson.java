package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "espece_poisson")
public class EspecePoisson {
    @Id
    @SequenceGenerator(name="ESPECE_POISSON_ID_GENERATOR", sequenceName="ESPECE_POISSON_SEQ")
    @GeneratedValue(strategy= GenerationType.AUTO, generator="ESPECE_POISSON_ID_GENERATOR")
    private Integer id;

    private String codeTaxo;

    private String nomAng;

    private String nomFr;

    private String nomPortu;

    private String nomScient;

    @ManyToMany
    private Set<Autorisation> autorisations;
    @ManyToOne
    private FamilleEspece familleEspece;


}
