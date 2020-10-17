package melindas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MelindaSWUppg10UI implements ActionListener {
	
	JFrame jf = 	   new JFrame();
	JPanel mainPanel = new JPanel();
	
//	Paneler som ska innehålla rullgardinsmenyer, knapp och resultatpanelen. 
	JPanel travelFromAndToZones = 			  new JPanel();
	JPanel dateAndTimeForDepartureSelection = new JPanel();
	JPanel flightDurationSelection =   		  new JPanel();
	JPanel buttonPanel =       				  new JPanel();
	JPanel resultPanel =       				  new JPanel();
	
//	Knapp som ska kopplas till en actionlistener som räknar ut resultatet. 
	JButton theBtn =           new JButton("Calculate arrival");
	
//	Labels med textinformation
	JLabel travelFromLbl =     new JLabel("Travel from: ");
	JLabel travelToLbl =       new JLabel("Travel to: ");
	
	JLabel departure =         new JLabel("Departure date and time: ");
	JLabel yearLbl =           new JLabel("Year ");
	JLabel monthLbl =          new JLabel("Month ");
	JLabel dayLbl = 		   new JLabel("Day ");
	JLabel hourLbl = 		   new JLabel("Hr ");
	JLabel minLbl = 		   new JLabel("Min ");
	JLabel hourLbl2 = 		   new JLabel("Hr ");
	JLabel minLbl2 = 		   new JLabel("Min ");
	
	JLabel flightDurationLbl = new JLabel("Flight duration: ");
	JLabel resultLbl =		   new JLabel();
	
	
//	JComboBox med avgångs och ankomstzoner
	JComboBox<String> departureFromZoneSelect = new JComboBox<>();
	JComboBox<String> travelToZoneSelect = 	 	new JComboBox<>();
//	Avgångsdatum
	JComboBox<Integer> yearSelect = 			new JComboBox<>();
	JComboBox<Integer> monthSelect = 			new JComboBox<>();
	JComboBox<Integer> daySelect = 				new JComboBox<>();
//	Avgångstid
	JComboBox<Integer> depHourSelect = 			new JComboBox<>();
	JComboBox<Integer> depMinSelect = 			new JComboBox<>();
//	Flygtid
	JComboBox<Integer> hourSelect = 			new JComboBox<>();
	JComboBox<Integer> minuteSelect = 			new JComboBox<>();

	
	
	public MelindaSWUppg10UI() {
		
//		jf.setLayout(new GridLayout(''));
		mainPanel.setLayout(new GridLayout(5,1));
		
		fillComboBoxes();
		
//		Ställer in rullgardinsmenyerna så att bara 10 rader visas åt gången.
		yearSelect.setMaximumRowCount(10);
		monthSelect.setMaximumRowCount(10);
		daySelect.setMaximumRowCount(10);
		depHourSelect.setMaximumRowCount(10);
		depMinSelect.setMaximumRowCount(10);
		hourSelect.setMaximumRowCount(10);
		minuteSelect.setMaximumRowCount(10);
				
		dateAndTimeForDepartureSelection.add(departureFromZoneSelect);
		flightDurationSelection.add(travelToZoneSelect);
		
		
//		Lägg till zonvalen i den zonvalspanelen.
		travelFromAndToZones.add(travelFromLbl);
		travelFromAndToZones.add(departureFromZoneSelect);
		
		travelFromAndToZones.add(travelToLbl);
		travelFromAndToZones.add(travelToZoneSelect);
		
//		Lägg till rullgardinsmenyer och text i avgångstids/datumpanelen
		dateAndTimeForDepartureSelection.add(departure);
				
		dateAndTimeForDepartureSelection.add(yearLbl);
		dateAndTimeForDepartureSelection.add(yearSelect);
		
		dateAndTimeForDepartureSelection.add(monthLbl);
		dateAndTimeForDepartureSelection.add(monthSelect);
		
		dateAndTimeForDepartureSelection.add(dayLbl);
		dateAndTimeForDepartureSelection.add(daySelect);
		
		dateAndTimeForDepartureSelection.add(hourLbl);
		dateAndTimeForDepartureSelection.add(depHourSelect);
		
		dateAndTimeForDepartureSelection.add(minLbl);
		dateAndTimeForDepartureSelection.add(depMinSelect);
		
//		Lägg till rullgardinsmenyer och text i flygtidsinfopanelen
		flightDurationSelection.add(flightDurationLbl);
				
		flightDurationSelection.add(hourLbl2);
		flightDurationSelection.add(hourSelect);
		
		flightDurationSelection.add(minLbl2);		
		flightDurationSelection.add(minuteSelect);
		
//		Lägg till knappen i knappanelen.
		buttonPanel.add(theBtn);
		
//		Lägg till resultatlabeln i resultatpanelen.
		resultLbl.setBackground(Color.DARK_GRAY);
		resultLbl.setForeground(Color.WHITE);
		resultLbl.setOpaque(true);
		resultPanel.add(resultLbl);
		
//		Sätt storlek på panelerna
		Dimension panelDimension = new Dimension(800, 50);

		flightDurationSelection.setPreferredSize(panelDimension);
		dateAndTimeForDepartureSelection.setPreferredSize(panelDimension);
		buttonPanel.setPreferredSize(panelDimension);
		resultPanel.setPreferredSize(panelDimension);

//		Lägg till actionlistener till knappen. 
		theBtn.addActionListener(this);

		
//		Lägg till panelerna i mainPanel
		mainPanel.add(travelFromAndToZones);
		mainPanel.add(dateAndTimeForDepartureSelection);
		mainPanel.add(flightDurationSelection);
		mainPanel.add(buttonPanel);
		mainPanel.add(resultPanel);
		
		mainPanel.setSize(800, 600);
		
//		Lägg till mainPanel i ramen
		jf.add(mainPanel);
		
//		Inställningar för ramen 
		jf.setTitle("ArrivalCalculator");
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.pack();
		jf.setVisible(true);
		
	}

	
	
	private void fillComboBoxes() {
		
		
//		Lägg till förvalda värden:
		departureFromZoneSelect.addItem("America/Los_Angeles");
		travelToZoneSelect.addItem("Asia/Shanghai");
		yearSelect.addItem(2017);
		monthSelect.addItem(3);
		daySelect.addItem(21);
		
		depHourSelect.addItem(13);
		depMinSelect.addItem(20);

		hourSelect.addItem(11);
		minuteSelect.addItem(30);
		
		
		
//		Arrive and departure zones.
		departureFromZoneSelect.addItem("---");
		ZoneId.getAvailableZoneIds().stream()
									.sorted()
									.forEach(s -> departureFromZoneSelect.addItem(s));
		travelToZoneSelect.addItem("---");
		ZoneId.getAvailableZoneIds().stream()
									.sorted()
									.forEach(s -> travelToZoneSelect.addItem(s));
		
//		Years
		int currentYear = LocalDate.now().getYear();
		
		for (int i = currentYear; i >= 1970; i -= 1) {
			yearSelect.addItem(i);
		}
		
//		Months
		
		for (int i = 1; i <= 12; i += 1) {
			monthSelect.addItem(i);
		}
		
//		days
		
		for (int i = 1; i <= 31; i += 1) {
			daySelect.addItem(i);
		}
		
//		hours
		
		for (int i = 0; i <= 24; i += 1) {
			depHourSelect.addItem(i);
			hourSelect.addItem(i);
			
		}
		
//		minutes
		
		for (int i = 0; i <= 60; i += 1) {
			depMinSelect.addItem(i);
			minuteSelect.addItem(i);
		}
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

//		Skapa en instans av kalkylatorn med parametrarna som hämtas från boxarna. Anropa metoden som returnerar uträkningen.
//		Lägg till resultatet i resultatlabeln.
	
		String depZone = (String) departureFromZoneSelect.getSelectedItem(); 
		String toZone = (String) travelToZoneSelect.getSelectedItem(); 
		
		int depYear = (int) yearSelect.getSelectedItem();
		int depMonth = (int) monthSelect.getSelectedItem();
		int depDay = (int) daySelect.getSelectedItem();
		int depHr = (int) depHourSelect.getSelectedItem();
		int depMin = (int) depMinSelect.getSelectedItem();
		int travelHr = (int) hourSelect.getSelectedItem();
		int travelMin = (int) minuteSelect.getSelectedItem();

		MelindaSWUppg10FlightArrivalTimeCalculator c = new MelindaSWUppg10FlightArrivalTimeCalculator(depZone, 
																									toZone, 
																									depYear, 
																									depMonth, 
																									depDay, 
																									depHr, 
																									depMin, 
																									travelHr, 
																									travelMin);
		
		try {
			resultLbl.setBackground(Color.DARK_GRAY);
			resultLbl.setText("Estimated arrival in " + toZone + " (local time):   " + c.getEstimatedArrival());
		} catch (DateTimeException d) {
			resultLbl.setBackground(Color.RED);
			resultLbl.setText("ERROR, DATE DOES NOT EXIST");
		}
		
	}
	

}
























