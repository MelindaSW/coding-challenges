package melindas;

import java.util.*;

public class MelindaSInl5Die {
	
	private static Random diceRandom = new Random();
	private int dots; // Antal prickar som visas.
	
	// Skapa en tärning
	public MelindaSInl5Die() {
		roll();
	}

	// Kasta tärningen
	public void roll() {
		dots = diceRandom.nextInt(6) + 1;
	}
	
	// Resultatet av senaste kastet. 
	public int getResult() {
		return dots;
	}
	
}
