package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "pavillon")
public class Pavillon implements Serializable {
    @Id
    @SequenceGenerator(name="PAVILLON_ID_GENERATOR", sequenceName="PAVILLON_SEQ")
    @GeneratedValue(strategy= GenerationType.AUTO, generator="PAVILLON_ID_GENERATOR")
    private Integer id;
    private String paviFr;
    private String paviAngl;
    private String paviPortu;

    @OneToMany(mappedBy = "pavillon" , cascade = CascadeType.ALL ,
               fetch = FetchType.LAZY , orphanRemoval = true)
    private Set<Navire> navires ;

}
