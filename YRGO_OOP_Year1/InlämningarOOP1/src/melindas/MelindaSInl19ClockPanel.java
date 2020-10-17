package melindas;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.Timer;

public class MelindaSInl19ClockPanel implements ActionListener{
//	Skapar panelen som bilden och tiden ska visas på.
	private JPanel clockPanel = new JPanel();
//	En instans till en timer skapar ett objekt som kan anropa en händelse 
//	upprepade gånger enligt specifierad tid. 
	private Timer time;
//	Den här fonten används i texten.
	private Font font = new Font("SansSerif", Font.BOLD, 25);
//	Formaterar tid och datum enligt angivna patterns. Stora H betyder 24 timmars klocka. 
	private DateTimeFormatter t = DateTimeFormatter.ofPattern("HH:mm:ss");
	private DateTimeFormatter d = DateTimeFormatter.ofPattern("EEE MMM dd");
	
	LocalTime locTime = LocalTime.now();
	LocalDate locDate = LocalDate.now();
	
	String dateAndTime = locDate.format(d) + " | " + locTime.format(t);
	
	JLabel text = new JLabel(dateAndTime);
	JLabel watchLbl;
//	En overlaylayout gör det möjligt att placera komponenter ovanpå varandra. 
	LayoutManager overlay = new OverlayLayout(clockPanel);
	
	public MelindaSInl19ClockPanel() {
		
//		Fyller en panel med en bild och ett timerobjekt som visar datum och en klocka som räknar upp i nutid.  

//		huvudpanelen får en overlay layout. Samt vit bakgrund för att inte bildens kanter ska synas. 
		clockPanel.setLayout(overlay);
		clockPanel.setBackground(Color.WHITE);
		
//		Texten får vit färg och den specifierade fonten. setAlignment placerar den i mitten av rutan. 
		text.setForeground(Color.WHITE);
		text.setFont(font);
		text.setAlignmentX(0.5f);
		text.setAlignmentY(0.5f);
//		textLabeln läggs in överst i panelen. 
		clockPanel.add(text);
//		Bilden på klockan hämtas och får en alignment så att den hamnar mitt i panelen.
		watchLbl = new JLabel(new ImageIcon(getClass().getResource("digital_watch.jpg")));
		watchLbl.setAlignmentX(0.5f);
		watchLbl.setAlignmentY(0.5f);
//		klocklabeln läggs till underst i panelen. 
		clockPanel.add(watchLbl);
//		Timerobjektet startas. Händelsena i actionPerformed upprepas varje sekund. 
		time = new Timer(1000, this);
		time.start();
	}
	
	public JPanel getClockPanel() {
		return clockPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		Så länge som programmet körs utförs detta varje sekund. Tiden och datumet uppdateras varje sekund. 
		locDate = LocalDate.now();
		locTime = LocalTime.now();
		dateAndTime = locDate.format(d) + " | " + locTime.format(t);
		text.setText(dateAndTime);
	}
}

