package br.usjt.arqdsis.sisPredial.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe respons�vel pela conex�o com banco de dados MySQL
 */
public abstract class AcessoBD {
	private static Connection conn;
	// -----------------------------------------------------------
	// Carrega driver JDBC
	//
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	// -----------------------------------------------------------
	// Obt�m conex�o com o banco de dados
	public static Connection getInstance() throws SQLException {
		if (conn == null) {
				conn = DriverManager.getConnection(
						//"jdbc:mysql://LocalHost:3306/sysPredial?user=alunos&password=alunos"
						"jdbc:mysql://LocalHost:3306/sysPredial?user=root&password="
				);
		}
		return conn;
	}
}