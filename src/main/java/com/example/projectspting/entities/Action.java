package com.example.projectspting.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;


/**
 * @author chiheb
 * @version V1.0
 * @since  05-11-2021
 * The persistent class for the action database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="action")
@NamedQuery(name="Action.findAll", query="SELECT a FROM Action a")
public class Action implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACTION_ID_GENERATOR" , sequenceName = "ACTION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACTION_ID_GENERATOR")
	private Integer id;
	private String actionAngl;
	private String actionFr;
	private String actionPortu;
	private String code;

	@ManyToMany
	@JoinTable(
			name = "fonction_action",
			joinColumns = @JoinColumn(name = "action_id"),
			inverseJoinColumns = @JoinColumn(name = "fonction_id"))
	private Set<Fonction> fonctions ;



}
