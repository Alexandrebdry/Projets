package joueur;

import Règles.*;

public class Appli {
	public static void main(String[] args) {
	   
	    
		Jeu jeu = new Jeu();	
		Deck deck = new Deck();
		String s = jeu.debutPartie();
		
		
		jeu.jouerPremierTour(deck);
	
		
		
	}
}
