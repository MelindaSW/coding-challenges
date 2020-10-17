package melindas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MelindaSWUppg4FlightBoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private String flightNo, destination, comment ="";
	private MelindaSWUppg4Tidpunkt  dep;
	private JLabel numL, desL, depL, comL = new JLabel(comment);
	
	
//	Flightboardklass med konstruktor som tar emot parametrar med data som ska fylla tavlan. 
	
	public MelindaSWUppg4FlightBoardPanel(String flightNo, String destination, int depHour, int depMin) {
		
		this.flightNo = flightNo;
		this.destination = destination;
		dep = new MelindaSWUppg4Tidpunkt(depHour, depMin);
		numL = new JLabel(flightNo);
		desL = new JLabel(destination);
		depL = new JLabel(dep.toString());
		
//		Panelernas layout. 1 rad, 4 kolumner
		setLayout(new GridLayout(1, 4)); 
		
//		Lägg till labels i panelen
		add(numL);
		add(desL);
		add(depL);
		add(comL);
		
//		Panelernas storlek		
		setPreferredSize(new Dimension(400, 25));
		
//		Panelernas färg, vit bakgrund, svart text.
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		
	}
	
	
	public void setComment(String comment) {
		this.comment = comment;
		comL.setText(comment);
		repaint();
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		numL.setForeground(getForeground());
		desL.setForeground(getForeground());
		depL.setForeground(getForeground());
		comL.setForeground(getForeground());
		numL.setForeground(getForeground());
		numL.setFont(getFont());
		desL.setFont(getFont());
		depL.setFont(getFont());
		comL.setFont(getFont());
		
	}
	
	public String getNumber() {
		return flightNo;
	}
	
	public String getDestination() {
		return destination;
	}
	
//	Hämtar tid i formatet som tidpunktsklassen returnerar. 
	public MelindaSWUppg4Tidpunkt getDep() {
		return new MelindaSWUppg4Tidpunkt(dep.avläsTim(), dep.avläsMin());
	}
	
//	Om en flight är försenad så läggs en kommentar in i kommentarslabeln.
	public void delay(int min) {
		dep.ticka(min * 60);
		setComment("Delayed");
	}
	
	
}
























