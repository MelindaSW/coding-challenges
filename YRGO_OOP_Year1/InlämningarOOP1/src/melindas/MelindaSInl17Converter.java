package melindas;

public class MelindaSInl17Converter {
	
//	Klass som konverterar grader till celsius eller fahrenheit. Returnerar en double. 

	double y;
	
	public double convertToFahrenheit(String c) {
//		Räknar ut fahrenheit. Returnerar en double avrundat till en decimal.
		y = Double.parseDouble(c);
		return Math.round(((y * 9/5) + 32) * 10.0) / 10.0;
	}
	
	public double convertToCelsius(String f) {
// 		Räknar ut celsius. Returnerar en double avrundat till en decimal.
		y = Double.parseDouble(f);
		return Math.round(((y - 32) * 5 / 9) * 10.0) / 10.0;
	}

// Kolla om värdet som matas in är korrekt. 
	public boolean isInputCorrect(String toConvert) {
		try {
			y = Double.parseDouble(toConvert);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}
}
