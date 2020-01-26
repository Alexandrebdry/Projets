package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ApplicationClientRetour {
	
	private static final int portRetour = 2700;
	private final static String HOST = "localhost";
	
	public static void main(String[] args) throws Exception {
		Socket socket = null;		
		try {
			socket = new Socket(HOST, portRetour);
			
			// Cree les streams pour lire et ecrire du texte dans cette socket
			BufferedReader sin = new BufferedReader (new InputStreamReader(socket.getInputStream ( )));
			PrintWriter sout = new PrintWriter (socket.getOutputStream ( ), true);
			// Cree le stream pour lire du texte a partir du clavier 
			// (on pourrait aussi utiliser Scanner)
			BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));			
			// Informe l'utilisateur de la connection
			System.out.println("Connecté au serveur " + socket.getInetAddress() + ":"+ socket.getPort());
			
			int numeroDoc;
			String line;
			
			System.out.println("Tapez le numéro du livre à retourner");
			System.out.print("->");
			numeroDoc = clavier.read();
			// envoie au serveur
			sout.println(numeroDoc);
			// lit la réponse provenant du serveur
			line = sin.readLine();
			// Ecrit la ligne envoyee par le serveur
			System.out.println("Réponse du serveur : " + line);
			socket.close();
		}
		catch (IOException e) { System.err.println(e); }
		// Refermer dans tous les cas la socket
		try { if (socket != null) socket.close(); } 
		catch (IOException e2) { ; }	
	}
}
