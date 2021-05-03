package br.com.systemsgs.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.systemsgs.Lance;
import br.com.systemsgs.Leilao;
import br.com.systemsgs.Usuario;

public class LeilaoTest {
	
	@Test
	public void deveReceberUmLance() {
		Leilao leilao = new Leilao("Iphone 6");
		assertEquals(0, leilao.getLances().size());
		
		leilao.propoe(new Lance(new Usuario("Guilherme Santos"), 2000));
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
		
	}
	
	@Test
	public void deveReceberVariosLances() {
		Leilao leilao = new Leilao("Notebook i7");
		leilao.propoe(new Lance(new Usuario("Guilherme"), 2000));
		leilao.propoe(new Lance(new Usuario("Lavinia"), 3000));
		
		assertEquals(2, leilao.getLances().size());
		assertEquals(2000, leilao.getLances().get(0).getValor(), 0.00001);
		assertEquals(3000, leilao.getLances().get(1).getValor(), 0.0001);
		
	}

}
