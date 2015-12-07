/**
 * 
 */
package br.com.nets_nuts.clpihm.dao;

import java.sql.Connection;

import javax.swing.JOptionPane;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import br.com.nets_nuts.clpihm.model.*;
import br.com.nets_nuts.clpihm.dao.ConFactory;

/**
 * 
 * Esta classe provê os comandos para gerenciamento do banco de dados SELECT,
 * UPDATE, INSERT e DELETE, bem como os s privados para conectar ao banco,
 * desconectar do banco e apresentar mensagens de erro do MySQL.
 * 
 * @author Renato de Pierri - renato.pierri@gmail.com
 *
 */
public class DaoCLP {

	// Criando as variáveis de conexão com o banco de dados.
	private Connection con;
	private Statement comando;
	private ResultSet rs;
	private ResultSetMetaData meta;
	private Vector<Log> resultados = new Vector<Log>();
	private int columnCount;
	private String nomeColunas;

	/**
	 * Configurando a string de conexão com o banco de dados. private final
	 * String URL = "jdbc:mysql://192.168.2.103/monografia", NOME = "renato",
	 * SENHA = "123456";
	 * 
	 */
	private final String URL = "jdbc:mysql://localhost/monografia",
			NOME = "renato", SENHA = "123456";

	/**
	 * Método para agagar linha seguindo critétio da coluna idlog. Esse método
	 * retorna '-1' se der erro na exclusão da linha, '0' se a linha não for
	 * encontrada no banco de dados e '1' se a exclusão for bem sucedida.
	 * 
	 * @param idlog
	 *            Inteiro indicando o número da linha a ser excluída no banco de
	 *            dados.
	 * @return O número da linha excluída ou '-1' se der erro.
	 * */

	public int apagar(Integer idlog) {
		conectar();
		int linha = 0;
		try {
			linha = comando.executeUpdate("DELETE FROM log WHERE idlog ='"
					+ idlog + "';");
		} catch (SQLException e) {
			imprimeErro("Erro ao apagar valores", e.getMessage());
			return -1;
		} finally {
			fechar();
			return linha;
		}
	}

	/**
	 * Método para listar todos os registros do banco de dados.
	 * 
	 * @return Vetor de logs onde cada índice corresponde a uma linha de
	 *         registro encontrada.
	 * */
	public Vector<Log> buscarTodos() {
		conectar();
		try {
			rs = comando.executeQuery("SELECT * FROM log order by idlog desc");
			meta = rs.getMetaData();
			itera();
			return resultados;
		} catch (SQLException e) {
			imprimeErro("Erro ao buscar Logs", e.getMessage());
			return null;
		}
	}

	/**
	 * Método para atualizar o banco de dados.
	 * 
	 * @param log
	 *            - Recebe um objeto tipo log que corresponde a uma linha a ser
	 *            incluída no sistema.
	 * */
	public void atualizar(Log log) {
		conectar();
		String com = "UPDATE Log SET hr_sistema = '" + log.getHr_clp()
				+ log.getHr_Sistema() + ", o0 = '" + log.getO0() + ", o1 = '"
				+ log.getO1() + ", o2 = '" + log.getO2() + ", o3 = '"
				+ log.getO3() + ", o4 = '" + log.getO4() + ", o5 = '"
				+ log.getO5() + ", o6 = '" + log.getO6() + ", o7 = '"
				+ log.getO7() + ", o8 = '" + log.getO8() + ", o9 = '"
				+ log.getO9() + ", o10 = '" + log.getO10() + ", o11 = '"
				+ log.getO11() + ", i0 = '" + log.getI0() + ", i1 = '"
				+ log.getI1() + ", i2 = '" + log.getI2() + ", i3 = '"
				+ log.getI3() + ", i4 = '" + log.getI4() + ", i5 = '"
				+ log.getI5() + ", i6 = '" + log.getI6() + ", i7 = '"
				+ log.getI7() + ", i8 = '" + log.getI8() + ", i9 = '"
				+ log.getI9() + ", an1 = '" + log.getAN1() + ", an0 = '"
				+ log.getAN0() + "' WHERE hr_sistema = '" + log.getHr_Sistema()
				+ "';";
		System.out.println("Atualizada!");
		try {
			comando.executeUpdate(com);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fechar();
		}
	}

