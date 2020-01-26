package Règles;

import java.util.LinkedList;


public class Podium {
	
	private LinkedList <Animaux> podiumAnimaux = new LinkedList <Animaux> () ;
	private String coul ; 
	private int index = 1 ;
	private int maxPodium = 2 ; 
	
	public Podium(String s) {
		
		assert ( s == "BLEU" || s == "ROUGE" ) ;
		coul = s ; 
				
	}
	
	public Podium() {
		this("BLEU");
	}
	
	public boolean estVide () {
		return podiumAnimaux.isEmpty() ;
	}
	public Animaux hautPodium() {
		assert( !this.estVide() );
		return this.podiumAnimaux.getLast();
	}
	public Animaux basPodium () {
		assert( !this.estVide() );
		return this.podiumAnimaux.getFirst();
	}
	
	public void setAnimal (Animaux element ) {
		assert( index <= Animaux.maxAnimaux );
		podiumAnimaux.add(element) ;
		++index ; 
	}
	public String getAnimal() {
		String newligne = System.getProperty( "line.separator" ) ;
		String s = "" ;
		for (int i = podiumAnimaux.size() ; i > 0 ; --i)
			s += podiumAnimaux.get(i).getNomAnimal() + newligne  ;
		return s ;
	}
	public void removeBas () {
		assert( !estVide() );
		podiumAnimaux.removeFirst() ;
		--index;
	}
	public void removeHaut () {
		assert( ! estVide() ) ;
		podiumAnimaux.removeLast() ;
		--index;
	}
	
	private String affichePodSeul () {
		String s="" ;
		String newligne = System.getProperty( "line.separator" ) ;
		for ( int i = 0 ; i < podiumAnimaux.size() ; ++i ) {
			if ( podiumAnimaux.get(i).getNomAnimal() == "OURS" || podiumAnimaux.get(i).getNomAnimal() == "LION" )
				s+= " " ;
			s += podiumAnimaux.get(i).getNomAnimal() + newligne ; 
		}
		return s ; 
	}
	
	public String toString (Podium deux ) {
		String s= "" ;
		String newligne = System.getProperty( "line.separator" ) ; 
		
		if ( deux.estVide() ) 
			affichePodSeul(); 
			
		if ( this.podiumAnimaux.size() == maxPodium ) {
			 if ( this.podiumAnimaux.get(1).getNomAnimal() == "OURS" || this.podiumAnimaux.get(1).getNomAnimal() == "LION" ) 
					s+= " " ; 
			s+= this.podiumAnimaux.get(1).getNomAnimal() + newligne ; 
			}
		if ( podiumAnimaux.get(0).getNomAnimal() == "OURS" || podiumAnimaux.get(0).getNomAnimal() == "LION" ) {
					s+= " " ; 
					s += podiumAnimaux.get(0).getNomAnimal() +  "             " + deux.podiumAnimaux.get(0).getNomAnimal() + newligne ; 
		}
		if ( podiumAnimaux.get(0).getNomAnimal() == "ELEPHANT" ) 
					s += podiumAnimaux.get(0).getNomAnimal() +"          " + deux.podiumAnimaux.get(0).getNomAnimal() + newligne ;
		 		
		s += " ---- " + "           " + " ---- " + newligne; 
		s+= " " +  this.coul + "            " + deux.coul ; 
		
		return s ; 
	}
	

}
