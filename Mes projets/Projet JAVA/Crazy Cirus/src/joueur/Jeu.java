package joueur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Règles.CarteAJouer;
import Règles.CartePosition;
import Règles.Deck;

public class Jeu {
	public static final int MAX_TOURS = 24 ;
	private int tourActuel = 0 ;
	private CartePosition situationActu ; 
	private CartePosition situationAAtteindre ; 
	private int nombreJoueur = 0 ; 
	private ArrayList<Joueur>joueurs = new ArrayList<>(); 
	private int indice_01 = 5 ; 
	private int indice_02 = 0 ;
	
	public Jeu(){
		
	}
	public String definirNombreJoueur (){
		String s = "Combien voulez vous de joueurs ?" ;
		System.out.println(s);
		String newligne = System.getProperty( "line.separator" ) ;
		Scanner sc = new Scanner(System.in) ; 
		nombreJoueur = sc.nextInt() ;
		while(nombreJoueur > 4 || nombreJoueur < 2){
			s =  newligne + "Vous ne pouvez pas avoir moins de deux joueurs et plus de quatre joueurs. Veuillez saisir un nombre valide" ;
			System.out.println(s); nombreJoueur = sc.nextInt() ;
		}	
		s = newligne + "Il y a donc " + nombreJoueur + " joueurs dans la partie" ;
		System.out.println(s);
		return "" ;
	}
	public int getNombreJoueur(){
		return nombreJoueur ; 
	}
	public void jouerPremierTour(Deck d){
		assert(!joueurs.isEmpty()) ;
		this.situationActu = d.piocherCarte();
		indice_01 = d.getIndicdePioche();
		this.situationAAtteindre = d.piocherCarte();
		indice_02 = d.getIndicdePioche();
		CartePosition tentativeJoueur = new CartePosition();
		String z = toString() ;
		System.out.println(z);
		Scanner sc = new Scanner(System.in); 
		while(true){
			for(int i = 0 ; i <= joueurs.size() ; ++i) {
				tentativeJoueur = this.situationActu ;
				Joueur.demanderNom(); String s = sc.next();
				for (int j = 0 ; j <= joueurs.size(); ++j ) {
						if (joueurs.get(i).peutJoueur() && !joueurs.get(j).peutJoueur())
							joueurs.get(i).aGagné() ; 
							if (joueurs.get(i).getNomJoueur(i) == s && joueurs.get(i).peutJoueur()) {
									do {
											String joue = sc.next() ;
											if (joue == "SO" )
												CarteAJouer.SO(tentativeJoueur.getPodBleu(indice_01),tentativeJoueur.getPodRouge(indice_01) ) ;
											if (joue == "KI" )
												CarteAJouer.KI(tentativeJoueur.getPodBleu(indice_01),tentativeJoueur.getPodRouge(indice_01) ) ;
											if (joue == "LO" )
												CarteAJouer.LO(tentativeJoueur.getPodBleu(indice_01),tentativeJoueur.getPodRouge(indice_01) ) ;
											if (joue == "NI" )
												CarteAJouer.NI(tentativeJoueur.getPodBleu(indice_01) ) ;
											if (joue == "MA" )
												CarteAJouer.MA(tentativeJoueur.getPodRouge(indice_01) ) ;
									} while (sc.next() != "  " ) ;	
							}
				} if (tentativeJoueur != situationAAtteindre ) {
					String a = "Vous n'avez pas trouvez.. La solution est : Quoi !? Il y a d'autres joueurs tu as vraiment cru que j'allais te donner la réponse ?" ;
					System.out.println(a); joueurs.get(i).setErreur(true);
				}
				else 
					joueurs.get(i).aGagnéUnTour() ;
			} 
		break; 
		}
		for ( int k = 0 ; k <= joueurs.size(); ++k ) {
			joueurs.get(k).setErreur(false);
		}
		tourActuel += 1 ;
		situationActu = situationAAtteindre ; 
	}
	public void jouerUnTour(Deck d){
		assert(!joueurs.isEmpty()) ;
		assert(!d.estVide()) ;
		this.situationAAtteindre = d.piocherCarte();
		indice_01 = d.getIndicdePioche();
		CartePosition tentativeJoueur = new CartePosition();
		Scanner sc = new Scanner(System.in); 
		while(true){
			for(int i = 0 ; i <= joueurs.size() ; ++i) {
				tentativeJoueur = this.situationActu ;
				Joueur.demanderNom(); String s = sc.next();
				for (int j = 0 ; j <= joueurs.size(); ++j ) {

						if (joueurs.get(i).peutJoueur() && !joueurs.get(j).peutJoueur())
							joueurs.get(i).aGagné() ; 
							if (joueurs.get(i).getNomJoueur(i) == s && joueurs.get(i).peutJoueur()) {
									do {
											String joue = sc.next() ;
											if (joue == "SO" )
												CarteAJouer.SO(tentativeJoueur.getPodBleu(indice_01),tentativeJoueur.getPodRouge(indice_01) ) ;
											if (joue == "KI" )
												CarteAJouer.KI(tentativeJoueur.getPodBleu(indice_01),tentativeJoueur.getPodRouge(indice_01) ) ;
											if (joue == "LO" )
												CarteAJouer.LO(tentativeJoueur.getPodBleu(indice_01),tentativeJoueur.getPodRouge(indice_01) ) ;
											if (joue == "NI" )
												CarteAJouer.NI(tentativeJoueur.getPodBleu(indice_01) ) ;
											if (joue == "MA" )
												CarteAJouer.MA(tentativeJoueur.getPodRouge(indice_01) ) ;
									} while (sc.next() != "  " ) ;	
							}
				} if (tentativeJoueur != situationAAtteindre ) {
					String a = "Vous n'avez pas trouvez.. La solution est : Quoi !? Il y a d'autres joueurs tu as vraiment cru que j'allais te donner la réponse ?" ;
					System.out.println(a); joueurs.get(i).setErreur(true);
				}
				else 
					joueurs.get(i).aGagnéUnTour() ;
			} 
		break; 
		}
		for ( int k = 0 ; k <= joueurs.size(); ++k ) {
			joueurs.get(k).setErreur(false);
		}
		tourActuel += 1 ;
		situationActu = situationAAtteindre ; 
	}
	public String toString () {
		CarteAJouer c = new CarteAJouer();
		String newligne = System.getProperty( "line.separator" ) ;
		String s = "Voici la carte initiale et à atteindre :  " + newligne ;
		s += situationActu.toString(indice_01) + "          " + situationAAtteindre.toString(indice_02);
		s += newligne + c.toString() + newligne ;
		return s ;
	}
	
