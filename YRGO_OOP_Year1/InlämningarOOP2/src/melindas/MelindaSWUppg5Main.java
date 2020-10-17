package melindas;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MelindaSWUppg5Main {
	
	JFrame frame;
	JPanel mainPanel;
	JButton button;
	
	public MelindaSWUppg5Main() {
//		Skapa objekten som behövs för att skapa rutan.
		frame = new JFrame();
		mainPanel = new JPanel();
		button = new JButton();
		
		button.setText("Men klicka då da!");
//		Dold klass med actionlistener.
		ActionListener l = new ActionListener() {
//			Klassvariabel som räknas upp varje gång knappen används. 
			int counter = 1;
			@Override
			public void actionPerformed(ActionEvent e) {
					
					if (counter > 1) {
						button.setText("Du har klickat " + counter + " gånger!");
						counter++;
					} else {
						button.setText("Du klickade!");
						counter++;
					}
			}};
//		Actionlistener l kopplas till knappen.
		button.addActionListener(l);
		
		mainPanel.add(button);
		
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
				new MelindaSWUppg5Main();
			}
		});
	}
	
}
