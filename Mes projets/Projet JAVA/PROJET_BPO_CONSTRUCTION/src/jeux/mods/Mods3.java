package jeux.mods;

import jeux.jeux.IJeux;

public class Mods3 implements IMods {

	@Override
	public boolean Assembler(IJeux j1, IJeux j2, int n) {
		System.out.println("Vous avez " + n + " essais pour gagner.");
		int i = 0;
		while (i < n) {
		boolean test = j1.Jouer(new String[0]);
		if (test) {
			System.out.println("Vous avez gagné.");
			return true;
		}

		i++;
	}
		System.out.println("Vous avez perdu.");
		return false;
}

}
