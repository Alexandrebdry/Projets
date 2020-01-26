package jeux.mods;

import jeux.jeux.IJeux;

public class Mods4 implements IMods {

	@Override
	public boolean Assembler(IJeux j1, IJeux j2, int n) {
		System.out.println("Vous devez gagné le jeu.");
		boolean test = j1.Jouer(new String[0]);
		while (!test) {
			System.out.println("Essaiez encore une fois.");
			 test = j1.Jouer(new String[0]);
			 
		}
		System.out.println("Bravo, vous avez gagné.");
		return true;
	}

}
