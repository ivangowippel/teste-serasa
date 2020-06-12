package com.ivango.testeserasa.webservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivango.testeserasa.dto.RegistroFinanceiroDTO;

@RestController
@RequestMapping("/registrofinanceiro")
public class RegistroFinanceiroController {

	// Expondo a rota HTTP para ser chamado pelo FrontEnd
	@PostMapping
	private void processar(@RequestBody RegistroFinanceiroDTO registroFinanceiroDTO) {

		int qtdeNf = registroFinanceiroDTO.getQtdNotas();
		int qtdeDebito = registroFinanceiroDTO.getQtdDebitos();
		
		System.out.println(qtdeNf);
		System.out.println(qtdeDebito);
		
		int scoreInicial = 50;
		
		// tarefa de casa: fazer logica de processamento de notas fiscais e debitos
		// no final printar na tela o scoreFinal
	}

}