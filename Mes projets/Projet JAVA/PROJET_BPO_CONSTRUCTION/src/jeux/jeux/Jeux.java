package jeux.jeux;

public class Jeux  implements IJeux {

	
	@SuppressWarnings("null")
	public IJeux[] Assembler(IJeux[] j1, IJeux[] j2) {
		
		IJeux[] tabJeux = new IJeux[2];
		tabJeux[0] = j1[0];
		tabJeux[1] = j2[0];
		return tabJeux;
		
	}

	@Override
	public boolean Jouer(String[] args) {
		// TODO Auto-generated method stub
		return false;
	}	
}
