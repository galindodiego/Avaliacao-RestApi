package com.diegogalindo.domain.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pessoa {
	
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	

	@JsonFormat(pattern ="dd/MM/yyyy")
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	
	@Column(nullable = true)
	private int enderecoPrincipal;

	//@ManyToOne
	@ManyToMany
	@JoinColumn(name="endereco_id")
	private List<Endereco> endereco;
}
