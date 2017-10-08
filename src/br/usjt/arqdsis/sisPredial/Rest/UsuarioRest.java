package br.usjt.arqdsis.sisPredial.Rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import br.usjt.arqdsis.sisPredial.Core.FachadeUsuario;
import br.usjt.arqdsis.sisPredial.DAO.AbstractDao;
import br.usjt.arqdsis.sisPredial.DAO.UsuarioDao;
import br.usjt.arqdsis.sisPredial.Models.Usuario;
import br.usjt.arqdsis.sisPredial.Utils.JSonFacade;

@WebServlet("/Usuario")
public class UsuarioRest extends HttpServlet {

	/*
	 * configurar a request e a response para todos os métodos
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		super.service(request, response);
	}

	/*
	 * listar clientes
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String chave = request.getParameter("chave");
		FachadeUsuario usuarioBo = new FachadeUsuario();
		ArrayList<Usuario> lista = null;

		PrintWriter out = response.getWriter();

		try {
			AbstractDao dao = new UsuarioDao();
			lista = (ArrayList<Usuario>)dao.consultarTodos(new Usuario());
			out.println("[");
			out.println(lista.get(0).toJson());
			for (int i = 1; i < lista.size(); i++) {				
				out.println("," +lista.get(i).toJson());
			}
			out.println("]");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * inclusão de clientes
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StringBuilder sb = JSonFacade.montaJSon(request);
		PrintWriter out = response.getWriter();

		try {
			Usuario usuario = (new Usuario()).fromJson(sb.toString());
			AbstractDao dao = new UsuarioDao();
			dao.incluir(usuario);
			// retorna o cliente cadastrado com o id atribuido pelo banco
			out.println(usuario.toJson());
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
	}

	/*
	 * atualiza clientes
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StringBuilder sb = JSonFacade.montaJSon(request);
		PrintWriter out = response.getWriter();

		try {
			Usuario usuario = (new Usuario()).fromJson(sb.toString());
			AbstractDao dao = new UsuarioDao();
			dao.alterar(usuario);
			// retorna o cliente atualizado
			out.println(usuario.toJson());
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
	}

	/*
	 * exclusão de clientes
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuilder sb = JSonFacade.montaJSon(request);
		PrintWriter out = response.getWriter();

		try {
			Usuario usuario = (new Usuario()).fromJson(sb.toString());
			AbstractDao dao = new UsuarioDao();
			dao.deletar(usuario);
			// retorna o cliente atualizado
			out.println(usuario.toJson());
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
	}

}
