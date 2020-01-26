package client;

import java.util.ArrayList;

import ressources.Document;


public class AbonneNormal implements Abonne {
	private static int cpt = 0 ;
	
	private int numeroAb;
	private ArrayList<Document> docEmprunter;
	private ArrayList<Document> docReserver;

	public AbonneNormal() {
		this.numeroAb = ++cpt;
		this.docEmprunter = new ArrayList<>();
		this.docReserver = new ArrayList<>();
	}
	
	public String toString() {
		return "Abonné numéro " + numeroAb;
	}
	
	public int getNum() {
		return numeroAb;
	}

	

	@Override
	public boolean docEmprunter(Document d) {
		synchronized(this) {
			return docEmprunter.contains(d);
		}
	}
	
	public boolean docReserver(Document d) {
		synchronized(this) {
			return docReserver.contains(d);
		}
	}

	@Override
	public void retour(Document d) {
		if(docEmprunter.contains(d)) 
			d.retour();
	}
}
