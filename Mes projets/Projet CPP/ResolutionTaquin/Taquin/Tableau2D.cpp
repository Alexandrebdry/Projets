#include "Tableau2D.h"
#include "iostream"
#include "cassert"
using namespace std;

/**
* @file Tableau2D.cpp
* Projet Taquin
* @author Alexandre,Bilel
* @version 1 - 13/12/2018
* @brief Fonction d'un Tableau2D
*/

void initialiser(TAB2D& m, unsigned int nbL, unsigned int nbC) {
	assert(nbL > 0 && nbC > 0);
	m.tab = new Item*[nbL];

	for (unsigned int i = 0; i < nbL; i++) {
		m.tab[i] = new Item[nbC];
	}
	m.nbc = nbC;
	m.nbl = nbL;
}
// Desallouer un Tableau2D
void detruire(TAB2D& m) {
	for (unsigned int i = 0; i < m.nbc; i++) {
		delete[] m.tab[i];
	}
	delete[] m.tab;
}
// Lire un Tableau2D
void lire(TAB2D& m) {
	for (unsigned int i = 0; i < m.nbl; i++)
	{
		for (unsigned int j = 0; j < m.nbc; j++)
		{
			cin >> m.tab[i][j];
		}
	}
}
// Afficher un Tableau2D
void afficher(const TAB2D& m) {
	cout << "Damier : " << m.nbl << " lignes, " << m.nbc << " colonnes" << endl;
	for (unsigned int i = 0; i < m.nbl; i++)
	{
		for (unsigned int j = 0; j < m.nbc; j++)
		{
			cout << m.tab[i][j] << " ";
			if (j = m.nbc - 1)
				cout << endl;
		}
	}
}