package ressources;

import java.util.Timer;

import client.Abonne;
import serveur.Reservation;
import serveur.exceptions.EmpruntException;
import serveur.exceptions.ResaException;
import serveur.exceptions.RetourException;



public class Livre implements Document {
	private final static int attenteResa = 60; // 60 mili secondes
	private static int cpt = 0;

	private int numero;
	private boolean reserv;
	private boolean emprunt;
	private Abonne a;
	private Timer t;

	public Livre() {
		synchronized(this) {
			this.numero = ++cpt;
			this.reserv = false;
			this.emprunt = false;
		}
	}

	@Override
	public void reserver(Abonne ab) throws ResaException {
		synchronized (this) {
			if (this.emprunt == false) {
				if (this.reserv == false) {
					this.reserv = true;
					this.t = new Timer();
					a = ab;
					
					t.schedule(new Reservation(this), attenteResa);

				} else
					throw new ResaException();
			} else
				throw new ResaException();

		}
	}

	@Override
	public void emprunter(Abonne ab) throws EmpruntException {
		synchronized (this) {

			if (!isEmprunt()) 
			{
				if (isReserv()) 
				{
					if (a == ab) {
						this.emprunt = true;
						this.reserv = false;
						t.cancel();
						a = ab;
						
					} 
					else if (a != ab) throw new EmpruntException();
				} 
				else if(!isReserv())
				{
					this.emprunt = true;
					this.reserv = false;
					t.cancel();
					a = ab;
					
				}

			} else
				throw new EmpruntException();
		}
	}

	@Override
	public void retour() throws RetourException {
		synchronized (this) {
			if (isReserv() && !isEmprunt()) {
				this.t.cancel();
				this.a = null;
				this.reserv = false;
			
			} else {
				if (isEmprunt()) {
					this.t.cancel();
					this.a = null;
					this.reserv = false;
					this.emprunt = false;
					
				} else
					throw new RetourException();
			}
		}
	}

	@Override
	public int numero() {
		return this.numero;
	}

	public boolean isReserv() {
		return reserv;
	}

	public boolean isEmprunt() {
		return emprunt;
	}

}
