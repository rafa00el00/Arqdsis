package br.usjt.arqdsis.sisPredial.Test.Core;

import java.sql.Time;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import br.usjt.arqdsis.sisPredial.Core.Fachade;
import br.usjt.arqdsis.sisPredial.Models.Conjunto;
import br.usjt.arqdsis.sisPredial.Models.Empresa;
import br.usjt.arqdsis.sisPredial.Models.IEntidade;
import br.usjt.arqdsis.sisPredial.Models.Usuario;
import junit.framework.Assert;

public class FachadeTest {

	public static Fachade fachade;
	public final int millisegundoHour = 3600000;
	public final int fuso = 3600000 * 3;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		fachade = new Fachade();
	}
	
	@Test
	public void salvar() {
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
		empresa.setConjunto(cj);
		
		Assert.assertTrue("Erro ao Salvar Empresa",fachade.salvar(empresa));
		
		Usuario usr = new Usuario();
		usr.setCPF("40853569843");
		usr.setNome("Rafa");
		usr.setHoraAcesso(new Time(1000));
		Date dt = new Date();
		dt.setTime((millisegundoHour * 8)+ (millisegundoHour/2) + fuso);
		usr.setHoraAcesso(dt);
		dt = new Date();
		dt.setTime((millisegundoHour * 16)+fuso);
		usr.setHoraSaida(dt);
		usr.setLogin("rafa");
		usr.setSenha("123");
		usr.setPerfil(Usuario.TipoPerfil.Admin);
		usr.setEmpresa(empresa);
		
		Assert.assertTrue("Erro ao Salvar Usuario",fachade.salvar(usr));
		
	}
	
	public void consultar() {
		IEntidade entidade = new Empresa();
		entidade.setId(1);
		
		entidade = fachade.consultar(entidade);
		
		
		
		
	}



}
