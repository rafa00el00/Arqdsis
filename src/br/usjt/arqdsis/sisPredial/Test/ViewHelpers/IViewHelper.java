package br.usjt.arqdsis.sisPredial.Test.ViewHelpers;

import javax.servlet.http.HttpServletRequest;

import br.usjt.arqdsis.sisPredial.Models.IEntidade;

public interface IViewHelper {

	IEntidade criar(HttpServletRequest request);
}
