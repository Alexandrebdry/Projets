package ressources;

import client.Abonne;
import serveur.exceptions.EmpruntException;
import serveur.exceptions.ResaException;
import serveur.exceptions.RetourException;

public interface Document {
	int numero();

	void reserver(Abonne ab) throws ResaException;

	void emprunter(Abonne ab) throws EmpruntException;
	
	void retour() throws RetourException;
	
}