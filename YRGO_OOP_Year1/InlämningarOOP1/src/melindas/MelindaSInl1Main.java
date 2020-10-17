package melindas;

import java.text.NumberFormat;
import java.text.ParseException;
import javax.swing.JOptionPane;

public class MelindaSInl1Main {

	static NumberFormat r = NumberFormat.getInstance();							
	static double pi = Math.PI;									//Tilldelar variabeln pi värdet 3,14etc med hjälp av Math.PI;
	static String radie;
	
	public static void main(String[] args) throws ParseException {
		
		String omkrets;
		String area;
		
		radie = JOptionPane.showInputDialog("Ange cirkelns radie: ");
		omkrets = hamtaOmkr();
		area = hamtaArea();
		
		JOptionPane.showMessageDialog(null, "Cirkeln har radien " + radie + " cm," + 	// Programmet avslutas med en meddelanderuta 
		"\nomkretsen är " + omkrets + " cm " + ", \noch arean är " + area + " cm².");	//där beräkningar som berör cirkeln skrivs ut.
	
		
	}
	private static String hamtaArea() throws ParseException {
		double x = r.parse(radie).doubleValue();
		x = pi * x * x;
		r.setMaximumFractionDigits(2);							// Begränsar decimalerna till 2. 
		String ar = r.format(x);								// Gör om double x till en string med namnet ar. Gör att output visas i det lokala formatet.   
		return ar;												// returnerar ar till main metoden så att den kan skrivas ut. 
	}

	
	private static String hamtaOmkr() throws ParseException{
		double y = r.parse(radie).doubleValue();
		y = 2 * pi * y;
		r.setMaximumFractionDigits(2);
		String om = r.format(y);
		return om;
	}
}
	