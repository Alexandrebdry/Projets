#include "Tableau2D.h"
#include <iostream>
#include <cassert>
using namespace std;

int main() {
	TAB2D m;
	unsigned int nbc = 0, nbl = 0;
	cin >> nbl >> nbc;
	initialiser(m, nbl, nbc);
	lire(m);
	afficher(m);
	detruire(m);
	return 0;
}