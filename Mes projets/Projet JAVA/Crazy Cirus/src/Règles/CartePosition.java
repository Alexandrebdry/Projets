package Règles;

import java.util.ArrayList ;
import java.util.Arrays; 

public class CartePosition {
	
	private static ArrayList <Podium> podiumsBleus ;
	private static ArrayList <Podium> podiumsRouges ;
	public static final int MAX_CARTES=24;
	private static boolean [] cartesPiochées = new boolean [MAX_CARTES-1];
	
	
	public CartePosition () {
		Arrays.fill(cartesPiochées, false);
		podiumsBleus = new ArrayList<Podium>();
		podiumsRouges = new ArrayList<Podium>();

	}
	public String toString (int i) {
		i = podiumsBleus.size() ; //podiumsBleus.get(i).toString(podiumsRouges.get(i)) ;
		System.out.println(i);
		return "" ;
	}
	public static boolean getCartesPiochées(int i) {
		return cartesPiochées[i];
	}
	public static void setCartesPiochéesToTrue(int i) {
		CartePosition.cartesPiochées[i] = true;
	}
	public static boolean[] getCartes(){
		return cartesPiochées ; 
	}
	public Podium getPodBleu(int i ) {
		return podiumsBleus.get(i); 
	}
	public Podium getPodRouge(int i ) {
		return podiumsRouges.get(i); 
	}
	
	public static CartePosition initCarte00(Animaux Ours, Animaux Lion,Animaux Elephant) {
		CartePosition carte00= new CartePosition();
		Podium Bleu = new Podium ();
		Podium Rouge = new Podium ();
		Bleu.setAnimal(Lion);
		Bleu.setAnimal(Ours);
		Bleu.setAnimal(Elephant);
		podiumsBleus.add(Bleu);
		podiumsRouges.add(Rouge);
		return carte00;
			
	}
	public static CartePosition initCarte01(Animaux Ours, Animaux Lion,Animaux Elephant) {
		CartePosition carte01 = new CartePosition();
		Podium Bleu = new Podium ();
		Podium Rouge = new Podium ();
		Bleu.setAnimal(Lion);
		Bleu.setAnimal(Elephant);
		Bleu.setAnimal(Ours);
		podiumsBleus.add(Bleu);
		podiumsRouges.add(Rouge);
		return carte01;
			
	}
	public static CartePosition initCarte02(Animaux Ours, Animaux Lion,Animaux Elephant) {
		CartePosition carte02 = new CartePosition();
		Podium Rouge = new Podium ();
		Podium Bleu = new Podium ();
		Rouge.setAnimal(Lion);
		Rouge.setAnimal(Ours);
		Rouge.setAnimal(Elephant);
		podiumsBleus.add(Bleu);
		podiumsRouges.add(Rouge);
		return carte02;
	}
	public static CartePosition initCarte03(Animaux Ours, Animaux Lion,Animaux Elephant) {
		CartePosition carte03 = new CartePosition();
		Podium Rouge = new Podium ();
		Podium Bleu = new Podium ();
		Rouge.setAnimal(Lion);
		Rouge.setAnimal(Elephant);
		Rouge.setAnimal(Ours);
		podiumsBleus.add(Bleu);
		podiumsRouges.add(Rouge);
		return carte03;
	}
	public static CartePosition initCarte04(Animaux Ours, Animaux Lion,Animaux Elephant) {
		CartePosition carte04 = new CartePosition();
		Podium Bleu = new Podium ();
		Podium Rouge = new Podium ();
		Bleu.setAnimal(Ours);
		Bleu.setAnimal(Lion);
		Bleu.setAnimal(Elephant);
		podiumsBleus.add(Bleu);
		podiumsRouges.add(Rouge);
		return carte04;
			
	}
	public static CartePosition initCarte05(Animaux Ours, Animaux Lion,Animaux Elephant) {
		CartePosition carte05 = new CartePosition();
		Podium Bleu = new Podium ();
		Podium Rouge = new Podium ();
		Bleu.setAnimal(Ours);
		Bleu.setAnimal(Elephant);
		Bleu.setAnimal(Lion);
		podiumsBleus.add(Bleu);
		podiumsRouges.add(Rouge);
		return carte05;
	}
	
