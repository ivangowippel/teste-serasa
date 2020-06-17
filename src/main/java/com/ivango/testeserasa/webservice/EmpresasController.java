package com.ivango.testeserasa.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivango.testeserasa.dao.EmpresaDAO;
import com.ivango.testeserasa.entity.EmpresaEntity;

@CrossOrigin
@RestController
@RequestMapping("/empresas")
public class EmpresasController {

	@Autowired // instancia automaticamente o objeto, é como se fosse um "new EmpresaDAO()"
	private EmpresaDAO empresaDAO;

	@GetMapping
	private List<EmpresaEntity> getTodasEmpresas() {
		return empresaDAO.findAll(Sort.by(Sort.Direction.DESC, "reputacao"));
	}
}
