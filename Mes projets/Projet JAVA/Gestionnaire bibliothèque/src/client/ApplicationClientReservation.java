package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ApplicationClientReservation {

	private static final int portResa = 2500;
	private final static String HOST = "localhost";
	
	public static void main(String[] args) throws Exception {
		Socket socket = null;		
		try {
			socket = new Socket(HOST, portResa);
			BufferedReader sin = new BufferedReader (new InputStreamReader(socket.getInputStream ( )));
			PrintWriter sout = new PrintWriter (socket.getOutputStream ( ), true);
			BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));			
			System.out.println("Connecté au serveur " + socket.getInetAddress() + ":"+ socket.getPort());
			
			int numeroDoc, numeroAbonne;
			String line;
			
			System.out.println("Tapez votre numéro abonné");
			System.out.print("->");
			numeroAbonne = clavier.read();
			sout.println(numeroAbonne);

			line = sin.readLine();
			if(line.equals("Abonne Inexistant")) {
				System.out.println(line);
				socket.close();
			}
			
			System.out.println("Tapez le numéro du document");
			System.out.print("->");
			numeroDoc = clavier.read();
			sout.println(numeroDoc);
			
			System.out.println(sin.readLine());
			socket.close();
		}
		catch (IOException e) { System.err.println(e); }
		// Refermer dans tous les cas la socket
		try { if (socket != null) socket.close(); } 
		catch (IOException e2) { ; }	
	}
}
