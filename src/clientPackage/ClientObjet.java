
package clientPackage;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.net.Socket;

import commonPackage.Operation;

public class ClientObjet {

    public static void main(String[] args) {

        try {
      
            Socket socket = new Socket("localhost", 5001);

            System.out.println("Connecté au serveur !");

            Operation op = new Operation(55, "*", 25);

            ObjectOutputStream sortie =
                    new ObjectOutputStream(socket.getOutputStream());

            sortie.writeObject(op);
            sortie.flush();

            System.out.println("Opération envoyée au serveur.");

          
            ObjectInputStream entree =
                    new ObjectInputStream(socket.getInputStream());

            double resultat = (double) entree.readObject();

            System.out.println("Résultat reçu du serveur : " + resultat);

            entree.close();
            sortie.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
