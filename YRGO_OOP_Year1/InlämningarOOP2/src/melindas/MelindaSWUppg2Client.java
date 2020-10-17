package melindas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

//Gör en server som tar emot ett värde från en klient och returnerar en beräkning, typ Celsius
//till Fahrenheit eller vice versa. 

public class MelindaSWUppg2Client {

	public static void main(String[] args) throws IOException {
		
		String input;
		String result;
		
		DataInputStream fromServer;
		DataOutputStream toServer; 
//		En socket skapas, i parametrarna definieras med vilken host och via vilken port kopplingen ska ske.
		Socket socket = new Socket("127.0.0.1", 11111);
		Scanner sc = new Scanner(System.in);

//		Skapar strömmar till och från servern via socket.
		fromServer = new DataInputStream(socket.getInputStream());
		toServer =  new DataOutputStream(socket.getOutputStream());
		
		while (true) {
			
			System.out.print("Skriv in grader i celsius, Q för att avsluta: ");
			
			input = sc.nextLine().trim();
//			Om input är q eller Q så avslutas programmet och socket anslutningen stängs. 
			if (input.equalsIgnoreCase("Q")) {
				System.out.println("Avslutar...");
				socket.close();
				System.exit(0);
			}
//			Skickar input till servern och tar emot + skriver ut resultatet av beräkningen som sker där. 
			toServer.writeUTF(input);
			result = fromServer.readUTF();
			System.out.println(result);
			
		}
		
	}

}
