package jeux.crazy;

import java.util.Scanner;

import jeux.jeux.IJeux;


public class AppliCrazy implements IJeux{


	public boolean Jouer(String[]args)  {
		
		Paquet p = new Paquet();
		Carte depart = p.piocher();
		Carte objectif = p.piocher();
		System.out.println("de " + depart + " à " + objectif);
		System.out.println("ki ->, lo <-, so <->, ni ^_, ma _^");
		System.out.println("entrez votre ordre, vous n'avez qu'une seule chance :");
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		String ordre = s.next().toLowerCase();
		try {
			Carte c = depart;
			System.out.println("   -> " + c);
			for (int i = 0; i + 1 < ordre.length(); i = i + 2) {
				String od = ordre.substring(i, i + 2);
				if ("ki".equals(od))
					c = c.ki();
				else if ("lo".equals(od))
					c = c.lo();
				else if ("so".equals(od))
					c = c.so();
				else if ("ni".equals(od))
					c = c.ni();
				else if ("ma".equals(od))
					c = c.ma();
				else
					throw new IllegalArgumentException(od + " : commande inconnue");
				System.out.println(od + " -> " + c);
			}
			if (c.equals(objectif)) {
				System.out.println("Bravo");
				return true;
			}
				
			else
				System.out.println("Dommage");
				return false;
		}
		catch (RuntimeException e) {
				System.out.println(e.getMessage());
		}
		return false;
	}
}
