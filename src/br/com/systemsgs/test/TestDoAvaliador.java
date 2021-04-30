package br.com.systemsgs.test;

import br.com.systemsgs.Lance;
import br.com.systemsgs.Leilao;
import br.com.systemsgs.Usuario;

public class TestDoAvaliador {
	
	public static void main(String[] args) {
		Usuario gui = new Usuario("Guilherme");
		Usuario lavinia = new Usuario("Lavinia");
		Usuario marcela = new Usuario("Marcela");
		
		Leilao leilao = new Leilao("Computador i7");
		leilao.propoe(new Lance(gui, 400.0));
		leilao.propoe(new Lance(lavinia, 500.0));
		leilao.propoe(new Lance(marcela, 250.0));
		
	}

}
