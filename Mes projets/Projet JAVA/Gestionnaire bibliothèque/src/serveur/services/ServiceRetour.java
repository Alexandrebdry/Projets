package serveur.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import ressources.Bibliotheque;


public class ServiceRetour implements Runnable {

	private static int cpt = 1;

	private final int numero;
	private final Socket client;

	public ServiceRetour(Socket socket) {
		this.numero = cpt++;
		this.client = socket;
	}

	@Override
	public void run() {
		System.out.println("*********Connexion "+this.numero+" démarrée");
		try {
			BufferedReader in = new BufferedReader (new InputStreamReader(client.getInputStream ( )));
			PrintWriter out = new PrintWriter (client.getOutputStream ( ), true);
			String line;
			int numeroDoc = in.read();
			System.out.println("Connexion "+this.numero+" <-- "+numeroDoc);
			Bibliotheque.retour(numeroDoc);
			line = "OK";
			out.println(line);
		}
		catch (IOException e) {
		}
		//Fin du service d'inversion
		System.out.println("*********Connexion "+this.numero+" terminée");
		try {client.close();} catch (IOException e2) {}
	}
	
	protected void finalize() throws Throwable {
		 client.close(); 
	}

}
