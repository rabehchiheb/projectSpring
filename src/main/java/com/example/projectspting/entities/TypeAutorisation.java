package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name="type_autorisation")
@NamedQuery(name="TypeAutorisation.findAll", query="SELECT t FROM TypeAutorisation t")
public class TypeAutorisation  implements Serializable {

    @Id
    @SequenceGenerator(name="TYPE_AUTORISATION_ID_GENERATOR", sequenceName="TYPE_AUTORISATION_SEQ")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="TYPE_AUTORISATION_ID_GENERATOR")
    private Integer id;
    private String typeAngl;
    private String typeFr;
    private String typePortu;
    @OneToMany(mappedBy = "typeAutorisation", fetch = FetchType.LAZY,
               cascade = CascadeType.ALL, orphanRemoval = true)
    private Set <Autorisation> autorisations ;

}
