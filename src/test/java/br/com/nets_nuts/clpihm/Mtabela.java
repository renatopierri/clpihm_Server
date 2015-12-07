package br.com.nets_nuts.clpihm;

import java.util.Arrays;
import java.util.Vector;
import java.lang.RuntimeException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import br.com.nets_nuts.clpihm.model.Log;
import junit.framework.TestCase;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import net.miginfocom.swing.MigLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JButton;
import javax.swing.JTable;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;

public class Mtabela extends TestCase {
	private JTable tablenato;

	
	public Mtabela() {
		// TODO Auto-generated constructor stub
	}
/*
 * A função 'mTabela' serve para montar o resultado do SQL em forma de tabela e 
 * retornar um valor para ser utilizado na validação do testcase.
 * */
	/**
	 * @wbp.parser.entryPoint
	 */
	public boolean mTabela(Vector<Log> resultadosV,int tamanho){
		
		//Configurando o nome das colunas da tabela.
		//Podia usar os metadados do resultset, seria mais elegante.
		String[] nomeColunas = {"idlog","hr_clp","nome_clp","hr_sistema","o0",
						"o1","o2","o3","o4","o5","o6","o7","o8","o9",
						"o10","o11","i0","i1","i2","i3","i4","i5","i6",
						"i7","i8","i9","an0","an1"};
		Vector<String> nomeColunasV = new Vector<String> (Arrays.asList(nomeColunas));				
		//Fim da configuração dos nomes das colunas.			
		
		//Criando um vetor de strings para conter as linhas da tabela.
		Vector<Vector<String>> dadosLinhaV = new Vector<Vector<String>>();
		
		/*
		 * Montando as linhas da tabela:
		 * 
		 * O objeto 'resultadosV' é um vetor que contém objetos do tipo 'Log'.
		 * 
		 * A cada iteração no loop a seguir são acionados os  métodos  get  do
		 *  objeto 'log', fazendo a recuperação dos valores de cada campo.
		 *  
		 * Os  valores  dos  campos  são  concatenados e inseridos no vetor de 
		 * strings 'dadosCelulaV',fazendo a montagem de uma linha, item a item.
		 * 
		 * Ao chegar no fim de uma iteração, o vetor de strings  'dadosCelulaV'
		 * irá conter uma linha pronta.
		 * 
		 * Nesse momento o conteúdo de 'dadoCelulaV' é adicionado  ao vetor de 
		 * vetores de string 'dadosLinhaV', cuja função é armazenar as  linhas
		 * a serem apresentadas.
		 * 
		 * O loop se repete, até que 'i' seja igual à variável 'tamanho', ou seja,
		 * todas as linhas foram montadas e adicionadas à variável 'dadosLinhaV'.
		 * */
		
		// Instanciando um objeto 'Log' para extração dos dados das células.
		Log log = new Log();
		
		//Montando as linhas.
		for (int i = 0; i < tamanho; i++){
			
			//Carregando um objeto 'log'
			log = resultadosV.get(i);
		
			//Extraindo os dados de cada célula de 'log' e montando a linha.
			Vector<String> dadosCelulaV = new Vector<String> (Arrays.asList(
					String.valueOf(log.getIdlog()),
					log.getHr_clp(),
					log.getNome_CLP(),
					log.getHr_Sistema(),
					String.valueOf(log.getO0()),
					String.valueOf(log.getO1()),
					String.valueOf(log.getO2()),
					String.valueOf(log.getO3()),
					String.valueOf(log.getO4()),
					String.valueOf(log.getO5()),
					String.valueOf(log.getO6()),
					String.valueOf(log.getO7()),
					String.valueOf(log.getO8()),
					String.valueOf(log.getO9()),
					String.valueOf(log.getO10()),
					String.valueOf(log.getO11()),
					String.valueOf(log.getI0()),
					String.valueOf(log.getI1()),
					String.valueOf(log.getI2()),
					String.valueOf(log.getI3()),
					String.valueOf(log.getI4()),
					String.valueOf(log.getI5()),
					String.valueOf(log.getI6()),
					String.valueOf(log.getI7()),
					String.valueOf(log.getI8()),
					String.valueOf(log.getI9()),
					String.valueOf(log.getAN1()),
					String.valueOf(log.getAN0())));
			//Armazenando a linha completa.
			dadosLinhaV.add(dadosCelulaV);
		}
//=====================
		
		tablenato = new JTable(dadosLinhaV,nomeColunasV);
		tablenato.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablenato.setFont(new Font("Arial", Font.PLAIN, 10));
		tablenato.setAutoCreateRowSorter(true);
		tablenato.setBackground(new Color(245, 255, 250));
		JScrollPane panel = new JScrollPane(tablenato);
		panel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		panel.setSize(new Dimension(1024, 768));
		panel.setPreferredSize(new Dimension(1024, 768));

		Object[] options ={"Passou no teste.","Não passou no teste."};
		int res = JOptionPane.showOptionDialog(null,panel,"Teste do SQL - Passou no teste?",
				JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options,options[1]);
	
		if (res == JOptionPane.OK_OPTION){
			assertTrue(true);
		}
		else{
			assertTrue(false);
		}
		
		
		
	return true;	
	}
}
