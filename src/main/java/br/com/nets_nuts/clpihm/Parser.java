package br.com.nets_nuts.clpihm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.nets_nuts.clpihm.model.Log;
/**
 * A classe Parser faz a adequação dos dados recebidos do CLP aos requisitos do banco de dados.
 * A string 'clientSentence' contém os dados recebidos do CLP.
 * Em seguida é tratada a data e hora recebida
 * E por último o objeto log é populado de acordo com os valores descritos na string 'clientSentence'.
 * A classe retorna o objeto 'Log'. 
 * Author Renato de Pierri - renato.pierri@gmail.com
 * */
public class Parser {

//	Contrutor da classe.
	public Parser() {
		// TODO Auto-generated constructor stub.
	}

/**	
 * Método parse recebe String e retorna objeto Log.
 * @param clientSentence - String com os dados recebidos do CLP
 * @return Log - Objeto log com a informação formatada para ser inserida no banco de dados
 * */
	public Log parse(String clientSentence) {
		
//		Inicializando variáveis.		
		String[] dados;
		String hora;
		StringBuffer stbr;
		Log log = new Log();
		
//		'horaDoCLP' é o formato da hora recebida pelo CLP		
		SimpleDateFormat horaDoCLP = new  SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
//		'horaMySQL' é o formato da hora requerido para gravar dados no MySQL.		
		SimpleDateFormat horaMySQL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
//		Aqui eu converto a string em stringBuffer para fazer a formatação.
		stbr = new StringBuffer(clientSentence);
		
//		Formatando e corrigindo o ano de '00XX' para '20XX' e unindo a hora do sistema com a data.		
		stbr.insert(8, " ");
		stbr.insert(6, "20");
		stbr.deleteCharAt(11);
		
//		Convertendo de stringBuffer para array de string dados.	
		dados = stbr.toString().split("\\|");

//		Formatando a hora		
		try {
//			Convertendo a data e hora de string para o formato de data do Java.		
			Date date = horaDoCLP.parse(dados[0]);

//			Convertendo o formato de data do Java para o formato do MySQL.			
			hora = horaMySQL.format(date);
			
//			Gerando uma entrada na saída padrão para fins de controle e debug.
			System.out.println(hora + " :nova entrada no log");
			
		} catch (ParseException e) {
//			Em caso de erro, o objeto log é retornado vazio.
			e.printStackTrace();
			return log;
		}
		
//		Populando os registros a serem persistidos.
		log.setHr_CLP(hora);
		//log.setNome_CLP(dados[1]);
		log.setNome_CLP("clp_nato");
		log.setO0(dados[1].equals("1"));
		log.setO1(dados[2].equals("1"));
		log.setO2(dados[3].equals("1"));
		log.setO3(dados[4].equals("1"));
		log.setO4(dados[5].equals("1"));
		log.setO5(dados[6].equals("1"));
		log.setO6(dados[7].equals("1"));
		log.setO7(dados[8].equals("1"));
		log.setO8(dados[9].equals("1"));
		log.setO9(dados[10].equals("1"));
		log.setO10(dados[11].equals("1"));
		log.setO11(dados[12].equals("1"));
		log.setI0(dados[13].equals("1"));
		log.setI1(dados[14].equals("1"));
		log.setI2(dados[15].equals("1"));
		log.setI3(dados[16].equals("1"));
		log.setI4(dados[17].equals("1"));
		log.setI5(dados[18].equals("1"));
		log.setI6(dados[19].equals("1"));
		log.setI7(dados[20].equals("1"));
		log.setI8(dados[21].equals("1"));
		log.setI9(dados[22].equals("1"));
		log.setAN1(Integer.parseInt(dados[23]));
		log.setAN0(Integer.parseInt (dados[24]));
		return log;
	}

}
