package melindas;

import java.util.Calendar;
import javax.swing.JOptionPane;

public class MelindaSInl4Main {

	public static void main(String[] args) {

		String input;
	
		input =JOptionPane.showInputDialog("Skriv in din födelsedag (ÅÅÅÅMMDD):");
		
		if (input == null || input.isEmpty() || input.length() > 8 || input.length() < 8) 
		{
			JOptionPane.showMessageDialog(null, "Felaktigt format.");
			System.exit(0);
		}
//		Om användaren skriver in sitt födelsedatum i fel format visas ett felmeddelande. 
		
		int userYear = Integer.parseInt(input.substring(0, 4));
		int userMonth = Integer.parseInt(input.substring(4, 6));
		int userDay = Integer.parseInt(input.substring(6, 8));
//		Gör om delar av input stringen till integer variablar. ÅÅÅÅ = userYear, MM = userMonth, DD = userDay. 
//		Substring(x, y) anger på vilken position, från och till, i stringen de ska hämtas från.
		
		Calendar cal = Calendar.getInstance();
		
		int presentYear = cal.get(Calendar.YEAR);
		int presentMonth = cal.get(Calendar.MONTH) + 1;
		int presentDay = cal.get(Calendar.DAY_OF_MONTH);
//		Hämtar dagens datum från klassen Calendar och tilldelar värdena i variablerna presentYear etc.
//		Addera 1 till month eftersom räkningen av månaderna börjar på 0 i Calendar.MONTH.
		
		int birthdayYears = presentYear - userYear;
//		Beräknar antal år användaren eventuellt fyller. 
		
		if (userDay == presentDay && userMonth == presentMonth) 
		{
			JOptionPane.showMessageDialog(null, "Grattis på " + birthdayYears + "-års dagen!");
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "Det är inte din födelsedag idag :´-(");
		}
//		Villkorssats som avgör om användarens DD och MM stämmer överens med dagens datum. 
//		Om true skrivs ett grattismeddelande ut, innehållande hur många år användaren fyller.
//		Annars visas ett meddelande som förklarar att det inte är användarens födelsedag idag. 
	}

}