	/**
	 * Método para selecionar uma tupla de acordo com um determinado critério da
	 * coluna idlog.
	 * 
	 * @param nCampo
	 *            String contendo o nome do campo
	 * @param cPesquisa
	 *            String contendo o valor a ser pesquisado
	 * @return vetor de logs onde cada índice do vetor corresponde a uma linha
	 *         encontrada.
	 * */
	public Vector<Log> buscar(String nCampo, String cPesquisa) {
		conectar();
		String select;
		try {
			// SELECT * FROM log WHERE idlog LIKE '5%';
			// SELECT * FROM log WHERE <NOME DO CAMPO> LIKE '<CRITERIO>';
			// "SELECT * FROM log WHERE " + <NOME DO CAMPO> + " LIKE '"+
			// <CRITERIO> +"';"
			select = "SELECT * FROM log WHERE " + nCampo + " LIKE '"
					+ cPesquisa + "';";
			rs = comando.executeQuery(select);
			meta = rs.getMetaData();
			itera();
			return resultados;
		} catch (SQLException e) {
			imprimeErro("Erro ao buscar Log", e.getMessage());
			return null;
		}
	}

	/**
	 * Método para inserir dados no database.
	 * 
	 * @param log
	 *            Objeto do tipo log contendo os dados da linha a ser inserida
	 * @return boolean TRUE - Dado inserido Ok. FALSE - Erro na inserção do
	 *         dado.
	 * */
	public Boolean insere(Log log) {
		conectar();
		String atualiza;
		try {
			leColunas();
			// Pegando a hora do sistema
			log.setHr_Sistema();

			// Montando a string para inserir dados de teste no banco de dados.
			atualiza = "INSERT INTO log (" + nomeColunas + ") VALUES('"
					+ log.getHr_clp() + "', '" + log.getNome_CLP() + "', '"
					+ log.getHr_Sistema() + "', " + log.getO0() + ", "
					+ log.getO1() + ", " + log.getO2() + ", " + log.getO3()
					+ ", " + log.getO4() + ", " + log.getO5() + ", "
					+ log.getO6() + ", " + log.getO7() + ", " + log.getO8()
					+ ", " + log.getO9() + ", " + log.getO10() + ", "
					+ log.getO11() + ", " + log.getI0() + ", " + log.getI1()
					+ ", " + log.getI2() + ", " + log.getI3() + ", "
					+ log.getI4() + ", " + log.getI5() + ", " + log.getI6()
					+ ", " + log.getI7() + ", " + log.getI8() + ", "
					+ log.getI9() + ", '" + log.getAN0() + "', '"
					+ log.getAN1() + "')";

			// Imprimindo a string de conexão ao banco de dados na saída padrão.
			System.out.println(atualiza);

			// Executando a atualização do banco de dados.
			comando.executeUpdate(atualiza);

			// Testando a inclusão de dados.
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Erro na atualização do banco de dados");
			return false;
		} finally {
			System.out.println("Dados atualizados!");
			fechar();
		}
		return true;
	}

	/** Conectando com o banco de dados */
	private void conectar() {
		try {
			con = ConFactory.conexao(URL, NOME, SENHA, ConFactory.MYSQL);
			comando = con.createStatement();
			System.out.println("Conectado!");
		} catch (ClassNotFoundException e) {
			imprimeErro("Erro ao carregar o driver", e.getMessage());
		} catch (SQLException e) {
			imprimeErro("Erro ao conectar", e.getMessage());
		}
	}

	/** Fechando a conexão com o banco de dados. */
	private void fechar() {
		try {
			comando.close();
			con.close();
			System.out.println("Conexão Fechada");
		} catch (SQLException e) {
			imprimeErro("Erro ao fechar conexão", e.getMessage());
		}
	}

