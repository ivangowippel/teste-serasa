package com.ivango.testeserasa.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivango.testeserasa.dao.EmpresaDAO;
import com.ivango.testeserasa.entity.EmpresaEntity;

@RestController
@RequestMapping("/empresas")
public class EmpresasController {

	@Autowired // instancia automaticamente o objeto, é como se fosse um "new EmpresaDAO()"
	private EmpresaDAO empresaDAO;

	@GetMapping
	private List<EmpresaEntity> getTodasEmpresas() {
		return empresaDAO.findAll();
	}
}
