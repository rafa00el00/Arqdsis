package br.usjt.arqdsis.sisPredial.Controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.arqdsis.sisPredial.Core.Fachade;
import br.usjt.arqdsis.sisPredial.Models.Conjunto;
import br.usjt.arqdsis.sisPredial.Models.Empresa;
import br.usjt.arqdsis.sisPredial.Models.IEntidade;
import br.usjt.arqdsis.sisPredial.Models.Usuario;

@RestController
public class CrudController {

	@Autowired
	private Fachade fachade;
	
	@RequestMapping(value="/Empresas",method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<IEntidade> getEntidades(){
		
		return fachade.consultarTodos(new Empresa());
	}
	
	@RequestMapping(value="/Empresas",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<IEntidade> postEntidade(@RequestBody Empresa entidade){
		
		System.out.println("Empresa: " + (entidade instanceof Empresa));
		/*System.out.println("Usuario: " + (entidade instanceof Usuario));
		System.out.println("Conjunto: " + (entidade instanceof Conjunto));*/
		
		try {
			return ResponseEntity.created(new URI("/Empresa/1")).body(entidade);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		
	}
	
	
}
