package br.com.systemsgs.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.systemsgs.Lance;
import br.com.systemsgs.Leilao;
import br.com.systemsgs.Usuario;
import br.com.systemsgs.servico.Avaliador;

public class TestDoAvaliador {
	
	@Test
	public void deveEntenderLanceEmOrdem() {
		Usuario gui = new Usuario("Guilherme");
		Usuario lavinia = new Usuario("Lavinia");
		Usuario marcela = new Usuario("Marcela");
		
		Leilao leilao = new Leilao("Computador i7");
		leilao.propoe(new Lance(gui, 250.0));
		leilao.propoe(new Lance(lavinia, 400.0));
		leilao.propoe(new Lance(marcela, 500.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		double maiorEsperado = 500;
		double menorEsperado = 250;
		
		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
		
	}

}
