package jeux.mods;

import jeux.jeux.IJeux;


public class Mods1 implements IMods {
	@Override
	public boolean Assembler(IJeux j1, IJeux j2, int n) {
		
		System.out.println("Vous devez gagné les deux jeux.");
		boolean test =	j1.Jouer(new String[0]);
		if (test) {
			
		System.out.println("Vous avez gagné le premier jeu.");
		test =	j2.Jouer(new String[0]);
		}
			if (test){
				System.out.println("Vous avez aussi gagné le deuxième.");
				return true;
			}
				
			System.out.println("Vous avez perdu.");
			return false;
	}
}
