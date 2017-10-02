package br.usjt.arqdsis.sisPredial.ViewHelpers;

import javax.servlet.http.HttpServletRequest;

import br.usjt.arqdsis.sisPredial.Models.IEntidade;
import br.usjt.arqdsis.sisPredial.ViewModels.LoginViewModel;

public class LoginViewHelper implements IViewHelper {

	@Override
	public IEntidade criar(HttpServletRequest request) {
			
		LoginViewModel login = new LoginViewModel();
		
		login.setLogin(request.getParameter("login"));
		login.setPassword(request.getParameter("password"));
		
		return login;
	}

}
