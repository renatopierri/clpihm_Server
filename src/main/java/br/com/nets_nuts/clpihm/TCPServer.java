package br.com.nets_nuts.clpihm;

import java.io.*;
import java.net.*;
import br.com.nets_nuts.clpihm.model.*;
import br.com.nets_nuts.clpihm.dao.*;
/**
 * Esta classe é o servidor HTTP.
 * Tem por função monitorar a porta 20001 e direcionar para gravação o que for escrito naquela porta.
 * A segurança é realizada no âmbito da rede empregando roteamento de pacotes e regras de firewall
 * @author Renato de Pierri - renato.pierri@gmail.com
 * */
public class TCPServer {
	
/**	Construtor da classe */	
	public TCPServer() {
		// TODO Auto-generated constructor stub
	}
	
	  public static void main(String argv[]) throws Exception
      {
		  Parser parse = new Parser();
	      String clientSentence;
		  Log log = new Log();
		  DaoCLP daoCLP = new DaoCLP();

		  
//       Criando a porta TCP 20001
         ServerSocket openTCPPort = new ServerSocket(20001);
         while(true)
         {
//			Escutando a porta TCP 20001
            Socket connectionSocket = openTCPPort.accept();
            
//          Criando a área de transferência (buffer de entrada)
            BufferedReader inFromClient =
               new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            
//          Lendo os dados recebidos na entrada
            clientSentence = inFromClient.readLine();
            
//			Imprimindo no console o dado recebido  		  	
            System.out.println("Received: " + clientSentence);            
            
//			Preparando os dados para inserir no banco de dados            
  		  	log = parse.parse(clientSentence);
  		  	
//			Inserindo os dados no banco de dados  		  	
  		  	daoCLP.insere(log);
  		  	
         }
      }

}
