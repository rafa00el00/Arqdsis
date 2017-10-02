package br.usjt.arqdsis.sisPredial.ViewModels;

import br.usjt.arqdsis.sisPredial.Models.IEntidade;

public class LoginViewModel extends IEntidade {

	private String login;
	private String password;

	public LoginViewModel() {
		// TODO Auto-generated constructor stub
	}

	public LoginViewModel(String UserName, String Password) {
		setLogin(UserName);
		setPassword(Password);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
