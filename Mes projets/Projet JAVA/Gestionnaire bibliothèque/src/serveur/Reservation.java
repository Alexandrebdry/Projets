package serveur;

import java.util.TimerTask;

import ressources.Bibliotheque;
import ressources.Document;

public class Reservation extends TimerTask {
	private Document d ; 
	
	public Reservation(Document d) {
		this.d = d;
	}
	@Override
	public void run() {
		Bibliotheque.finReservation(d);
		this.d.retour();
	}

}
