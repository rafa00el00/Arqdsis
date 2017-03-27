package br.usjt.arqdsis.sisPredial.Factorys;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import br.usjt.arqdsis.sisPredial.Models.Usuario;
import br.usjt.arqdsis.sisPredial.Test.ViewHelpers.IViewHelper;
import br.usjt.arqdsis.sisPredial.Test.ViewHelpers.UsuarioViewHelper;

public class FactoryViewHelper implements IFactory<IViewHelper> {

	private HashMap<String, IViewHelper> mapViewHelper;
	
	public FactoryViewHelper() {
		mapViewHelper = new HashMap<>();
		
		mapViewHelper.put("usuario", new UsuarioViewHelper());
		
	}
	
	
	@Override
	public IViewHelper criar(Object obj) {
		
		if ( obj == null)
			return null;
		
		if (!(obj instanceof HttpServletRequest))
			return null;
		
		return mapViewHelper.get(((HttpServletRequest) obj).getParameter("entidaName"));
	}

}
