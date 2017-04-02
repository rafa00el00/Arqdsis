package br.usjt.arqdsis.sisPredial.Factorys;

import java.util.HashMap;

import org.hamcrest.core.IsInstanceOf;

import br.usjt.arqdsis.sisPredial.DispacherPathsEntity.IDispacherPathEntidade;
import br.usjt.arqdsis.sisPredial.DispacherPathsEntity.UsuarioDispacherPath;
import br.usjt.arqdsis.sisPredial.Models.Conjunto;
import br.usjt.arqdsis.sisPredial.Models.Empresa;
import br.usjt.arqdsis.sisPredial.Models.IEntidade;
import br.usjt.arqdsis.sisPredial.Models.Usuario;

public class FactoryDispacherPath implements IFactory<IDispacherPathEntidade> {

	private HashMap<String, IDispacherPathEntidade> map;
	
	public FactoryDispacherPath() {
		map = new HashMap<>();
		
		map.put(Usuario.class.getName(), new UsuarioDispacherPath());
		map.put(Empresa.class.getName(), new UsuarioDispacherPath());
		map.put(Conjunto.class.getName(), new UsuarioDispacherPath());
	}
	
	@Override
	public IDispacherPathEntidade criar(Object obj) {

		if (obj == null)
			return null;
		
		if(!(obj instanceof IEntidade))
			return null;
		
		if (map.containsKey(obj.getClass().getName()))
			return map.get(obj.getClass().getName());
		
		return null;
	}

}
