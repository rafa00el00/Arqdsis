package br.usjt.arqdsis.sisPredial.Core;

import br.usjt.arqdsis.sisPredial.DAO.UsuarioDao;
import br.usjt.arqdsis.sisPredial.Models.Usuario;
import br.usjt.arqdsis.sisPredial.ViewModels.LoginViewModel;

public class LoginNegocio {

	public UsuarioDao dao;

	public LoginNegocio() {
		dao = new UsuarioDao();
	}

	public Usuario doLogin(String userName, String password) {
		return doLogin(new LoginViewModel(userName, password));
	}
	public Usuario doLogin(LoginViewModel model) {
		return dao.consultar(model);
	}
	
	
}
