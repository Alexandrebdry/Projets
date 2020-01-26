package jeux.pppg;

import java.util.Random;

import java.util.Scanner;

import jeux.jeux.IJeux;


public class AppliPlusPetitPlusGrand implements IJeux {


	public boolean Jouer(String[]args)  {
		boolean b;
		final int MAX = args.length > 0 && args[0].equals("-hard") ? 1000 : 100;
		final long NB = Math.round(Math.log(MAX) / Math.log(2));

		System.out.println("Vous devez trouver une valeur comprise entre 1 et " + MAX + " en moins de " + NB + " tentatives");

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int aTrouver = 1 + new Random().nextInt(MAX);
		System.out.println("Entrez une valeur");
		int valeur = sc.nextInt();
		int nb = 1;
		while (valeur != aTrouver && nb < NB) {
			if (valeur < aTrouver)
				System.out.println("c'est plus grand");
			else
				System.out.println("c'est plus petit");
			System.out.println("Entrez une valeur");
			valeur = sc.nextInt();
			++nb;
		}
		if (valeur == aTrouver) {
			System.out.println("Bravo");
			b = true;
		}
		else {
			System.out.println("Dommage");
			b = false;
		}
		return b;
	}
}
