package br.com.nets_nuts.clpihm;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.util.Vector;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import br.com.nets_nuts.clpihm.dao.DaoCLP;
import br.com.nets_nuts.clpihm.model.Log;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DaoTest extends TestCase {
	private JTextField cP; 
	private JComboBox<String> nomeCampo;
	private Object[] options ={"Ok","Cancelar"};
	
	/**
	 * Create the test case
	 *
	 * @param acessoBanco
	 *            Acesso ao banco de dados
	 */
	public DaoTest(String acessoBanco) {
		super(acessoBanco);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(DaoTest.class);
	}

/*	
 * Início do testeInsere().
 * 
 * Testando a inserção de dados no banco de dados.
 * 	
 * É criada a instância de um objeto 'dc' tipo 'DaoCLP e um objeto 'log'  tipo 'Log'
 * O objeto log (Log) é populado com uma série de valores teste.
 * Em seguida é feita a asserção positiva do objeto 'dc' chamando o método insere(log).
 * Caso o objeto 'dc' retorne valor 'FALSO', o teste será falho, caso contrário, 
 * o teste foi bem sucedido. 
 * 	
 */
	public void testeInsere() {
		System.out.println("Iniciando o teste para inserir dados no database");
		Log log = new Log();
		DaoCLP dc = new DaoCLP();
		
		log.setHr_CLP();
		log.setNome_CLP();
		log.setHr_Sistema();
		log.setO0(true);
		log.setO1(false);
		log.setO2(false);
		log.setO3(false);
		log.setO4(false);
		log.setO5(false);
		log.setO6(true);
		log.setO7(false);
		log.setO8(true);
		log.setO9(false);
		log.setO10(true);
		log.setO11(false);		
		log.setI0(true);
		log.setI1(true);
		log.setI2(true);
		log.setI3(false);
		log.setI4(true);
		log.setI5(true);
		log.setI6(true);
		log.setI7(true);
		log.setI8(true);
		log.setI9(true);
		log.setAN0(153);
		log.setAN1(1023);
		
		System.out.println("Dados preparados. Inserindo os dados no database");
		System.out.println("Avaliando se a inserção está correta");
		assertTrue(dc.insere(log));
		System.out.println("Fim do teste para inserir dados no database");
	}
//	Fim do testeInsere().
	
/*
 * Início do testeApagar().
 * 
 * Testando a exclusão de dados.
 * 
 * Inserir o nr da linha a ser excluída e a mesma deve ser excluída no banco de dados.
 * Se 'resultado' for igual a ' 0', não foi encontrada a linha.
 * Se 'resultado' for igual a ' 1', a exclusão ocorreu com sucesso.
 * Se 'resultado' for igual a '-1', deu falha na execução do comando.
 * */	
	public void testeApagar(){
		System.out.println("Início do teste para apagar uma linha do database");
		
		Integer row, resultado;
		DaoCLP dc = new DaoCLP();
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");
		row = Integer.parseInt(JOptionPane.showInputDialog("Digitar o nr da linha a ser excluída"));
		resultado = dc.apagar(row);		
		if (resultado == 0){
			System.out.println("Conferir o banco de dados. Se existir a linha '" + row + "', é erro.");
		}

		System.out.println("Avaliando se a linha foi excluída do database");
		assertTrue(resultado == 1);
		System.out.println("Fim do teste para apagar uma linha do database");
	}
		
	
/*
 * Início do testeBuscarTodos().
 * 
 * Testando a apresentação dos dados
 * 
 * Nesse teste é feito um 'SELECT * FROM monografia.log order by idlog desc;' 
 * e o resultado é apresentado  na tela, junto com um diálogo questionando se
 * os itens da  tupla  foram  corretamente  apresentados  e  posicionados nas 
 * colunas corretas.
 * 
 * Caso este teste tenha sido executado após uma exclusão de linha, assegurar
 * que a linha excluída não apareça na query.
 * */
	
	public void testeBuscarTodos(){
		System.out.println("Início do teste para buscar todos os registros do database");
		//Criando variáveis.
		DaoCLP dc = new DaoCLP();
		Vector<Log> resultadosV = new Vector<Log>();
		
		System.out.println("Acessando o banco de dados");
		resultadosV = dc.buscarTodos();
		int tamanho = resultadosV.size();

		System.out.println("Apresentando os dados obtidos");
		Mtabela mtb = new Mtabela();
		boolean n = mtb.mTabela(resultadosV, tamanho);
		System.out.println("Fim da chamada para apresentar o resultado da pesquisa na GUI.");
		
		System.out.println("Validando o testcase.");
		assertTrue (n);
		System.out.println("Fim do teste para buscar todos os registros do database");
	}
//Fim do testeBuscarTodos()	
	
/*
 * Início do testeBuscar().
 * 
 * Esse teste apresenta uma caixa de diálogo que permite escrever o nome de uma coluna e 
 * personalizar o critério de seleção de dados naquela coluna.
 * */	
		/**
		 * @wbp.parser.entryPoint
		 */
		public void testeBuscar(){
			System.out.println("Início do teste para buscar uma coleção específica de registros no database");
			System.out.println("Inicializando as variáveis");
			DaoCLP dc = new DaoCLP();
			Vector <Log> resultadosV =  new Vector<Log>();
			int tamanho;
			String nCampo,cPesquisa;
			nCampo = "";
			cPesquisa ="";
			dc.leColunas();
			
			System.out.println("Criando um painel para conter os campos de query");
			JPanel panel = new JPanel();
			panel.setPreferredSize(new Dimension(358, 33));
			panel.setLayout(null);
			
			System.out.println("Criando o combo box e adicionando no painel");
			String temp = "Escolha um campo, idlog, "+dc.getNomeColunas();
			StringBuffer stbr = new StringBuffer(temp);
			String lista[]=stbr.toString().split(", ");
			nomeCampo = new JComboBox<String> (lista);
			nomeCampo.setBounds(12, 4, 157, 24);			
			panel.add(nomeCampo);

			System.out.println("Criando o campo para escrever o critério de pesquisa");
			cP = new JTextField();
			cP.setPreferredSize(new Dimension(157, 24));
			cP.setBounds(194, 4, 154, 24);
			//Valor default é qualquer coisa que comece com '5'.
			cP.setText("5%");
			panel.add(cP);	
			cP.setEditable(false);
			
			//Adicionando um listener para garantir que seja selecionado
			//um valor válido para o campo 'nomeCampo'
			nomeCampo.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent ie){
					String x = (String) nomeCampo.getSelectedItem();
					if(! x.equals("Escolha um campo")){
						cP.setEditable (true);
					}
					else{cP.setEditable(false);
					}
				};
			});
			
			
			System.out.println("Lendo a seleção e populando as variáveis nCampo e cPesquisa.");
			int res = JOptionPane.showOptionDialog(null, panel,"Teste Buscar todos os dados.",
					JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, 
					null, options,options[1]);
			
			if (res == JOptionPane.OK_OPTION && cP.isEditable()){
				//nCampo é o nome do campo a ser pesquisado no select
				nCampo = (String) nomeCampo.getSelectedItem();
				//cPesquisa é a chave de pesquisa. O que eu vou procurar no campo.
				cPesquisa = cP.getText();
			}
			else{
				System.out.println("Clicou em 'Cancelar' ou não selecionou nada");
				assertTrue(false);
			}
			
			System.out.println("Fazendo a query no banco");
			resultadosV = dc.buscar(nCampo, cPesquisa);
			tamanho = resultadosV.size();
			
			System.out.println("Apresentando o resultado da Query.");		
			Mtabela mtb = new Mtabela();

			boolean n = mtb.mTabela(resultadosV, tamanho);
			//Fim da chamada para apresentar o resultado da pesquisa na GUI.
			
			System.out.println("Validando o testcase.");
			assertTrue (n);
			System.out.println("Fim do teste para buscar uma coleção específica de registros no database");
		}
//Fim do testeBuscar().		
}



