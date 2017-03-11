package br.usjt.arqdsis.sisPredial.Test.Models;

import static org.junit.Assert.fail;

import java.sql.Time;

import org.junit.Test;

import br.usjt.arqdsis.sisPredial.Models.Conjunto;
import br.usjt.arqdsis.sisPredial.Models.Empresa;
import junit.framework.Assert;

public class EmpresaTest {

	
	@Test
	public void testIncluir() {
		Empresa empresa = new Empresa();
		empresa.setCnpj("000000000");
		empresa.setRazaoSocial("Teste");
		empresa.setHoraFimAr(new Time(16,0,0));
		empresa.setHoraIniAr(new Time(8,30,0));
		empresa.setHorarioAbertura(new Time(8,0,0));
		empresa.setHorarioFechamento(new Time(16,0,0));
		empresa.setTemperaturaPadrao(24);
		Conjunto cj = new Conjunto();
		cj.setAlugel(2000.0);
		cj.setNrConjunto("1");
		cj.setAndar("1");
		cj.setTamanho(50);
		//empresa.incluir();
		Assert.assertEquals("Empresa não é Igual",new Empresa("000000000","Teste"), empresa.getId());
		
	}

	@Test
	public void testAlterar() {
		Empresa empresa =  new Empresa();
		empresa.setId(2);
		empresa.consultar();
		
		empresa.setCnpj("123456789");
		empresa.alterar();
		empresa.consultar();
		Assert.assertEquals("Empresa não é Igual",new Empresa("123456789","Teste"), empresa.getId());
		
	}

	@Test
	public void testConsultar() {
		Empresa empresa =  new Empresa();
		empresa.setId(2);
		empresa.consultar();
		Assert.assertEquals("Empresa não é Igual",new Empresa("123456789","Teste"), empresa);
	}

	@Test
	public void testDeletar() {
		Empresa empresa =  new Empresa();
		empresa.setId(2);
		empresa.consultar();
		//empresa.deletar();
		Assert.assertTrue(true);
	}

}
