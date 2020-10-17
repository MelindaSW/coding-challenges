package melindas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MelindaSInl19PhotoAlbumPanel implements ActionListener{
	
	JPanel albumPanel = new JPanel(new BorderLayout());
	JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	
	JLabel pictureCounter = new JLabel();
	JLabel photos = new JLabel();
	
	JButton nextButton = new JButton("Nästa bild");
	JButton prevButton = new JButton("Föregående bild");
	
	int picCount = 1;
	
	private String imgSrc;

	
	
	public MelindaSInl19PhotoAlbumPanel() {
//		Skapar en ruta med en bildvisningsfunktion. 
		
//		Bilderna är sparade med en siffra i slutet. Variabeln picCount börjar på värdet 1. 
//		Bilderna hämtas och croppas i metoden getAndScaleImage.
		photos.setIcon(getAndScaleImage("wedding" + picCount + ".jpg", -1, 750));
		photos.setHorizontalAlignment(JLabel.CENTER);
//		Överst i rutan finns en label med information om vilket nummer det är på bilden som visas.
		pictureCounter.setText("Mitt fotoalbum bild nr: " + picCount);
		pictureCounter.setHorizontalAlignment(JLabel.CENTER);
		
//		Knappar som bestämmer om nästa eller föregående bild ska visas. 
		nextButton.setHorizontalAlignment(JButton.CENTER);
		nextButton.addActionListener(this);
		
		prevButton.setHorizontalAlignment(JButton.CENTER);
		prevButton.addActionListener(this);
		
//		Knapparna läggs till i knappPanelen
		buttonPanel.add(prevButton);
		buttonPanel.add(nextButton);
		
//		Alla komponenter placeras slutligen i huvudpanelen. 
		albumPanel.add(pictureCounter, BorderLayout.NORTH);
		albumPanel.add(photos, BorderLayout.CENTER);
		albumPanel.add(buttonPanel, BorderLayout.SOUTH);
		
	}
	
	
	public Component getFotoalbum() {
		return albumPanel;
	}

	
	public ImageIcon getAndScaleImage(String image, int h, int w) {
//		Metod som hämtar bilder och ger dem det angivna värdet i höjd och bredd. 
//		Returnerar en ImageIcon.
		
		ImageIcon icon = new ImageIcon(getClass().getResource(image));
		Image im = icon.getImage();
		im = im.getScaledInstance(w, h, Image.SCALE_DEFAULT);
		icon.setImage(im);
		
		return icon;
	}

	@Override
	public void actionPerformed(ActionEvent a) {
//		Här bestäms vilka bilder som ska visas när nästa eller föregående - knapparna trycks in.
//		Variabeln picCount ökas eller minskas. Om det blir över det maximala värdet på bilderna hittas 
//		ingen bild. Då börjar visningen om från början. Likaså om värdet blir under 0. Då sätts värdet till 
//		att den sista bilden visas istället. 
		if (a.getSource() == nextButton) {
			
			picCount += 1;
			
			try {
			photos.setIcon(getAndScaleImage("wedding" + picCount + ".jpg", -1, 750));
			pictureCounter.setText("Mitt fotoalbum bild nr: " + picCount);
			}
			catch (NullPointerException e) {
				picCount = 1;
				photos.setIcon(getAndScaleImage("wedding" + picCount + ".jpg", -1, 750));
				pictureCounter.setText("Mitt fotoalbum bild nr: " + picCount);
			}

		}
		
		else if (a.getSource() == prevButton) {
			
			picCount -= 1;
			
			try {
			photos.setIcon(getAndScaleImage("wedding" + picCount + ".jpg", -1, 750));
			pictureCounter.setText("Mitt fotoalbum bild nr: " + picCount);
			}
			catch (NullPointerException e) {
				
				picCount = 4;
				photos.setIcon(getAndScaleImage("wedding" + picCount + ".jpg", -1, 750));
				pictureCounter.setText("Mitt fotoalbum bild nr: " + picCount);

			}
		}
	}
}
