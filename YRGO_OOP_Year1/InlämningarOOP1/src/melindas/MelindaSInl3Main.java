package melindas;
// Formatera utskriften av multiplikationstabellen med html.
import javax.swing.*;
 
public class MelindaSInl3Main  {

	public static void main(String[] args) {
		
		String tabell = "<html><body><table border = '1'>";		
//		 Html tags omsluter innehållet i tabell variabeln. Body tagen omsluter innehållet. Ska bara köras en gång. 
//		 Table border (ram omkring tabellen). 'x' =ramens tjocklek. 
		
		for (int r = 1; r <= 10 ; r++) {
			tabell = tabell + "<tr>";
//			Starttag i yttersta loopen. <tr> = table row. Horisontella linjer. Ska upprepas 10 ggr.
			for (int c = 1 ; c <= 10 ; c++) {
				tabell = tabell + "<td>" + r*c + "</td>";
//				Table data <td> i innersta loopen. Ska upprepas på var sida om produkten av r*c. Lodräta linjer. 10 ggr för varje rad. 100 ggr totalt. 
			}
			tabell = tabell + "</tr>";				
//			Avslutande tag för table row. 
		}
		tabell = tabell + "</table></body></html>";
//		Tabellen deklareras en sista gång med sitt värde och avslutande taggar. Lägg till / för att få en avslutande tagg. 
		JOptionPane.showMessageDialog(null, tabell);
		System.exit(0);
	}
}

