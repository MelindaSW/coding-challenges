package melindas;

import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class MelindaSInl7AMain {

	public static void main(String[] args) {
		
		int antal = 0;
		String vara = "";
		double pris = 0.0 ;
		
//		Evig loop som termineras först när användaren trycker på avbryt.
		while (true) 	
		{
//			Inputruta som upprepas till dess att användaren trycker avbryt.
			String input = JOptionPane.showInputDialog("Ange antal varor, vara och pris.\nAnvänd mellanslag som avgränsare.\n"
														+ "Använd komma (,) vid decimalform i priset."); 
			
//				Test om input stämmer eller om användaren trycker på avbryt.
				try 
				{
//					Scannern läser inputen och delar upp den i variablerna nedan. Mellanslag är avgränsaren som används by default. 
					Scanner sc = new Scanner(input);
					antal = sc.nextInt();
					vara = sc.next();
					pris = sc.nextDouble();
				}
// 				NullPointerException = Undantag som uppkommer när användaren trycker avbryt.
				catch (NullPointerException e)	
				{
					System.exit(0);
				}
// 				NoSuchElementException = Undantag som uppkommer när input är felaktig. Måste importeras från java.util.
				catch (NoSuchElementException e1) 
				{
					JOptionPane.showMessageDialog(null, "Felaktig input. ");
					continue;
				}
//			Skapar en referens till ett objekt i artikel. Skickar in värdena av inputen i parametern till konstruktorn i klassen MelindaInl7Artikel.
			MelindaSInl7AArtikel rad = new MelindaSInl7AArtikel(antal, vara, pris);

//			Hämtar värdena av input och beräkningar från klassen MelindaInl7Artikel och formaterar till en tabell innan utskrift. 
			System.out.printf("| %04d | %-10s | %10.2f | %10.2f |%n", 
							rad.getAntal(), rad.getVara(), rad.getPris(), rad.getTotalPris());
		}
	}
}


