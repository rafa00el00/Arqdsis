package br.usjt.arqdsis.sisPredial.DispacherPathsEntity;

public class UsuarioDispacherPath extends IDispacherPathEntidade {

	@Override
	public String post() {
		return "Views/VisualizarUsuario.jsp";
	}

	@Override
	public String get() {
		return "Views/VisualizarUsuario.jsp";
	}

	@Override
	public String put() {
		return "Views/VisualizarUsuario.jsp";
	}

	@Override
	public String delete() {
		return "Views/CarregarUsuario.jsp";
	}

}
