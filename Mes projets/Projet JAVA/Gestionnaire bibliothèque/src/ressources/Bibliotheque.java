package ressources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import client.Abonne;

public class Bibliotheque {
	private static ArrayList<Document> docs = new ArrayList<>();
	private static ArrayList<Abonne> listeAbonnes = new ArrayList<>();
	private static Map<Integer,Integer> docsEmprunter = new HashMap<>();
	private static Map<Integer,Integer> docsReserver = new HashMap<>();
	
	public static void ajouterDoc(Document d) {
		docs.add(d);
	}
	
	public static void ajouterAbonne(Abonne ab) {
		listeAbonnes.add(ab);
	}
	
	public static void retour(int numeroDoc) {
		Bibliotheque.getDocument(numeroDoc).retour();
	}

	private static Document getDocument(int numeroDoc) {
		for(Document d : docs)
			if(d.numero() == numeroDoc)
				return d;
		return null;
	}
	
	private static Abonne getAbonne(int numeroAbonne) {
		for(Abonne ab : listeAbonnes)
			if(ab.getNum() == numeroAbonne)
				return ab;
		return null;
	}

	public static boolean abonneExistant(int numeroAbonne) {
		return Bibliotheque.getAbonne(numeroAbonne) == null;
	}

	public static String listeDocuments() {
		StringBuffer sb = new StringBuffer();
		for(Document d : docs)
			if(!docsEmprunter.containsKey(d.numero()) && !docsReserver.containsKey(d.numero()))
				sb.append(d);
		return sb.toString();
	}

	public static boolean docReserver(int numeroDoc) {
		return docsReserver.containsKey(numeroDoc);
	}

	public static void emprunter(int numeroAbonne, int numeroDoc) {
		docsEmprunter.put(numeroAbonne, numeroDoc);
		docsReserver.remove(numeroDoc);
		Bibliotheque.getDocument(numeroAbonne).emprunter(Bibliotheque.getAbonne(numeroAbonne));
	}

	public static void reserver(int numeroAbonne, int numeroDoc) {
		docsReserver.put(numeroAbonne, numeroDoc);
		Bibliotheque.getDocument(numeroAbonne).reserver(Bibliotheque.getAbonne(numeroAbonne));
	}

	public static void finReservation(Document d) {
		docsReserver.remove(d.numero());
	}



}
