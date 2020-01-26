package serveur;

import java.io.IOException;
import java.net.ServerSocket;

import serveur.services.ServiceEmprunt;
import serveur.services.ServiceResa;
import serveur.services.ServiceRetour;

public class Serveur implements Runnable {
	
	private static final int portResa = 2500;
	private static final int portEmprunt = 2600;
	private static final int portRetour = 2700;
	
	private ServerSocket ServerSocketResa;
	private ServerSocket ServerSocketEmprunt;
	private ServerSocket ServerSocketRetour;

	// Cree trois serveurs TCP - objet de la classe ServerSocket
	private Serveur() throws IOException {
		ServerSocketResa = new ServerSocket(portResa);
		ServerSocketEmprunt = new ServerSocket(portEmprunt);
		ServerSocketRetour = new ServerSocket(portRetour);
	}

	@Override
	public void run() {
		try {
			while (true) {
				new Thread(new ServiceRetour(ServerSocketRetour.accept())).start();
				new Thread(new ServiceEmprunt(ServerSocketEmprunt.accept())).start();
				new Thread(new ServiceResa(ServerSocketResa.accept())).start();
			}
		} catch (IOException e) {
			System.err.println("Pb sur le port d'écoute :"+e);
			e.printStackTrace() ;
		}

	}

}
