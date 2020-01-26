package Règles;

import java.util.ArrayList ;
import java.util.Arrays;
import java.util.Random;

public class Deck {

		private ArrayList<CartePosition> deck = new ArrayList<>();
		private int indiceDePioche;
		private int nombreDeCarte = 24 ; 

		public Deck() {
			Animaux ours = new Animaux();
			Animaux lion = new Animaux();
			Animaux eleph = new Animaux();

			deck.add(CartePosition.initCarte00(ours,lion,eleph));
			deck.add(CartePosition.initCarte01(ours,lion,eleph));
			deck.add(CartePosition.initCarte02(ours,lion,eleph));
			deck.add(CartePosition.initCarte03(ours,lion,eleph));
			deck.add(CartePosition.initCarte04(ours,lion,eleph));
			deck.add(CartePosition.initCarte05(ours,lion,eleph));
			deck.add(CartePosition.initCarte06(ours,lion,eleph));
			deck.add(CartePosition.initCarte07(ours,lion,eleph));
			deck.add(CartePosition.initCarte08(ours,lion,eleph));
			deck.add(CartePosition.initCarte09(ours,lion,eleph));
			deck.add(CartePosition.initCarte10(ours,lion,eleph));
			deck.add(CartePosition.initCarte11(ours,lion,eleph));
			deck.add(CartePosition.initCarte12(ours,lion,eleph));
			deck.add(CartePosition.initCarte13(ours,lion,eleph));
			deck.add(CartePosition.initCarte14(ours,lion,eleph));
			deck.add(CartePosition.initCarte15(ours,lion,eleph));
			deck.add(CartePosition.initCarte16(ours,lion,eleph));
			deck.add(CartePosition.initCarte17(ours,lion,eleph));
			deck.add(CartePosition.initCarte18(ours,lion,eleph));
			deck.add(CartePosition.initCarte19(ours,lion,eleph));
			deck.add(CartePosition.initCarte20(ours,lion,eleph));
			deck.add(CartePosition.initCarte21(ours,lion,eleph));
			deck.add(CartePosition.initCarte22(ours,lion,eleph));
			deck.add(CartePosition.initCarte23(ours,lion,eleph));
	}
	public CartePosition piocherCarte(){
		assert( !estVide() );
		Random indicePioche = new Random();
		this.indiceDePioche = indicePioche.nextInt(nombreDeCarte - 1 );
		while (estPiochée(indiceDePioche) ){
		indiceDePioche = indicePioche.nextInt();
		}
		 CartePosition.setCartesPiochéesToTrue(indiceDePioche);
		return deck.get(indiceDePioche);
	}
	public int getIndicdePioche(){
		return indiceDePioche ; 
	}
	public Podium getPodBleu(int i){
		return deck.get(i).getPodBleu(i);
	}
	public Podium getPodRouge(int i){
		return deck.get(i).getPodRouge(i);
	}
	public boolean estPiochée (int indicePioche){
		return CartePosition.getCartesPiochées(indicePioche) ; 
	}
	public boolean estVide() {
		boolean [] vrai = new boolean [CartePosition.MAX_CARTES - 1] ; 
		Arrays.fill(vrai, true);
		if ( CartePosition.getCartes() == vrai )
			return true ;
		return false ; 
	}
	public ArrayList<CartePosition> getDeck() {
		return deck;
	}
	
}

