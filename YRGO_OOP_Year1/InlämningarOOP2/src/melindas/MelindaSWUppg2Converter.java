package melindas;

public class MelindaSWUppg2Converter {

	
	public MelindaSWUppg2Converter() {}
	
	public String evaluateAndConvert(String out) {
		
		try {
			
			double v = Double.parseDouble(out);
			String res = out + "C = " + convertCelsiusToFahrenheit(v) + "F";
			return res; 
			
		} catch (NumberFormatException e ) {
			
			return "Kunde inte konvertera inmatningen.";
			
		}
		
	}

	private double convertCelsiusToFahrenheit(double value) {
//		Räknar ut fahrenheit. Returnerar en double avrundat till en decimal.
		return Math.round(((value * 9/5) + 32) * 10.0) / 10.0;
		
	}
	
	
	
}
