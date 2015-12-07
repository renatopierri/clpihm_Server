/**
 * 
 */
package br.com.nets_nuts.clpihm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author renato.pierri@gmail.com Trata-se de uma classe exclusiva para criar a
 *         conexão ao banco de dados MySQL
 */
public class ConFactory {

	public static final int MYSQL = 0;
	private static final String MySQLDriver = "com.mysql.jdbc.Driver";

	/**
	 * Fazendo a conexão com o banco de dados.
	 * @param url - String com o nome do servidor.
	 * @param nome - String com o nome do usuário.
	 * @param senha - String com a senha do usuário.
	 * @param banco - Inteiro banco.
	 * @return conexao - Conexão com o banco de dados.
	 * @throws ClassNotFoundException - Erro na conexão com o banco de dados.
	 * @throws SQLException - Erro na conexão com o banco de dados.
	 * */
	public static Connection conexao(String url, String nome, String senha,
			int banco) throws ClassNotFoundException, SQLException {
		switch (banco) {
		case MYSQL:
			Class.forName(MySQLDriver);
			break;
		}
		return DriverManager.getConnection(url, nome, senha);
	}
}
