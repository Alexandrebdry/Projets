package jeux.jeux;
import jeux.crazy.AppliCrazy;
import jeux.devinettes.AppliDevinettes;
import jeux.intrus.AppliIntrus;
import jeux.mods.Mods1;

import jeux.mods.Mods2;
import jeux.mods.Mods3;
import jeux.mods.Mods4;
import jeux.pendu.AppliPendu;
import jeux.pfc.AppliPierreFeuilleCiseaux;
import jeux.pppg.AppliPlusPetitPlusGrand;
import jeux.suites.AppliSuite;
import jeux.tictactoe.AppliTicTacToe;

public class Appli {

	public static void main(String[] args) {
		
		final int NB_MAX_ESSAIS = 5 ;
		
 		Mods1 mods1 = new Mods1();
		Mods2 mods2 = new Mods2();
		Mods3 mods3 = new Mods3();
		Mods4 mods4 = new Mods4();
		
		
		AppliCrazy crazy = new AppliCrazy();
		AppliDevinettes devinettes = new AppliDevinettes();
		AppliIntrus intrus = new AppliIntrus();
		AppliPlusPetitPlusGrand pppg = new AppliPlusPetitPlusGrand();
		AppliSuite suite = new AppliSuite();
		AppliTicTacToe tictactoe = new AppliTicTacToe();
		AppliPierreFeuilleCiseaux pfc = new AppliPierreFeuilleCiseaux();

		
		//mods1.Assembler(pfc, suite, 0);
		mods2.Assembler(intrus, devinettes, 0);
		mods3.Assembler(crazy, crazy, NB_MAX_ESSAIS);
		mods4.Assembler(intrus, tictactoe, 0);
	}

}