	public static CartePosition initCarte06(Animaux Ours, Animaux Lion,Animaux Elephant) {
		CartePosition carte06 = new CartePosition();
		Podium Bleu = new Podium (); 
		Podium Rouge = new Podium ();
		Rouge.setAnimal(Ours);
		Rouge.setAnimal(Elephant);
		Rouge.setAnimal(Lion);
		podiumsBleus.add(Bleu);
		podiumsRouges.add(Rouge);
		return carte06;
	}
	public static CartePosition initCarte07(Animaux Ours, Animaux Lion,Animaux Elephant) {
		CartePosition carte07 = new CartePosition();
		Podium Bleu =  new Podium ();
		Podium Rouge = new Podium ();
		Rouge.setAnimal(Ours);
		Rouge.setAnimal(Lion);
		Rouge.setAnimal(Elephant);
		podiumsBleus.add(Bleu);
		podiumsRouges.add(Rouge);
		return carte07;
	}
	public static CartePosition initCarte08(Animaux Ours, Animaux Lion,Animaux Elephant) {
		CartePosition carte08 = new CartePosition();
		Podium Bleu = new Podium ();
		Podium Rouge = new Podium ();
		Bleu.setAnimal(Elephant);
		Bleu.setAnimal(Ours);
		Bleu.setAnimal(Lion);
		podiumsBleus.add(Bleu);
		podiumsRouges.add(Rouge);
		return carte08;
			
	}
	public static CartePosition initCarte09(Animaux Ours, Animaux Lion,Animaux Elephant) {
		CartePosition carte08 = new CartePosition();
		Podium Bleu = new Podium ();
		Podium Rouge = new Podium ();
		Bleu.setAnimal(Elephant);
		Bleu.setAnimal(Lion);
		Bleu.setAnimal(Ours);
		podiumsBleus.add(Bleu);
		podiumsRouges.add(Rouge);
		return carte08;
			
	}
	public static CartePosition initCarte10(Animaux Ours, Animaux Lion,Animaux Elephant) {
		CartePosition carte10 = new CartePosition();
		Podium Rouge = new Podium ();
		Podium Bleu = new Podium ();
		Rouge.setAnimal(Elephant);
		Rouge.setAnimal(Ours);
		Rouge.setAnimal(Lion);
		podiumsBleus.add(Bleu);
		podiumsRouges.add(Rouge);
		return carte10;
	}
	public static CartePosition initCarte11(Animaux Ours, Animaux Lion,Animaux Elephant) {
		CartePosition carte11 = new CartePosition();
		Podium Rouge = new Podium ();
		Podium Bleu = new Podium ();
		Rouge.setAnimal(Elephant);
		Rouge.setAnimal(Lion);
		Rouge.setAnimal(Ours);
		podiumsBleus.add(Bleu);
		podiumsRouges.add(Rouge);
		return carte11;
	}
	public static CartePosition initCarte12(Animaux Ours, Animaux Lion,Animaux Elephant) {
		CartePosition carte12 = new CartePosition();
		Podium Bleu = new Podium ();
		Podium Rouge =  new Podium();
		Bleu.setAnimal(Lion);
		Bleu.setAnimal(Ours);
		Rouge.setAnimal(Elephant);
		podiumsBleus.add(Bleu);
		podiumsRouges.add(Rouge);
		return carte12;
	}
	public static CartePosition initCarte13(Animaux Ours, Animaux Lion,Animaux Elephant) {
		CartePosition carte13 = new CartePosition();
		Podium Bleu = new Podium ();
		Podium Rouge =  new Podium();
		Bleu.setAnimal(Lion);
		Bleu.setAnimal(Elephant);
		Rouge.setAnimal(Ours);
		podiumsBleus.add(Bleu);
		podiumsRouges.add(Rouge);
		return carte13;
	}
	public static CartePosition initCarte14(Animaux Ours, Animaux Lion,Animaux Elephant) {
		CartePosition carte14 = new CartePosition();
		Podium Bleu = new Podium ();
		Podium Rouge =  new Podium();
		Bleu.setAnimal(Elephant);
		Rouge.setAnimal(Lion);
		Rouge.setAnimal(Ours);
		podiumsBleus.add(Bleu);
		podiumsRouges.add(Rouge);
		return carte14;
	}
	public static CartePosition initCarte15(Animaux Ours, Animaux Lion,Animaux Elephant) {
		CartePosition carte15 = new CartePosition();
		Podium Bleu = new Podium ();
		Podium Rouge =  new Podium();
		Bleu.setAnimal(Ours);
		Rouge.setAnimal(Lion);
		Rouge.setAnimal(Elephant);
		podiumsBleus.add(Bleu);
		podiumsRouges.add(Rouge);
		return carte15;
	}
	public static CartePosition initCarte16(Animaux Ours, Animaux Lion,Animaux Elephant) {
		CartePosition carte16 = new CartePosition();
		Podium Bleu = new Podium ();
		Podium Rouge =  new Podium();
		Bleu.setAnimal(Lion);
		Rouge.setAnimal(Ours);
		Rouge.setAnimal(Elephant);
		podiumsBleus.add(Bleu);
		podiumsRouges.add(Rouge);
		return carte16;
	}
	public static CartePosition initCarte17(Animaux Ours, Animaux Lion,Animaux Elephant) {
		CartePosition carte17 = new CartePosition();
		Podium Bleu = new Podium ();
		Podium Rouge =  new Podium();
		Bleu.setAnimal(Lion);
		Rouge.setAnimal(Elephant);
		Rouge.setAnimal(Ours);
		podiumsBleus.add(Bleu);
		podiumsRouges.add(Rouge);
		return carte17;
	}

