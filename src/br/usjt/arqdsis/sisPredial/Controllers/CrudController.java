package br.usjt.arqdsis.sisPredial.Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdsis.sisPredial.DAO.AbstractDao;
import br.usjt.arqdsis.sisPredial.Factorys.FactoryDao;
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
	
    
    public CrudController() {
       factoryDao = new FactoryDao();
       factoryViewHelper = new FactoryViewHelper();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IViewHelper vhp = factoryViewHelper.criar(request);
		IEntidade entidade = vhp.criar(request);
		AbstractDao dao = factoryDao.criar(entidade);
		dao.incluir(entidade);
	}

}
