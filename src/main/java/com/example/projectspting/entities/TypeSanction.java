package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Data
@NoArgsConstructor
@Entity
@Table(name = "type_sanction")
public class TypeSanction implements Serializable {

    @Id
    @SequenceGenerator(name = "TYPESANCTION_ID_GENERATOR", sequenceName = "TYPE_SANCTION_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "TYPESANCTION_ID_GENERATOR")
    private Long id;
    @Column(name="label_fr")
    private String labelFr;
    @Column(name="label_en")
    private String labelEn;
    @Column(name="label_pr")
    private String labelPr;
}
