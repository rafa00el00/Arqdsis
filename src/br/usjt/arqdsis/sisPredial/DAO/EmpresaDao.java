package br.usjt.arqdsis.sisPredial.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.usjt.arqdsis.sisPredial.Models.Conjunto;
import br.usjt.arqdsis.sisPredial.Models.Empresa;
import br.usjt.arqdsis.sisPredial.Models.IEntidade;

public class EmpresaDao extends AbstractDao<Empresa> {

	private ConjuntoDao daoConjunto;

	public EmpresaDao() {
		super();
		//daoConjunto = new ConjuntoDao();
	}

	// incluir
	public boolean incluir(Empresa empresa) {

		String sqlInsert = "INSERT INTO Empresa(" + "CNPJ" + ",RAZAOSOCIAL" + ",temperaturaPadrao" + ",horarioAbertura"
				+ ",horarioFechamento" + ",horaIniAr" + ",horaFimAr" + ",conjuntoId" + ")" + " VALUES (?, ?, ?, ?, ?,?,?)";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			stm.setString(1, empresa.getCnpj());
			stm.setString(2, empresa.getRazaoSocial());
			stm.setInt(3, empresa.getTemperaturaPadrao());
			stm.setTime(4, empresa.getHorarioAbertura());
			stm.setTime(5, empresa.getHorarioFechamento());
			stm.setTime(6, empresa.getHoraIniAr());
			stm.setTime(7, empresa.getHoraFimAr());
			if(empresa.getConjunto() != null)
				stm.setInt(8, empresa.getConjunto().getId());
			else
				stm.setNull(8, java.sql.Types.INTEGER);
			stm.executeUpdate();

			ResultSet rs = stm.getGeneratedKeys();
			rs.next();
			empresa.setId(rs.getInt(1));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			} finally {
				if (stm != null) {
					try {
						stm.close();
					} catch (SQLException e1) {
						System.out.print(e1.getStackTrace());
					}
				}
			}
		}
		return false;
	}

	// alterar
	public boolean alterar(Empresa empresa) {

		String sqlInsert = "Update Empresa set " + "CNPJ = ?" + ",RAZAOSOCIAL = ?" + ",TemperaturaPadrao = ?"
				+ ",horarioAbertura = ?" + ",horarioFechamento = ?" + ",horaIniAr = ?" + ",horaFimAr = ?" + ",conjuntoId = ?"
				+ " where id = ?";

		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setString(1, empresa.getCnpj());
			stm.setString(2, empresa.getRazaoSocial());
			stm.setInt(3, empresa.getTemperaturaPadrao());
			stm.setTime(4, empresa.getHorarioAbertura());
			stm.setTime(5, empresa.getHorarioFechamento());
			stm.setTime(6, empresa.getHoraIniAr());
			stm.setTime(7, empresa.getHoraFimAr());
			if(empresa.getConjunto() != null)
				stm.setInt(8, empresa.getConjunto().getId());
			else
				stm.setNull(8, java.sql.Types.INTEGER);
			stm.setInt(9, empresa.getId());
			stm.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			} finally {
				if (stm != null) {
					try {
						stm.close();
					} catch (SQLException e1) {
						System.out.print(e1.getStackTrace());
					}
				}
			}
		}
		return false;
	}

	// Consultar
	public Empresa consultar(IEntidade obj) {
		String sqlSelect = "SELECT * FROM Empresa";
		if (obj instanceof Empresa) {
			sqlSelect += " where id = ?";
		}
		Empresa empresa = (Empresa) obj;
		PreparedStatement stm = null;
		ResultSet rs = null;
		ConjuntoDao conjuntoDao = new ConjuntoDao();

		try {
			stm = conn.prepareStatement(sqlSelect);

			stm.setInt(1, empresa.getId());

			rs = stm.executeQuery();
			Conjunto cj;
			while (rs.next()) {

				empresa.setId(rs.getInt("id"));
				empresa.setCnpj(rs.getString("cnpj"));
				empresa.setRazaoSocial(rs.getString("razaosocial"));
				empresa.setTemperaturaPadrao(rs.getInt("TemperaturaPadrao"));
				empresa.setHorarioAbertura(rs.getTime("horarioAbertura"));
				empresa.setHorarioFechamento(rs.getTime("horarioFechamento"));
				empresa.setHoraIniAr(rs.getTime("horaIniAr"));
				empresa.setHoraFimAr(rs.getTime("horaFimAr"));
				/*if ( rs.getInt("conjuntoId") != 0){
					empresa.setConjunto(new Conjunto());
					empresa.getConjunto().setId(rs.getInt("conjuntoId"));
					conjuntoDao.consultar(empresa.getConjunto());
				}*/
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return (empresa);
	}

	// Consultar
	public List<Empresa> consultarTodos(IEntidade entidade) {
		String sqlSelect = "SELECT * FROM Empresa";
		List<Empresa> empresas = new ArrayList<Empresa>();

		/*
		 * if (entidade instanceof Empresa){ sqlSelect += " where id = ?"; }
		 */

		PreparedStatement stm = null;
		ResultSet rs = null;
		Empresa empresa = new Empresa();
		ConjuntoDao conjuntoDao = new ConjuntoDao();
		try {
			stm = conn.prepareStatement(sqlSelect);
			/*
			 * if (entidade instanceof Usuario){ //traz todos }else if (entidade
			 * instanceof Empresa){ stm.setInt(1,((Empresa)entidade).getId()); }
			 */
			rs = stm.executeQuery();
			Conjunto cj;
			while (rs.next()) {
				empresa = new Empresa();
				empresa.setId(rs.getInt("id"));
				empresa.setCnpj(rs.getString("cnpj"));
				empresa.setRazaoSocial(rs.getString("razaosocial"));
				empresa.setTemperaturaPadrao(rs.getInt("TemperaturaPadrao"));
				empresa.setHorarioAbertura(rs.getTime("horarioAbertura"));
				empresa.setHorarioFechamento(rs.getTime("horarioFechamento"));
				empresa.setHoraIniAr(rs.getTime("horaIniAr"));
				empresa.setHoraFimAr(rs.getTime("horaFimAr"));
				
				/*if ( rs.getInt("conjuntoId") != 0){
					empresa.setConjunto(new Conjunto());
					empresa.getConjunto().setId(rs.getInt("conjuntoId"));
					conjuntoDao.consultar(empresa.getConjunto());
				}/*/
				empresas.add(empresa);

			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return empresas;
	}

	public boolean deletar(Empresa empresa) {
		String sqlInsert = "Delete from Empresa" + " where id = ?";

		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setInt(1, empresa.getId());
			stm.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return false;
	}

}
