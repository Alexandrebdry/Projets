package Règles;

public class CarteAJouer {
	
	public static void KI (Podium bleu, Podium rouge) {
		assert ( !bleu.estVide() ) ; 
		rouge.setAnimal(bleu.hautPodium());
		bleu.removeHaut(); 
	}
	public String toStringKI() {
		String s = "KI : BLEU --> ROUGE";
		return s;
	}
	
	public static void LO (Podium bleu, Podium rouge) {
		assert ( !rouge.estVide() ) ; 
		bleu.setAnimal(rouge.hautPodium());
		rouge.removeHaut();
	}
	public String toStringLO(){
		String s = "LO : ROUGE --> BLEU";
		return s ; 
	}
	
	public static void SO (Podium bleu, Podium rouge) {
		assert ( !bleu.estVide() && !rouge.estVide() ) ;
		Animaux a = new Animaux() ;
		a = bleu.hautPodium() ;
		bleu.removeHaut() ;
		bleu.setAnimal(rouge.hautPodium()) ;
		rouge.removeHaut() ;
		rouge.setAnimal(a) ;
	}
	public String toStringSO() {
		String s = "SO : BLEU <-> ROUGE"; 
		return s ; 
	}
	
	public static void NI (Podium bleu) {
		assert ( !bleu.estVide() ) ;
		bleu.setAnimal( bleu.basPodium() );
		bleu.removeBas();
	}
	public String toStringNI(){
		String s = "NI : Bleu  ^";
		return s ;
	}
	
	public static void MA (Podium rouge) {
		assert ( !rouge.estVide() ) ;
		rouge.setAnimal( rouge.basPodium() );
		rouge.removeBas();
	}
	public String toStringMA(){
		String s = "MA : Rouge  ^";
		return s ;
	}
	public String toString () {
		String newligne = System.getProperty( "line.separator" ) ;
		String s = "-------------------------" + newligne ; 
		s += toStringKI() + "         " + toStringNI() + newligne ; 
		s += toStringLO() + "         " + toStringMA() + newligne ; 
		s += toStringSO() ;
		return s ; 
	}
}
