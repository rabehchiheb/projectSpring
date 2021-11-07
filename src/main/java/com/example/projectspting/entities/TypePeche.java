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
@Table(name = "type_peche")
public class TypePeche implements Serializable {

    @Id
    @SequenceGenerator(name="TYPE_PECHE_ID_GENERATOR", sequenceName="TYPE_PECHE_SEQ")
    @GeneratedValue(strategy= GenerationType.AUTO, generator="TYPE_PECHE_ID_GENERATOR")
    private Integer id;
    private String typeAngl;
    private String typeFr;
    private String typePortu;

    @OneToMany(mappedBy = "typePeche" , fetch = FetchType.LAZY ,
               cascade = CascadeType.ALL , orphanRemoval = true)
    private Set<Autorisation> autorisations ;

}
