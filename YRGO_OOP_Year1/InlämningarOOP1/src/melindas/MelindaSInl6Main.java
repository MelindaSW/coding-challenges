package melindas;

import javax.swing.JOptionPane;

public class MelindaSInl6Main {

	public static void main(String[] args) {
//		Skapa referenser till kvadrat och cirkelobjekt:
		MelindaSSquare kvadrat = new MelindaSSquare(5.2);
		MelindaSCircle cirkel = new MelindaSCircle(3.5);
		
//		Formaterar utskriften och tilldela den till en variabel så att utskriften kan visas i en option pane. 
//		Hämtar resultatet av metoderna i kvadrat och cirkelklassen som räknar ut de måtten som vi behöver. 
		
		String utskrift = String.format("Cirkelns diameter är %.2f och arean är %.2f \nKvadratens area är %.2f", 
										cirkel.readDiameter(), cirkel.readArea(),kvadrat.readArea());
		JOptionPane.showMessageDialog(null, utskrift);
	}

}
