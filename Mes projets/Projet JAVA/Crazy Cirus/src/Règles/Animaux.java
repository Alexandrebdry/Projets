package Règles;

public class Animaux {
	
	private String nomAnimal ;
	public static final int maxAnimaux = 3 ; 
	private static final int maxLION = 1 ;
	private static final int maxOURS = 1 ;
	private static final int maxELPH = 1 ;
	
	private static int compteurAnimaux = 0 ;
	private static int comptLION = 0 ;
	private static int comptOURS = 0 ;
	private static int comptELPH = 0 ;
	
	
	public Animaux(){
		assert ( compteurAnimaux < maxAnimaux ) ; 
		++compteurAnimaux ;
		nomAnimal = null ; 
	}
	
	public void setNomAnimal (String s) { 
		assert ( estConforme(s) ) ; 
		this.nomAnimal = s.toUpperCase();  	
	}
	
	public String getNomAnimal () {
		assert (this.nomAnimal != null ) ; 
		return nomAnimal ;  
	}
	public boolean elphIsGood ( String s){
		assert ( comptELPH < maxELPH ) ;
		if ( s == "ELEPHANT" )
			return true;
		return false;
	}
	public boolean lionIsGood ( String s){
		assert ( comptLION < maxLION ) ;
		if ( s == "LION" )
			return true;
		return false;
	}
	public boolean oursIsGood ( String s){
		assert ( comptOURS < maxOURS ) ;
		if ( s == "OURS" )
			return true;
		return false;
	}
	public boolean estConforme ( String s ) {
		if ( s == "ELEPHANT" ) 
			if ( elphIsGood(s) ) {
				++comptELPH; return true ; }
		if ( s == "LION" ) 
			if ( lionIsGood(s) ) {
				++comptLION; return true ; }
		if ( s == "OURS" ) 
			if ( oursIsGood(s) ) {
				++comptOURS; return true ; } 
		return false ; 
	}
	

	
}
