package br.usjt.arqdsis.sisPredial.Core;

import java.util.List;

import br.usjt.arqdsis.sisPredial.DAO.AbstractDao;
import br.usjt.arqdsis.sisPredial.Factorys.FactoryDao;
import br.usjt.arqdsis.sisPredial.Factorys.IFactory;
import br.usjt.arqdsis.sisPredial.Models.IEntidade;

public class Fachade {

	IFactory factoryDao;

	public Fachade() {
		factoryDao = new FactoryDao();
	}

	public boolean salvar(IEntidade entidade) {
		AbstractDao dao = (AbstractDao) factoryDao.criar(entidade);

		if (dao == null)
			return false;

		return dao.incluir(entidade);
	}

	public IEntidade consultar(IEntidade entidade) {
		AbstractDao dao = (AbstractDao) factoryDao.criar(entidade);

		if (dao == null)
			return null;

		return (IEntidade) dao.consultar(entidade);
	}

	public List<IEntidade> consultarTodos(IEntidade entidade) {
		AbstractDao dao = (AbstractDao) factoryDao.criar(entidade);

		if (dao == null)
			return null;

		return dao.consultarTodos(entidade);
	}

	public boolean alterar(IEntidade entidade) {
		AbstractDao dao = (AbstractDao) factoryDao.criar(entidade);

		if (dao == null)
			return false;

		return dao.alterar(entidade);
	}

	public boolean deletar(IEntidade entidade) {
		AbstractDao dao = (AbstractDao) factoryDao.criar(entidade);

		if (dao == null)
			return false;

		return dao.deletar(entidade);
	}

}
