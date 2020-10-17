package melindas;

public class MelindaSInl5MainSpel1 {

	public static void main(String[] args) {
		
		MelindaSInl5Die player1 = new MelindaSInl5Die(); // Instansiering av objekt player1
		MelindaSInl5Die player2 = new MelindaSInl5Die(); // Instansiering av objekt player2
		int pl1, pl2;                  
		
		boolean winner = false;
		int i = 1;
		
		while(!winner)									 //Loop som loopar till dess att någon spelare slår en 6a, boolean winner evalueras då till falskt och loopen avslutas. 
		{
			player1.roll();
			player2.roll();
			pl1 = player1.getResult();
			pl2 = player2.getResult();
			
			System.out.println("Pl 1, throw nr " + i + ": " +pl1);
			System.out.println("Pl 2, throw nr " + i + ": " + pl2 +'\n');
			i += 1;
			
			if (pl1 == 6 && pl2 == 6) 
			{
				System.out.println("It's a tie!");			  // Om både pl1 och pl2 får en 6a blir det oavgjort.
				winner = true;
			}			
			else if (pl1 == 6) 								  // Om pl1 == 6 vinner player 1.
			{
				System.out.println("Winner: Player 1!");
				winner = true;			
			}
			else if (pl2 == 6) 								  // Om pl2 == 6 vinner player 2. 
			{
				System.out.println("Winner: Player 2!");
				winner = true;
			}
		}
	}
}
