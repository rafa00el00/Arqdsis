package br.usjt.arqdsis.sisPredial.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.usjt.arqdsis.sisPredial.Models.Conjunto;
import br.usjt.arqdsis.sisPredial.Models.Empresa;
import br.usjt.arqdsis.sisPredial.Models.IEntidade;

public class ConjuntoDao extends AbstractDao {

	public ConjuntoDao() {
		super();
	}

	// incluir
	public void incluir(Conjunto conjunto) {

		String sqlInsert = "INSERT INTO Conjunto(" + "nrConjunto" + ",Andar" + ",Alugel" + ",tamanho" + ",ocupado"
				+ ",empresaId" + ")" + " VALUES (?, ?, ?, ?, ?,?)";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert,Statement.RETURN_GENERATED_KEYS);
			stm.setString(1, conjunto.getNrConjunto());
			stm.setString(2, conjunto.getAndar());
			stm.setDouble(3, conjunto.getAlugel());
			stm.setInt(4, conjunto.getTamanho());
			stm.setBoolean(5, conjunto.isOcupado());
			if (conjunto.getEmpresa() != null)
				stm.setInt(6, conjunto.getEmpresa().getId());
			else
				stm.setNull(6, java.sql.Types.INTEGER);
			stm.executeUpdate();
			ResultSet rs = stm.getGeneratedKeys();
			rs.next();
			conjunto.setId(rs.getInt(1));
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
	}

	// alterar
	public void alterar(Conjunto conjunto) {

		String sqlInsert = "Update Conjunto set " + " nrConjunto = ?" + " ,Andar = ?" + " ,Alugel = ?" + " ,tamanho = ?"
				+ " ,ocupado = ?" + ",empresaId = ?" + "" + " where id = ?";

		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setString(1, conjunto.getNrConjunto());
			stm.setString(2, conjunto.getAndar());
			stm.setDouble(3, conjunto.getAlugel());
			stm.setInt(4, conjunto.getTamanho());
			stm.setBoolean(5, conjunto.isOcupado());
			if (conjunto.getEmpresa() != null)
				stm.setInt(6, conjunto.getEmpresa().getId());
			else
				stm.setNull(6, java.sql.Types.INTEGER);
			stm.setInt(7, conjunto.getId());
			stm.execute();
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
	}

	// Consultar
	public Conjunto consultar(IEntidade entidade) {
		String sqlSelect = "SELECT * FROM Conjunto";
		Conjunto conjunto;
		if (entidade instanceof Conjunto) {
			sqlSelect += " where id = ?";
			conjunto = (Conjunto) entidade;
		}else
			conjunto = new Conjunto();

		PreparedStatement stm = null;
		ResultSet rs = null;

		try {
			stm = conn.prepareStatement(sqlSelect);
			if (entidade instanceof Conjunto) {
				stm.setInt(1, entidade.getId());
			}
			rs = stm.executeQuery();
			while (rs.next()) {

				conjunto.setId(rs.getInt("id"));
				conjunto.setNrConjunto(rs.getString("nrConjunto"));
				conjunto.setAndar(rs.getString("Andar"));
				conjunto.setAlugel(rs.getDouble("Alugel"));
				conjunto.setTamanho(rs.getInt("tamanho"));
				conjunto.setOcupado(rs.getBoolean("ocupado"));
				if (rs.getInt("empresaId") != 0) {
					conjunto.setEmpresa(new Empresa());
					conjunto.getEmpresa().setId(rs.getInt("empresaId"));
					conjunto.getEmpresa().consultar();
				}
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
		return (conjunto);
	}

	// Consultar
	public List<Conjunto> consultarTodos(IEntidade entidade) {
		String sqlSelect = "SELECT * FROM Conjunto";
		List<Conjunto> conjuntos = new ArrayList<Conjunto>();
		Conjunto conjunto;

		PreparedStatement stm = null;
		ResultSet rs = null;

		try {
			stm = conn.prepareStatement(sqlSelect);

			rs = stm.executeQuery();
			while (rs.next()) {
				conjunto = new Conjunto();
				conjunto.setId(rs.getInt("id"));
				conjunto.setNrConjunto(rs.getString("nrConjunto"));
				conjunto.setAndar(rs.getString("Andar"));
				conjunto.setAlugel(rs.getDouble("Alugel"));
				conjunto.setTamanho(rs.getInt("tamanho"));
				conjunto.setOcupado(rs.getBoolean("ocupado"));
				if (rs.getInt("empresaId") != 0) {
					conjunto.setEmpresa(new Empresa());
					conjunto.getEmpresa().setId(rs.getInt("empresaId"));
					conjunto.getEmpresa().consultar();
				}
				conjuntos.add(conjunto);

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
		return conjuntos;
	}

	public boolean deletar(Conjunto conjunto) {
		String sqlInsert = "Delete from Conjunto " + " where id = ?";

		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setInt(1, conjunto.getId());
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
			return false;
		}

	}

}
