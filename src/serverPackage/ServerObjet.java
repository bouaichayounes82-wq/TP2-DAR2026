
package serverPackage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import commonPackage.Operation;

public class ServerObjet {

    public static void main(String[] args) {

        try {
            ServerSocket serversocket = new ServerSocket(5001);

            System.out.println("Le serveur est en attente d'un client...");

            Socket socket = serversocket.accept();

            System.out.println("Client connecté !");

            ObjectInputStream entrer =
                    new ObjectInputStream(socket.getInputStream());

            Operation op = (Operation) entrer.readObject();

            System.out.println("Premier nombre : " + op.getNombre1());
            System.out.println("Opérateur : " + op.getOperateur());
            System.out.println("Deuxième nombre : " + op.getNombre2());

            double resultat = 0;

            switch (op.getOperateur()) {
                case "+":
                    resultat = op.getNombre1() + op.getNombre2();
                    break;

                case "-":
                    resultat = op.getNombre1() - op.getNombre2();
                    break;

                case "*":
                    resultat = op.getNombre1() * op.getNombre2();
                    break;

                case "/":
                    if (op.getNombre2() == 0) {
                        System.out.println("Division par zéro impossible");
                        resultat = Double.NaN;
                    } else {
                        resultat = op.getNombre1() / op.getNombre2();
                    }
                    break;

                default:
                    System.out.println("Opérateur invalide");
                    resultat = Double.NaN;
                    break;
            }

            System.out.println("Résultat : " + resultat);

            ObjectOutputStream sortie =
                    new ObjectOutputStream(socket.getOutputStream());

            sortie.writeObject(resultat);
            sortie.flush();
            sortie.close();
            entrer.close();
            socket.close();
            serversocket.close();

        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
