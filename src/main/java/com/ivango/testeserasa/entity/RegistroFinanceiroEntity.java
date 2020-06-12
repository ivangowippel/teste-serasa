package com.ivango.testeserasa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

	@Column
	@Enumerated(EnumType.STRING)
	private TipoRegistro tipoRegistro;
}