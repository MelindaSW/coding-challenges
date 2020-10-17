package melindas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MelindaSInl18Main extends JFrame{
	
	private static final long serialVersionUID = 1L;

	private MelindaSInl18Flight f1, f2, f3, f4;
	private JPanel header;
	private JLabel fli = new JLabel("Flight"); 
	private JLabel de = new JLabel("Dest"); 
	private JLabel dp = new JLabel("Dep");
	private JLabel ar = new JLabel("Arr");
	private JLabel comm = new JLabel("Comment");
	
	public MelindaSInl18Main() {
		
		makeHeader();
//		Skapar nya flight objekt. Varje objekt visar sig som en panel med fem kolumner. 
//		Ramen har en gridlayout med fem rader och en kolumn. Varje panel får en rad. 
		f1 = new MelindaSInl18Flight("BA1853", "London", 8, 10, 10, 55);
		f2 = new MelindaSInl18Flight("AF512", "Paris", 8, 30, 10, 50);
		f3 = new MelindaSInl18Flight("SK3212", "Copenhagen", 8, 50, 10, 40);
		f4 = new MelindaSInl18Flight("AF989", "Tahiti", 8, 40, 9, 30);
		add(header); add(f1); add(f2); add(f3); add(f4);
		
		setLayout(new GridLayout(5, 1, 0, 1));
//		Mellan varje rad finns ett gap på 1 bildpunkt. 
//		Den visar sig som en svart rad eftersom den svarta bakgrundsfärgen då syns.
		getContentPane().setBackground(Color.BLACK);
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
//		flight 1 är försenad med 15 min. Metoden delay anropas och lägger till 15 min på tiden. 
//		Även typsnittet ändras för att markera förseningen. 
		f1.delay(15);
		f1.setFont(new Font(f1.getFont().getFontName(), Font.ITALIC, f1.getFont().getSize()));
//		flight 2 har öppnat boardingen. Då anropas metoden som lägger till en kommentar i kommentarlabeln. 
		f2.setComment("Boarding gate 15");
		f2.setForeground(Color.RED);
	}
	
	public static void main(String[] args) {
		MelindaSInl18Main main = new MelindaSInl18Main();
	}

	public void makeHeader() {
//		Skapar en headerpanel. Panelen har en rad och fem kolumner. 
//		Texten i label objekten har fet text, strl 14, TimesNewRoman font och röd färg.
		Font font = new Font("TimesRoman", Font.BOLD, 14);
		header = new JPanel();
		header.setLayout(new GridLayout(1, 5));
		header.setPreferredSize(new Dimension(500, 25));
		header.setBackground(Color.BLACK);
		fli.setFont(font);
		de.setFont(font);
		dp.setFont(font);
		ar.setFont(font);
		comm.setFont(font);
		
		fli.setForeground(Color.RED);
		de.setForeground(Color.RED);
		dp.setForeground(Color.RED);
		ar.setForeground(Color.RED);
		comm.setForeground(Color.RED);
		
		header.add(fli); 
		header.add(de); 
		header.add(dp); 
		header.add(ar); 
		header.add(comm);
	}
}
