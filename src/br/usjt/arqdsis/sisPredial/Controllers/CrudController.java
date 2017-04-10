package br.usjt.arqdsis.sisPredial.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jws.WebMethod;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdsis.sisPredial.Core.IFachade;
import br.usjt.arqdsis.sisPredial.DAO.AbstractDao;
import br.usjt.arqdsis.sisPredial.DispacherPathsEntity.IDispacherPathEntidade;
import br.usjt.arqdsis.sisPredial.Factorys.FactoryDao;
import br.usjt.arqdsis.sisPredial.Factorys.FactoryDispacherPath;
import br.usjt.arqdsis.sisPredial.Factorys.FactoryFachade;
import br.usjt.arqdsis.sisPredial.Factorys.FactoryViewHelper;
import br.usjt.arqdsis.sisPredial.Models.IEntidade;
import br.usjt.arqdsis.sisPredial.ViewHelpers.IViewHelper;

/**
 * Servlet implementation class CrudController
 */
@WebServlet("/CrudController.do")
public class CrudController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FactoryViewHelper factoryViewHelper;
	private FactoryFachade fachadeFactory;

	public CrudController() {
		factoryViewHelper = new FactoryViewHelper();
		fachadeFactory = FactoryFachade.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IViewHelper vhp = factoryViewHelper.criar(request);
		IFachade fachade = fachadeFactory.criar(vhp.criar(request));

		RequestDispatcher view;
		if (request.getParameter("_method").equals("get"))
			if (request.getParameter("page") != null && request.getParameter("page").equals("create"))
				view = fachade.createPage(request, response);
			else if (request.getParameter("page") != null && request.getParameter("page").equals("update"))
				view = fachade.updatePage(request, response);
			else
				view = fachade.read(request, response);
		else if (request.getParameter("_method").equals("delete"))
			view = fachade.delete(request, response);
		else
			view = fachade.badRequest(request);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IViewHelper vhp = factoryViewHelper.criar(request);
		IFachade fachade = fachadeFactory.criar(vhp.criar(request));

		RequestDispatcher view;
		if (request.getParameter("_method").equals("post"))
			view = fachade.create(request, response);
		else if (request.getParameter("_method").equals("put"))
			view = fachade.update(request, response);
		else
			view = fachade.badRequest(request);

		view.forward(request, response);
	}

}
