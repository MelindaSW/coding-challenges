package melindas;

public class MelindaSInl7BMain {

	public static void main(String[] args) {
		
//		Koden skapar först en referens till objekt, klassen MelindaSInl7BLocalDate. 
//		setCountry och setLanguage skickar värden till variablerna i klassen. 
//		returnDate metoden formaterar utskriften och returnerar dagens datum, i formatet för lands och språkkoderna. 
		
		MelindaSInl7BLocalDate localDate = new MelindaSInl7BLocalDate();
		
		localDate.setLanguage("en");
		localDate.setCountry("UK");
		localDate.returnDate();
		
		localDate.setLanguage("fr");
		localDate.setCountry("FR");
		localDate.returnDate();
		
		localDate.setLanguage("de");
		localDate.setCountry("DE");
		localDate.returnDate();
	}

}