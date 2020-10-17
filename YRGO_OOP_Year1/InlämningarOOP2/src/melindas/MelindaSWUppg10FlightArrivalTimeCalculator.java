package melindas;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class MelindaSWUppg10FlightArrivalTimeCalculator {

	/*
	 * Du flyger form Los Angeles till Shanghai den 21 mars 2017 kl 13:20 lokal tid.
	 * Skriv ett program som tar hänsyn till att du passerar datumlinjen och eventuell sommartid 
	 * och som beräknar ankomsttiden i loka Datum/tid (Shanghai).
	 * Flygtiden är 11 tim och 30 min. Använd klasserna i java.time inte java.util.
	 */
	
	private String departureZone;
	private String arrivalZone;
	
	private int year;
	private int month;
	private int day;
	
	private int depHour;
	private int depMin;
	
	private int flightHours;
	private int flightMinutes;


	public MelindaSWUppg10FlightArrivalTimeCalculator() {}
	
	
	public MelindaSWUppg10FlightArrivalTimeCalculator( String departureZone, 
														String arrivalZone, 
														int year, 
														int month, 
														int day, 
														int depHour, 
														int depMin, 
														int flightHours, 
														int flightMinutes ) {
		this.departureZone = departureZone;
		this.arrivalZone = arrivalZone;
		this.year = year;
		this.month = month;
		this.day = day;
		this.depHour = depHour;
		this.depMin = depMin;
		this.flightHours = flightHours;
		this.flightMinutes = flightMinutes;
		
	}

	public String getDepartureZone() {
		return departureZone;
	}

	public String getArrivalZone() {
		return arrivalZone;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getDepHour() {
		return depHour;
	}

	public int getDepMin() {
		return depMin;
	}

	public int getFlightHours() {
		return flightHours;
	}

	public int getFlightMinutes() {
		return flightMinutes;
	}
	
	public String getEstimatedArrival() throws DateTimeException {
		if (getDepartureZone().equals(getArrivalZone())) {
			return "ERROR, ZONES ARE THE SAME";
		}
		return calculateArrival();
	}
	
	private String calculateArrival() throws DateTimeException {
		
/*		
* 		Räkna ut ankomsttiden i den aktuella tidszonen.
*		Returnera en formaterad sträng med det nya datumet. 
*		
*		Skapa en LocalDateTime utifrån informationen som ges som argument till konstruktorn. 
*/		
		
		LocalDateTime departureLocalDateTime = LocalDateTime.of(getYear(), 
													  getMonth(), 
													  getDay(), 
													  getDepHour(), 
													  getDepMin());

		
//		Skapa en ZonedDateTime utifrån LocalDateTime med ZoneId som ska vara från avgångszonen.
		
		ZonedDateTime departureZonedDateTime = departureLocalDateTime.atZone(ZoneId.of( getDepartureZone() ));
		
/*		Skapa till sist en ZonedDateTime som ger tid och datum för ankomst lokal tid, baserat på vilken zon man landar i.
*		Om man utgår från departureSonedDateTime och använder metoden withZoneSameInstant(ZoneId) så returneras den avgångstiden 
*		till samma tid men med justerad offset. 
*		DST uträkningen ska vara inkluderad(?)
*		 
*		Slutligen läggs flygtiden till med plusHours() och plusMinutes()
*/		 
		
		ZonedDateTime arrivalZonedDateTime = departureZonedDateTime.withZoneSameInstant(ZoneId.of( getArrivalZone() ))
																						.plusHours( flightHours )
																						.plusMinutes( flightMinutes );
	
		
		return arrivalZonedDateTime.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
		
	}

	
}




























