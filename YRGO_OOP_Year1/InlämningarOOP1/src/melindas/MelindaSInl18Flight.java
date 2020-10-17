package melindas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MelindaSInl18Flight extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private String no, destination, comment = "";
	private MelindaSInl18Tidpunkt dep, arr; 
	private JLabel numL, desL, depL, arrL, comL = new JLabel(comment);
	
//	Konstruktor. Tar emot information om flighten och lägger till i labels 
//	som läggs till i en panel med 1 rad och 4 kolumner.
	public MelindaSInl18Flight(String flightNo, String dest,
								   int depHour, int depMin, 
								   int arrHour, int arrMin) {		
		no = flightNo;
		destination = dest;
		dep = new MelindaSInl18Tidpunkt(depHour, depMin);
		arr = new MelindaSInl18Tidpunkt(arrHour, arrMin);
		
		numL = new JLabel(no);
		desL = new JLabel(dest);
		depL = new JLabel(dep.toString());
		arrL = new JLabel(arr.toString());
		
		setLayout(new GridLayout(1, 4));
		add(numL); add(desL); add(depL); add(arrL); add(comL);
		
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setPreferredSize(new Dimension(500, 25));
		
	}
	
	public void setComment(String com) {
		comment = com;
		comL.setText(comment);
		repaint();
	}
//	Sätter förgrundsfärg och font. Om komponenten inte har någon färg/font så sätts färgen/fonten som dess "förälder" har. 
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		numL.setForeground(getForeground());
		desL.setForeground(getForeground());
		depL.setForeground(getForeground());
		comL.setForeground(getForeground());
		arrL.setForeground(getForeground());
		numL.setFont(getFont());
		desL.setFont(getFont());
		depL.setFont(getFont());
		comL.setFont(getFont());
		arrL.setFont(getFont());
	}

	public String getNumber() {
		return no;
	}
	
	public String getDestination() {
		return destination;
	}
//	Hämtar tid i formatet som tidpunktsklassen returnerar. 
	public MelindaSInl18Tidpunkt getDep() {
		return new MelindaSInl18Tidpunkt(dep.avläsTim(), dep.avläsMin());
	}
	
	public MelindaSInl18Tidpunkt getArr() {
		return new MelindaSInl18Tidpunkt(arr.avläsTim(), arr.avläsMin());
	}
//	Om en flight är försenad så läggs en kommentar in i kommentarslabeln.
	public void delay(int min) {
		dep.ticka(min * 60);
		arr.ticka(min * 60);
		setComment("Delayed");
	}

}





























