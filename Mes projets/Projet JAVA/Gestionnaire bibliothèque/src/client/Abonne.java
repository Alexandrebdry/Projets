package client;


import ressources.Document;

public interface Abonne {
	int getNum();
	
	boolean docEmprunter(Document d);
	boolean docReserver(Document d);
	
	void retour(Document d);	
}
