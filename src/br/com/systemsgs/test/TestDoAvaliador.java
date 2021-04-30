package br.com.systemsgs.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
		
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
		
	}
	
	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		
		Usuario gui = new Usuario("Guilherme");
		Leilao leilao = new Leilao("Macbook");
		
		leilao.propoe(new Lance(gui, 1000.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		assertEquals(1000.0, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(1000.0, leiloeiro.getMenorLance(), 0.00001);
		
	}
	
	@Test
	public void deveEncontrarOsTresMaioresLances() {
		
		Usuario gui = new Usuario("Guilherme");
		Usuario lavinia = new Usuario("Lavinia");
		
		Leilao leilao = new Leilao("Iphone");
		
		leilao.propoe(new Lance(gui, 100.0));
		leilao.propoe(new Lance(lavinia, 200.0));
		leilao.propoe(new Lance(gui, 300.0));
		leilao.propoe(new Lance(lavinia, 400.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		leiloeiro.getTresMaiores();
		
		List<Lance> maiores = leiloeiro.getTresMaiores();
		assertEquals(3, maiores.size());
		assertEquals(400.0, maiores.get(0).getValor(), 0.00001);
		assertEquals(300.0, maiores.get(1).getValor(), 0.00001);
		assertEquals(200.0, maiores.get(2).getValor(), 0.00001);
		
	}

}
