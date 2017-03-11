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
		dt = new Date();
		dt.setTime((millisegundoHour * 16)+fuso);
		usr.setHoraAcesso(dt);
		usr.setLogin("rafa");
		usr.setSenha("123");
		usr.setPerfil(Usuario.TipoPerfil.Admin);
		usr.setEmpresa(new Empresa("TEste","oi"));
		usr.getEmpresa().setId(1);
	}

	@Test
	public void testAlterar() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultar() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeletar() {
		fail("Not yet implemented");
	}

}
