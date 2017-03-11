package br.usjt.arqdsis.sisPredial.Test.Models;

import static org.junit.Assert.fail;

import java.sql.Time;
import java.util.Date;

import org.junit.Test;

import br.usjt.arqdsis.sisPredial.Models.Empresa;
import br.usjt.arqdsis.sisPredial.Models.Usuario;

public class UsuarioTest {

	public final int millisegundoHour = 3600000;
	public final int fuso = 3600000 * 3;
	
	@Test
	public void testIncluir() {
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
		usr.setEmpresa(new Empresa());
		usr.getEmpresa().setId(2);
		usr.getEmpresa().consultar();
		
		//usr.incluir();
		
	}

	@Test
	public void testAlterar() {
		Usuario usr = new Usuario();
		usr.setId(1);
		usr.consultar();
		usr.setNome("Rafinha");
		usr.alterar();
		
	}

	@Test
	public void testConsultar() {
		Usuario usr = new Usuario();
		usr.setId(1);
		usr.consultar();
		
		
	}

	@Test
	public void testDeletar() {
		Usuario usr = new Usuario();
		usr.setId(1);
		usr.consultar();
		usr.deletar();
	}

}
