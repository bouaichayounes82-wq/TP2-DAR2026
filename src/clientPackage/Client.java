package clientPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		try (Socket socket = new Socket("localhost",5001)) {
			System.out.println("Connecté au serveur !");
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			out.println("abc / 0");
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String resultat=in.readLine();
			System.out.println("resultat recu : " + resultat);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
