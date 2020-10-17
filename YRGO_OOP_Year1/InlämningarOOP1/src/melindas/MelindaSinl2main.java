package melindas;

import static javax.swing.JOptionPane.*;
import java.text.NumberFormat;
import java.text.ParseException;

public class MelindaSinl2main {
//	Programmet beräknar medelvärdet på ett antal tal som hämtas från användaren. 
	public static void main(String[] args) throws ParseException{
		
		NumberFormat r = NumberFormat.getInstance();

		String input= "";
		double sum = 0;
		int y = -1;
		int i;		

		for (i = 0; i > y; i++)
		{
		input = showInputDialog(null, "Ange ett tal:", "Input", QUESTION_MESSAGE); 
//		 Hämta input från användaren. Denna loopas så länge i < y eller till dess att användaren avbryter för beräkning. 
			
			if (input == null || input.isEmpty() && i > 1) 
//			Om användaren avbryter efter minst ett nummer har lagts in beräknar programmet medelvärdet och antalet tal och skriver ut resultatet.  	
			{
				sum = sum / i;
//				Medelvärdet beräknas här. 
					if (!Double.isFinite(sum))
//						Om användaren avslutar efter att bara ha matat in ett nummer (om värdet som beräknas är lika med NaN, Not a Number) visas dialogen nedan. 
						{
						showMessageDialog(null, "Kan inte beräkna medelvärdet! Du måste mata in minst ett tal"); System.exit(0); 
						}
					
				showMessageDialog(null, "Medelvärdet av de " + i + " talen är " + sum);
				System.exit(0);
			}
			else if (input == null || input.isEmpty() && i <=1) 
//			Om man avslutar efter att inte ha lagt in ett tal går programmet in hit. 
			{
				showMessageDialog(null, "Kan inte beräkna medelvärdet! Du måste mata in minst ett tal");
				System.exit(0);
			}

		double in = r.parse(input).doubleValue();
		sum += in;
//		Raderna ovan omvandlar stringen input till ett doublevärde som sen adderas in i variabeln sum varje gång loopen loopas. 
		}
		
	}

}