	/**
	 * Apresentando a mensagem de erro
	 * 
	 * @param msg
	 *            String que contém a descrição do erro.
	 * @param msgErro
	 *            - String com o detalhe do erro a ser impresso na saída padrão.
	 * */
	private void imprimeErro(String msg, String msgErro) {
		JOptionPane.showMessageDialog(null, msg, "Erro crítico", 0);
		System.err.println(msg);
		System.out.println(msgErro);
		System.exit(0);
	}

	/**
	 * @return the meta
	 */
	private ResultSetMetaData getMeta() {
		return meta;
	}

	/**
	 * @return the rs
	 */

	private ResultSet getRs() {
		return rs;
	}

	/** Populando o vetor de logs */
	private void itera() {
		try {
			while (rs.next()) {
				Log temp = new Log();
				// temp.setIdlog(rs.getInt("idlog"));
				temp.setIdlog(rs.getInt(meta.getColumnLabel(1)));
				temp.setHr_CLP(rs.getString(meta.getColumnLabel(2)));
				temp.setNome_CLP(rs.getString(meta.getColumnLabel(3)));
				temp.setHr_Sistema(rs.getString(meta.getColumnLabel(4)));
				temp.setO0(rs.getBoolean(meta.getColumnLabel(5)));
				temp.setO1(rs.getBoolean(meta.getColumnLabel(6)));
				temp.setO2(rs.getBoolean(meta.getColumnLabel(7)));
				temp.setO3(rs.getBoolean(meta.getColumnLabel(8)));
				temp.setO4(rs.getBoolean(meta.getColumnLabel(9)));
				temp.setO5(rs.getBoolean(meta.getColumnLabel(10)));
				temp.setO6(rs.getBoolean(meta.getColumnLabel(11)));
				temp.setO7(rs.getBoolean(meta.getColumnLabel(12)));
				temp.setO8(rs.getBoolean(meta.getColumnLabel(13)));
				temp.setO9(rs.getBoolean(meta.getColumnLabel(14)));
				temp.setO10(rs.getBoolean(meta.getColumnLabel(15)));
				temp.setO11(rs.getBoolean(meta.getColumnLabel(16)));
				temp.setI0(rs.getBoolean(meta.getColumnLabel(17)));
				temp.setI1(rs.getBoolean(meta.getColumnLabel(18)));
				temp.setI2(rs.getBoolean(meta.getColumnLabel(19)));
				temp.setI3(rs.getBoolean(meta.getColumnLabel(20)));
				temp.setI4(rs.getBoolean(meta.getColumnLabel(21)));
				temp.setI5(rs.getBoolean(meta.getColumnLabel(22)));
				temp.setI6(rs.getBoolean(meta.getColumnLabel(23)));
				temp.setI7(rs.getBoolean(meta.getColumnLabel(24)));
				temp.setI8(rs.getBoolean(meta.getColumnLabel(25)));
				temp.setI9(rs.getBoolean(meta.getColumnLabel(26)));
				temp.setAN1(rs.getInt(meta.getColumnLabel(27)));
				temp.setAN0(rs.getInt(meta.getColumnLabel(28)));

				resultados.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Retorna o número de colunas
	 * 
	 * @return columnCount - Inteiro com a contagem do número de colunas.
	 * */
	public int getColumnCount() {
		return columnCount;
	}

	/**
	 * Retorna o nome das colunas
	 * 
	 * @return nomeColunas - String contendo a lista de nome das colunas.
	 * */
	public String getNomeColunas() {
		return nomeColunas;
	}

	/** Monta o nome das colunas na string nomeColunas */
	public void leColunas() {
		try {
			if (rs == null) {
				conectar();
			}
			// Pegando o nome das colunas no database
			rs = comando.executeQuery("SELECT * FROM log WHERE idlog = '0'");
			meta = rs.getMetaData();
			int tamanho = meta.getColumnCount();
			nomeColunas = meta.getColumnLabel(2);
			for (int i = 3; i <= tamanho; i++) {
				nomeColunas = nomeColunas + ", " + meta.getColumnLabel(i);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}