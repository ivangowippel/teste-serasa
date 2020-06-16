package com.ivango.testeserasa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ivango.testeserasa.service.RegistroFinanceiroService;

@SpringBootTest
class TesteRegistroFinanceiro {

	@Test
	void test_processarReputacaoSucesso() {
		// arrange
		RegistroFinanceiroService registroFinanceiroService = new RegistroFinanceiroService();
		int qtdNotas = 3;
		int qtdDebitos = 1;
		double reputacao = 50;
		
		// act
		reputacao = registroFinanceiroService.processarReputacao(qtdNotas, qtdDebitos, reputacao);
		
		// assert
		assertEquals(51, reputacao);
	}
	
	@Test
	void test_processarReputacaoSucessoValorMaximo() {
		// arrange
		RegistroFinanceiroService registroFinanceiroService = new RegistroFinanceiroService();
		int qtdNotas = 1000;
		int qtdDebitos = 1;
		double reputacao = 50;
		
		// act
		reputacao = registroFinanceiroService.processarReputacao(qtdNotas, qtdDebitos, reputacao);
		System.out.println(reputacao);
		
		// assert
		assertEquals(100, reputacao);
	}
	
	@Test
	void test_processarReputacaoSucessoValorMinimo() {
		// arrange
		RegistroFinanceiroService registroFinanceiroService = new RegistroFinanceiroService();
		int qtdNotas = 3;
		int qtdDebitos = 1000;
		double reputacao = 50;
		
		// act
		reputacao = registroFinanceiroService.processarReputacao(qtdNotas, qtdDebitos, reputacao);
		
		// assert
		assertEquals(1, reputacao);
	}
	
}
