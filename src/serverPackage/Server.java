package serverPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket=new ServerSocket(5001);
			System.out.println("le serveur est en attente d'un client...");
			Socket socket =serverSocket.accept();
			System.out.println(" le client est connectee ! ");
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String message=in.readLine();
			System.out.println(" message recu " + message);
			PrintWriter out =new PrintWriter(socket.getOutputStream(), true);
			String [] parties=message.split(" ");
			double nombre1;
			double nombre2;
			try{
				nombre1 = Double.parseDouble(parties[0]);
				nombre2 = Double.parseDouble(parties[2]);
			}catch(NumberFormatException e){
				out.println("le nombre invalide");
				return;
			}
			double resultats=0;
			if(parties[1].equals("+")) {
				resultats=nombre1+nombre2;
			}else if(parties[1].equals("-")) {
				resultats=nombre1-nombre2;
			}else if(parties[1].equals("*")) {
				resultats=nombre1*nombre2;
			}else if(parties[1].equals("/")) {
				if(nombre2==0) {
					out.println("imposible de diviser par 0");
					return;
				}
				resultats=nombre1/nombre2;
			}else {
				out.println("operateur invalide ");
				return;
			}
			out.println(resultats);
			
		} catch (IOException e) {
			System.out.println(" Erreur " + e.getMessage());
			
		}
	}

}
