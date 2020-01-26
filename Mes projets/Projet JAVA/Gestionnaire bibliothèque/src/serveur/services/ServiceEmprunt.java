package serveur.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import ressources.Bibliotheque;

public class ServiceEmprunt implements Runnable {

	private static int cpt = 1;

	private final int numero;
	private final Socket client;

	public ServiceEmprunt(Socket socket) {
		this.numero = cpt++;
		this.client = socket;
	}

	@Override
	public void run() {
		System.out.println("*********Connexion "+this.numero+" démarrée");
		try {
			BufferedReader in = new BufferedReader (new InputStreamReader(client.getInputStream ( )));
			PrintWriter out = new PrintWriter (client.getOutputStream ( ), true);
			int numeroAbonne = in.read();
			int numeroDoc;
			System.out.println("Connexion "+this.numero+" <-- "+numeroAbonne);
			if(Bibliotheque.abonneExistant(numeroAbonne)) {
				//line = Bibliotheque.listeDocuments();
				out.println("Avez-vous réserver un document? 1. oui 2.non");
				int reponse = in.read();
				
				if(reponse == 1) {
					out.println("Le numéro du document réserver?");
					numeroDoc = in.read();
					if(Bibliotheque.docReserver(numeroDoc))
						Bibliotheque.emprunter(numeroAbonne,numeroDoc);
					out.println("OK");
				}
				
				else {
					out.println(Bibliotheque.listeDocuments());
					numeroDoc = in.read();
					Bibliotheque.emprunter(numeroAbonne, numeroDoc);
					out.println("OK");
				}
			}
			else {
				out.print("Abonne Inexistant");
			}
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
