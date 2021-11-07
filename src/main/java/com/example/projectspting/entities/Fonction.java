package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table
public class Fonction implements Serializable {
    @Id
    @SequenceGenerator(name="FONCTION_ID_GENERATOR" , sequenceName = "FONCTION_SEQ")
    @GeneratedValue(strategy= GenerationType.AUTO, generator="FONCTION_ID_GENERATOR")
    private Integer id;
    private String code;
    private String fonctionAngl;
    private String fonctionFr;
    private String fonctionPortu;
    private String fonctionUrl;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="module")
    private Module module;

    @ManyToMany
    private Set<Action> actions ;
}
