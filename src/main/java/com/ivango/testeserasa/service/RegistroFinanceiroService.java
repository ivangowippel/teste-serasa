package com.ivango.testeserasa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivango.testeserasa.dao.EmpresaDAO;
import com.ivango.testeserasa.entity.EmpresaEntity;

@Service
public class RegistroFinanceiroService {

	@Autowired
	private EmpresaDAO empresaDAO;

	private final double PERCENTUAL_NF = 0.02;
	private final double PERCENTUAL_DEBITO = 0.04;

	public void calcularESalvarReputacao(int idEmpresa, int qtdNotas, int qtdDebitos) {
		EmpresaEntity e = empresaDAO.findById(idEmpresa).get();
		double reputacao = e.getReputacao();
		reputacao = processarReputacao(qtdNotas, qtdDebitos, reputacao);
		e.setReputacao((int) reputacao);
		empresaDAO.save(e);
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

}
