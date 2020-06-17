package com.ivango.testeserasa.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivango.testeserasa.dto.RegistroFinanceiroDTO;
import com.ivango.testeserasa.service.RegistroFinanceiroService;

@CrossOrigin
@RestController
@RequestMapping("/registrofinanceiro")
public class RegistroFinanceiroController {

	@Autowired
	RegistroFinanceiroService service;

	// Expondo a rota HTTP para ser chamado pelo FrontEnd
	@PostMapping
	private void processar(@RequestBody RegistroFinanceiroDTO registroFinanceiroDTO) {
		int idEmpresa = registroFinanceiroDTO.getIdEmpresa();
		int qtdeNf = registroFinanceiroDTO.getQtdNotas();
		int qtdeDebito = registroFinanceiroDTO.getQtdDebitos();

		service.calcularESalvarReputacao(idEmpresa, qtdeNf, qtdeDebito);
	}

}