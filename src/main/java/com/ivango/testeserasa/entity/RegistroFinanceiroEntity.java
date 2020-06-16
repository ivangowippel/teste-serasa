package com.ivango.testeserasa.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "registro_financeiro")
@Data
public class RegistroFinanceiroEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
	private EmpresaEntity empresa;
	
	@Column(name = "dt_registro")
	private ZonedDateTime dtRegistro;

	@Column(name = "qtd_notas")
	private int qtdNotas;
	
	@Column(name = "qtd_debitos")
	private int qtdDebitos;
}