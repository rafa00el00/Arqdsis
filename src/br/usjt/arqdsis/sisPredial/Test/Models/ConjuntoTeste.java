package br.usjt.arqdsis.sisPredial.Test.Models;

import static org.junit.Assert.*;

import org.junit.Test;

import br.usjt.arqdsis.sisPredial.Models.Conjunto;

public class ConjuntoTeste {

	@Test
	public void testInserir() {
		Conjunto conjunto =  new Conjunto();
		conjunto.setAlugel(2000);
		conjunto.setAndar("1");
		conjunto.setNrConjunto("1");
		conjunto.setOcupado(false);
		conjunto.setTamanho(10);
		//conjunto.inserir();
	}

	@Test
	public void testAlterar() {
		Conjunto conjunto =  new Conjunto();
		conjunto.setId(1);
		conjunto.consultar();
		conjunto.setAlugel(2500);
		conjunto.alterar();
	}

	@Test
	public void testConsultar() {
		Conjunto conjunto =  new Conjunto();
		conjunto.setId(1);
		conjunto.consultar();
	}

	@Test
	public void testDeletar() {
		Conjunto conjunto =  new Conjunto();
		conjunto.setId(1);
		conjunto.consultar();
		conjunto.deletar();
	}

}
