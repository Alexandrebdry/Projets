package joueur;

public class Joueur {
	
	public static final int NOMBREJOUEURMAX = 4 ; 
	private static String nomDuJoueur ;
	private static int compteurJoueur = 0 ;
	private int numJoueur ; 
	private boolean erreur ;
	private int nbTourGagnés ;
	
	
	public Joueur() {
		assert(numJoueur <= NOMBREJOUEURMAX) ;
		numJoueur = Joueur.compteurJoueur ;
		++numJoueur ;
		erreur=false;
		nbTourGagnés=0;
		nomDuJoueur="Nom à saisir";
	}
	public static String demanderNom(){
		String s = "Veuillez rentrez le nom du joueur" ;
		System.out.println(s);
		return s ; 
	}
	public void setNomJoueur (String s ) { 
		nomDuJoueur = s ; 
	}
	public boolean getErreur (){
		return erreur ; 
	}
	public String getNomJoueur (int i) {
		assert ( !nomJoueurDef() ) ; 
		return nomDuJoueur; 
	}
	public boolean nomJoueurDef () {
		if (nomDuJoueur == null)
			return true ; 
		return false ; 
	}
	public void aGagnéUnTour(){
		this.nbTourGagnés = this.nbTourGagnés + 1 ; 
	}
	public boolean aGagné () {
		if ( nbTourGagnés > Jeu.MAX_TOURS/2 )
			return true ;
		return false ; 
	}
	public boolean peutJoueur() {
		return erreur ; 
	} 
	public void setErreur (boolean etat) {
		 erreur = etat ; 
	}
}