	public String debutPartie () {
		String s = definirNombreJoueur() ; 
		String sa = "";
		Scanner sc = new Scanner(System.in); 
		nombreJoueur = getNombreJoueur();
		if ( nombreJoueur == 2 ) {
			Joueur joueur1 = new Joueur();
			Joueur joueur2 = new Joueur();
			joueurs.add(joueur1); 
			joueurs.add(joueur2); 
		}
		if ( nombreJoueur == 3 ) {
			Joueur joueur1 = new Joueur();
			Joueur joueur2 = new Joueur();
			Joueur joueur3 = new Joueur();
			joueurs.add(joueur1); 
			joueurs.add(joueur2); 
			joueurs.add(joueur3); 
			
		}
		if ( nombreJoueur == 4 ) {
			Joueur joueur1 = new Joueur();
			Joueur joueur2 = new Joueur();
			Joueur joueur3 = new Joueur();
			Joueur joueur4 = new Joueur();
			joueurs.add(joueur1); 
			joueurs.add(joueur2); 
			joueurs.add(joueur3); 
			joueurs.add(joueur4); 
		}
		
		for (int i = 0 ; i < joueurs.size() ; ++i ) {
			s = "nom du joueur : " ; 
			System.out.println(s);
			s = sc.next() ; sa = s ; 
			joueurs.get(i).setNomJoueur(sa);			
		}
		return s ;
	}
}
