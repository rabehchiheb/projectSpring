package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "famille_espece")
public class FamilleEspece implements Serializable {


    @Id
    @SequenceGenerator(name="FAMILLE_ESPECE_ID_GENERATOR", sequenceName="FAMILLE_ESPECE_SEQ")
    @GeneratedValue(strategy= GenerationType.AUTO, generator="FAMILLE_ESPECE_ID_GENERATOR")
    private Integer id;

    private String famAngl;

    private String famFr;

    private String famPortu;
    @OneToMany(mappedBy = "familleEspece" , fetch = FetchType.LAZY ,
               cascade = CascadeType.ALL , orphanRemoval = true)
    private Set<EspecePoisson> especePoissons ;

}
