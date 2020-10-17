package melindas;

public class MelindaSInl5MainSpel2 {

	public static void main(String[] args) {
		
		MelindaSInl5Die Player1 = new MelindaSInl5Die(); // Instansiering av spelarobjekt 1
		MelindaSInl5Die Player2 = new MelindaSInl5Die(); // Instansiering av spelarobjekt 2
 
		boolean winner = false;							// Deklarering av nödvändiga variabler.
		int pl1SumOfPoints = 0;
		int pl2SumOfPoints = 0;
		int throwCounter = 0;
		
		while (!winner)									// While loop som loopar till dess att winner deklareras som true. !winner blir då falskt.
		{
		Player1.roll();
		Player2.roll(); 
		pl1SumOfPoints += Player1.getResult();			// Tärningen kastas och resultatet adderas in i summeringsvariablerna för varje varv.
		pl2SumOfPoints += Player2.getResult();
		
		throwCounter++;									// Räknare för antalet kast som behövs för att uppnå 100.
		
		System.out.printf("Throw "+ throwCounter + "\n" + "Player 1: " + pl1SumOfPoints + "\n" 
							+ "Player 2: " + pl2SumOfPoints + "\n\n");
			 
			if (pl1SumOfPoints >= 100 && pl2SumOfPoints >= 100) // Om båda når 100 poäng på lika många kast blir det oavgjort:
			{
				System.out.println("Both have reached 100 points in the same amount of throws.\n"
									+ "It took " + throwCounter + " throws.");
				winner = true;
			}
			else if (pl1SumOfPoints >= 100)				// Spelare 1 vinner om antalet poäng är mer än eller lika med 100.
			{
				System.out.println("Player 1 is the first one to reach 100 points! \n"
									+ "It took " + throwCounter + " throws.");
				winner = true;
			}
			else if (pl2SumOfPoints >= 100)				// Spelare 2 vinner om antalet poäng är mer än eller lika med 100.
			{
				System.out.println("Player 2 is the first one to reach 100 points! \n"
									+ "It took " + throwCounter + " throws." );
				winner = true;							// winner = true avslutar loopen, då !winner evalueras som falskt.  
			}
		}
	}
}
