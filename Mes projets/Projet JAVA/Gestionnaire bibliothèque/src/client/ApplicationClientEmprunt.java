package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ApplicationClientEmprunt {

	private static final int portEmprunt = 2600;
	private final static String HOST = "localhost";
	
	public static void main(String[] args) throws Exception {
		Socket socket = null;		
		try {
			socket = new Socket(HOST, portEmprunt);
			
			// Cree les streams pour lire et ecrire du texte dans cette socket
			BufferedReader sin = new BufferedReader (new InputStreamReader(socket.getInputStream ( )));
			PrintWriter sout = new PrintWriter (socket.getOutputStream ( ), true);
			// Cree le stream pour lire du texte a partir du clavier 
			// (on pourrait aussi utiliser Scanner)
			BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));			
			// Informe l'utilisateur de la connection
			System.out.println("Connecté au serveur " + socket.getInetAddress() + ":"+ socket.getPort());
			
			int numeroDoc;
			int numeroAbonne;
			int reponse;
			String line;
			
			System.out.println("Tapez votre numéro abonné");
			System.out.print("->");
			numeroAbonne = clavier.read();
			// envoie au serveur
			sout.println(numeroAbonne);
			// lit la réponse provenant du serveur
			line = sin.readLine();
			if(line.equals("Abonne Inexistant")) {
				System.out.println(line);
				socket.close();
			}
			
			System.out.println(line);
			System.out.print("->");
			reponse = clavier.read();
			sout.println(reponse);
			
			System.out.println("Tapez le numéro du document");
			System.out.print("->");
			numeroDoc = clavier.read();
			sout.println(numeroDoc);
			
			System.out.println(sin.readLine());
			socket.close();
		}
		catch (IOException e) { System.err.println(e); }
		// Refermer dans tous les cas la socket
		try { if (socket != null) socket.close(); } 
		catch (IOException e2) { ; }	
	}
}