   public static CartePosition initCarte18(Animaux Ours, Animaux Lion,Animaux Elephant) {
	   CartePosition carte18 = new CartePosition();
	   	Podium Bleu = new Podium ();
		Podium Rouge =  new Podium();
		Bleu.setAnimal(Ours);
		Bleu.setAnimal(Elephant);
		Rouge.setAnimal(Lion);
		podiumsBleus.add(Bleu);
		podiumsRouges.add(Rouge);
		return carte18;
   }

   public static CartePosition initCarte19(Animaux Ours, Animaux Lion,Animaux Elephant) {
	   CartePosition carte19 = new CartePosition();
	   	Podium Bleu = new Podium ();
		Podium Rouge =  new Podium();
		Bleu.setAnimal(Elephant);
		Bleu.setAnimal(Ours);
		Rouge.setAnimal(Lion);
		podiumsBleus.add(Bleu);
		podiumsRouges.add(Rouge);
		return carte19;
   }
   public static CartePosition initCarte20(Animaux Ours, Animaux Lion,Animaux Elephant) {
	   CartePosition carte20 = new CartePosition();
	   	Podium Bleu = new Podium ();
	   	Podium Rouge =  new Podium();
	   	Bleu.setAnimal(Ours);
	   	Rouge.setAnimal(Elephant);
		Rouge.setAnimal(Lion);
		podiumsBleus.add(Bleu);
		podiumsRouges.add(Rouge);
		return carte20;
   }
   public static CartePosition initCarte21(Animaux Ours, Animaux Lion,Animaux Elephant) {
	   CartePosition carte21 = new CartePosition();
		Podium Bleu = new Podium ();
		Podium Rouge =  new Podium();
		Bleu.setAnimal(Elephant);
		Bleu.setAnimal(Lion);
		Rouge.setAnimal(Ours);
		podiumsBleus.add(Bleu);
		podiumsRouges.add(Rouge);
		return carte21;
	}
   public static CartePosition initCarte22(Animaux Ours, Animaux Lion,Animaux Elephant) {
	   CartePosition carte22 = new CartePosition();
		Podium Bleu = new Podium ();
		Podium Rouge =  new Podium();
		Bleu.setAnimal(Ours);
		Bleu.setAnimal(Lion);
		Rouge.setAnimal(Elephant);
		podiumsBleus.add(Bleu);
		podiumsRouges.add(Rouge);
		return carte22;
	}
   public static CartePosition initCarte23(Animaux Ours, Animaux Lion,Animaux Elephant) {
	   CartePosition carte23 = new CartePosition();
	  Podium Bleu = new Podium ();
	  Podium Rouge =  new Podium();
	  Bleu.setAnimal(Elephant);
	  Rouge.setAnimal(Ours);
	  Rouge.setAnimal(Lion);
	  podiumsBleus.add(Bleu);
	  podiumsRouges.add(Rouge);
	  return carte23;
  	}	
}
