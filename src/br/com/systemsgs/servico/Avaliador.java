package br.com.systemsgs.servico;

import br.com.systemsgs.Lance;
import br.com.systemsgs.Leilao;

public class Avaliador {
	
	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	
	public void avalia(Leilao leilao) {
		
		for (Lance lance : leilao.getLances()) {
			
			if (lance.getValor() > maiorDeTodos) maiorDeTodos = lance.getValor();
			
		}
		
	}
	
	public double getMaiorLance() {
		return maiorDeTodos;
	}

}