package melindas;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MelindaSWUppg6Main {

	JFrame frame;
	JPanel mainPanel;
	JButton button;
//	Klassvariabel som räknas upp varje gång knappen används. 
	int counter = 1;
	
	public MelindaSWUppg6Main() {
//		Skapa objekten som behövs för att skapa rutan.
		frame = new JFrame();
		mainPanel = new JPanel();
		button = new JButton();
//		Knappen får en ursprungstext och kopplas till en action listener med ett lambda uttryck.
		button.setText("Men klicka då da!");
		button.addActionListener(e -> actionPerformed(e));
//		Lägger till knappen i panelen.
		mainPanel.add(button);
//		Justeringar för ramen. 
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(mainPanel);
		frame.setTitle("Lyssnare");
		frame.setPreferredSize(new Dimension(300, 100));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.pack();
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MelindaSWUppg6Main();
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
//			Variabeln counter är satt till värdet 1. När knappen klickas på första gången utförs else. 
//			Andra klicket, och alla efterföljande klick triggar satserna i if blocket.
			if (counter > 1) {
				button.setText("Du har klickat " + counter + " gånger!");
				counter++;
			} else {
				button.setText("Du klickade!");
				counter++;
			}
	}

}
