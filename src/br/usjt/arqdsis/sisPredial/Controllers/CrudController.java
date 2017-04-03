package br.usjt.arqdsis.sisPredial.Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdsis.sisPredial.DAO.AbstractDao;
import br.usjt.arqdsis.sisPredial.DispacherPathsEntity.IDispacherPathEntidade;
import br.usjt.arqdsis.sisPredial.Factorys.FactoryDao;
import br.usjt.arqdsis.sisPredial.Factorys.FactoryDispacherPath;
import br.usjt.arqdsis.sisPredial.Factorys.FactoryViewHelper;
import br.usjt.arqdsis.sisPredial.Models.IEntidade;
import br.usjt.arqdsis.sisPredial.Test.ViewHelpers.IViewHelper;

/**
 * Servlet implementation class CrudController
 */
@WebServlet("/CrudController.do")
public class CrudController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FactoryDao factoryDao;
	private FactoryViewHelper factoryViewHelper;
	private FactoryDispacherPath factoryDispacherPath;
	
    
    public CrudController() {
       factoryDao = new FactoryDao();
       factoryViewHelper = new FactoryViewHelper();
       factoryDispacherPath = new FactoryDispacherPath();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IViewHelper vhp = factoryViewHelper.criar(request);
		IEntidade entidade = vhp.criar(request);
		AbstractDao dao = factoryDao.criar(entidade);
		List<IEntidade> entidades = null;
		if (request.getParameter("all") != null && request.getParameter("all").equals("false"))
		dao.consultar(entidade);
		else
			entidades = dao.consultarTodos(entidade);
		
		request.setAttribute("entidade", entidade);
		request.setAttribute("entidades", entidades);
		IDispacherPathEntidade path = factoryDispacherPath.criar(entidade);
		if (path == null)
			return;
		RequestDispatcher view = request.getRequestDispatcher("404") ;
		
		if (entidades == null)
			view = request.getRequestDispatcher(path.get());
		else
			view = request.getRequestDispatcher(path.query());
		view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IViewHelper vhp = factoryViewHelper.criar(request);
		IEntidade entidade = vhp.criar(request);
		AbstractDao dao = factoryDao.criar(entidade);
		dao.incluir(entidade);
		
		request.setAttribute("entidade", entidade);
		IDispacherPathEntidade path = factoryDispacherPath.criar(entidade);
		if (path == null)
			return;
		RequestDispatcher view = request.getRequestDispatcher(path.post());
		view.forward(request, response);
	}

}
