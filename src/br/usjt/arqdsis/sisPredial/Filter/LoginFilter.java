package br.usjt.arqdsis.sisPredial.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqdsis.sisPredial.Models.Usuario;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		Usuario logado = (Usuario) session.getAttribute("logado");
		String path = req.getContextPath();
		String uri = req.getRequestURI();
		String comando = req.getParameter("command");
		if (comando == null) {
			comando = "";
		}
		if(logado == null && (uri.equals(path + "/Usuario") || uri.equals(path + "/login.jsp")))
		{
			// pass the request along the filter chain
			chain.doFilter(request, response);
			return;
		}
		if (logado == null && !uri.equals(path + "/login.jsp") && !comando.equals("FazerLogin") ) {
			((HttpServletResponse) response).sendRedirect(path + "/login.jsp");
		}else
		{
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
