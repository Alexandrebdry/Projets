package jeux.mods;

import jeux.jeux.IJeux;

public class Mods2 implements IMods {

	@Override
	public boolean Assembler(IJeux j1, IJeux j2, int n) {
		System.out.println("Vous devez gagné au moins l'un des deux jeux.");
		boolean test = j1.Jouer(new String[0]);
		if(!test) {
			System.out.println("Vous avez perdu le premier, vous devez gagné le deuxième.");
			test = j2.Jouer(new String[0]);
			if (test) {
				System.out.println("Vous avez gagné le deuxième jeu.");
				return true;
			}
			
		}
		else {
			System.out.println("Vous avez gagné le premier jeu.");
			return true;
		}
		return false;
	}

}
