package jeux.intrus;

import java.util.Arrays;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import jeux.jeux.IJeux;


public class AppliIntrus implements IJeux {


	private static class Question {
		public final List<String> mots;
		public final int intrus;

		public Question(List<String> mots, int intrus) {
			if (mots == null || intrus < 1 || intrus > mots.size())
				throw new IllegalArgumentException();
			this.mots = mots;
			this.intrus = intrus;
		}
	}
	
	public boolean Jouer(String[]args)  {
		boolean b;
		List<Question> questions = Arrays.asList(
				new Question(Arrays.asList("pomme", "ananas", "poisson", "citron"), 3)
				, new Question(Arrays.asList("fer", "igloo", "acier", "brique"), 2)
				, new Question(Arrays.asList("eau", "lait", "jus", "fruit"), 4)
				, new Question(Arrays.asList("chien", "table", "porte", "mur"), 1)
				, new Question(Arrays.asList("chat", "girafe", "baleine", "histoire", "éléphant"), 4)
				, new Question(Arrays.asList("stylo", "étiquette", "pinceau", "crayon"), 2)
				, new Question(Arrays.asList("beau", "belle", "gentil", "lit", "agréable"), 4)
				, new Question(Arrays.asList("dormir", "manger", "particulier", "rêver"), 3)
				, new Question(Arrays.asList("photo", "image", "poster", "carton"), 4)
				, new Question(Arrays.asList("plume", "dune", "poil", "duvet"), 2)
				);
		Random r = new Random();
		Question q = questions.get(r.nextInt(questions.size()));
		System.out.println("Donnez le numéro de l'intrus parmi les mots qui suivent");
		int i = 0;
		for (String m : q.mots)	
			System.out.println((++i) + " : " + m);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		try {
			int intrus = sc.nextInt();
			if (intrus == q.intrus) {
				System.out.println("Bravo");
			b = true;
			}
			else {
				System.out.println("Dommage");
			b = false;
			}
		}
		catch (Exception e) {
			System.out.println("Raté");
			b = true;
		}
		return b;
	}
}
