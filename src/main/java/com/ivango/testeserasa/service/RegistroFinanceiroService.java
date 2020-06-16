package com.ivango.testeserasa.service;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivango.testeserasa.dao.EmpresaDAO;
import com.ivango.testeserasa.dao.RegistroFinanceiroDAO;
import com.ivango.testeserasa.entity.EmpresaEntity;
import com.ivango.testeserasa.entity.RegistroFinanceiroEntity;

@Service
public class RegistroFinanceiroService {

	@Autowired
	private EmpresaDAO empresaDAO;
	
	@Autowired
	private RegistroFinanceiroDAO registroFinanceiroDAO;

	private final double PERCENTUAL_NF = 0.02;
	private final double PERCENTUAL_DEBITO = 0.04;

	public void calcularESalvarReputacao(int idEmpresa, int qtdNotas, int qtdDebitos) {
		EmpresaEntity e = empresaDAO.findById(idEmpresa).get();
		double reputacao = e.getReputacao();
		reputacao = processarReputacao(qtdNotas, qtdDebitos, reputacao);
		e.setReputacao((int) reputacao);
		empresaDAO.save(e);
		
		// salva o novo registro de processamento no banco
		salvarNovoRegistroFinanceiro(e, qtdNotas, qtdDebitos);
	}

	public double processarReputacao(int qtdNotas, int qtdDebitos, double reputacao) {
		double fator = 0;
		for (int i = 1; i <= qtdNotas; i++) {
			fator = reputacao * PERCENTUAL_NF;
			reputacao = Math.floor(reputacao + fator);
		}

		for (int i = 1; i <= qtdDebitos; i++) {
			fator = reputacao * PERCENTUAL_DEBITO;
			if (fator < 1) {
				fator = 1;
			}
			reputacao = Math.ceil(reputacao - fator);
		}
		
		reputacao = reputacao >= 100 ? 100 : reputacao;
		reputacao = reputacao <= 1 ? 1 : reputacao;
		
		return reputacao;
	}
	
	private void salvarNovoRegistroFinanceiro(EmpresaEntity empresa, int qtdNotas, int qtdDebitos) {
		RegistroFinanceiroEntity registroFinanceiroEntity = new RegistroFinanceiroEntity();
		registroFinanceiroEntity.setEmpresa(empresa);
		registroFinanceiroEntity.setQtdNotas(qtdNotas);
		registroFinanceiroEntity.setQtdDebitos(qtdDebitos);
		registroFinanceiroEntity.setDtRegistro(ZonedDateTime.now());
		registroFinanceiroDAO.save(registroFinanceiroEntity);
	}

}
