#ifndef _TAB2D_
#define _TAB2D_ 
#include "Item.h"

/**
* @file Tableau2D.h
* Projet Taquin
* @author Alexandre,Bilel
* @version 1 - 13/12/2018
* @brief Composant d'un Tableau2D
*/

/**
* @brief Structure de données de type TAB2D
*/
struct TAB2D {
	Item **tab; //Adresse du tableau bidimensionnel en mémoire dynamique
	unsigned int nbl; //nombre de lignes de la matrice
	unsigned int nbc; //nombre de la colonnes de la matrice
};

/**
* @Brief Allouer en mémoire dynamique un Tableau2D
*/
void initialiser(TAB2D& m, unsigned int nbL,unsigned int nbC);
// Desallouer un Tableau2D
void detruire(TAB2D& m);
// Lire un Tableau2D
void lire(TAB2D& m);
// Afficher un Tableau2D
void afficher(const TAB2D& m);
#endif 