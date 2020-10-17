package melindas;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MelindaSInl19StartPanel {
	
	JPanel startPanel = new JPanel();

	JLabel logo = new JLabel();
	
	JLabel portrait = new JLabel();

	public MelindaSInl19StartPanel() {
//		Skapar första panelen som har en logga i mitten högst upp. Ett foto centrerat mitt i panelen
//		samt en infotext om programmet i nedre vänstra hörnet. 
		
//		Lånar metoden getAndScaleImage från PhotoAlbumPanel för att hämta in bilder med rätt strl.
		MelindaSInl19PhotoAlbumPanel a = new MelindaSInl19PhotoAlbumPanel();
		
//		Panelen får BorderLayout som layout och bakgrunden är vit. 
		startPanel.setLayout(new BorderLayout());
		startPanel.setBackground(Color.WHITE);
		
//		porträttet i mitten får bredden 400 pixlar. -1 i parametern betyder att höjden skalas i relation till bredden.
		portrait.setIcon(a.getAndScaleImage("selfie.jpg", 400, -1));
		portrait.setHorizontalAlignment(JLabel.CENTER);
		
//		Loggan blir 100 pixlar bred och höjden anpassas även här så att proportionerna inte ändras. 
		logo.setIcon(a.getAndScaleImage("Scissor.jpg", 100, -1));
		logo.setHorizontalAlignment(JLabel.CENTER);
		
//		Textlabeln får sin text
		JLabel info = new JLabel();
		info.setText("Programmet skapat av M.Sandström-Wagner 2018-12-03");
		
//		Alla labels läggs till i panelen. Norr, center och söder placering.
//		Om inte setHorizontalAlignment är specifierad så läggs de in längst till vänster. 
		startPanel.add(logo, BorderLayout.NORTH);
		startPanel.add(portrait, BorderLayout.CENTER);
		startPanel.add(info, BorderLayout.SOUTH);
		
	}
	
	public JPanel getStartPanel() {
		return startPanel;
	}
	
}
