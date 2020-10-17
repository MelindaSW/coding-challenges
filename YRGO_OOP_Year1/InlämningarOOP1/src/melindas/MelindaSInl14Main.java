package melindas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;
//	Enum med romerska nummer och dess värden i decimaltal.
enum Rom {
	I (1.0),
	V (5.0), 
	X (10.0), 
	L (50.0), 
	C (100.0), 
	D (500.0), 
	M (1000.0);
	
	private final double value;

	private Rom(double value) {
		this.value = value;
	}
	
	public double getValue() {
		return this.value;
	}
}

public class MelindaSInl14Main {
	
	public static void main(String[] args) {
// 		Hämtar input. Ett romerskt tal eller ett decimaltal.
//		Anropar klassen som testar om det är ett romerskt eller decimaltal. 		
		DecimalOrRoman dOr = new DecimalOrRoman();
		Scanner scanner = new Scanner(System.in);
		String input = "";
			
		input = JOptionPane.showInputDialog(null, "Ange ett tal, romerskt eller decimal:");
		dOr.isItRomanOrDec(input);
		scanner.close();
	}

}

class DecimalOrRoman {
	
	static List<Rom> I, V, X, L, C, D, M, romEnums;
		
	RomanToDecimal rToD = new RomanToDecimal(); 
	DecimalToRoman dToR = new DecimalToRoman();

//	Testar om det går att konvertera till double. Om inte, så är det en string. 
//	Om det är en string, anropas metoden som kollar att inputen är korrekt. 
//	Om det är ett decimaltal, anropas klassen som konverterar till romerska numeraler. 
	public void isItRomanOrDec(String input) {
		
		try {
			if (input.equals("0") || input.equals("0.0") || input.equals("0,0")) {
				JOptionPane.showMessageDialog(null, "Talet " + input + " går inte att konvertera till det det romerska talsystemet.");
				System.exit(0);
			}
				double dec = Double.parseDouble(input);
				dToR.convertToRoman(dec);
		}
		catch (NumberFormatException e) {
			isRomanInputCorrect(input);
		}
		catch (NullPointerException f) {
			System.exit(0);
		}

	}
//	Testar om inmatningen av det romerska talet är korrekt. 
	public void isRomanInputCorrect(String input) {
		
		try {
			RomanToDecimal romanToDecimal = new RomanToDecimal();
			I = new ArrayList<>();
			V = new ArrayList<>();
			X = new ArrayList<>();
			L = new ArrayList<>();
			C = new ArrayList<>();
			D = new ArrayList<>();
			romEnums = new ArrayList<>();
			
// 			Ändrar inputen till uppercase ifall att något värde råkar vara lowercase. 
			input = input.toUpperCase();
			char[] romans = input.toCharArray();
			int isNumeralWrong = 0;
	
//			Kontroll av eventuella ogiltiga värden och att reglerna följs när det gäller antal tecken i rad.
			for (int i = 0; i < romans.length; i++) {
				switch (romans[i]) {
				case 'I' : romEnums.add(Rom.I); break;
				case 'V' : romEnums.add(Rom.V); break;
				case 'X' : romEnums.add(Rom.X); break;
				case 'L' : romEnums.add(Rom.L); break;
				case 'C' : romEnums.add(Rom.C); break;
				case 'D' : romEnums.add(Rom.D); break;
				case 'M' : romEnums.add(Rom.M); break;
				default  : isNumeralWrong += 1; break;
				}
			}
	
			if (isNumeralWrong > 0) {
				JOptionPane.showMessageDialog(null, "Inputen innehåller värden som inte går att konvertera.");
				System.exit(0);
			}
	
			int x = 1;
			for (int i = 0; i < romEnums.size() - 1; i++) {
				if (romEnums.get(i).equals(romEnums.get(x))) {
					switch (romEnums.get(i)) {
					case I : I.add(romEnums.get(x)); break;
					case V : V.add(romEnums.get(x)); break;
					case X : X.add(romEnums.get(x)); break;
					case L : L.add(romEnums.get(x)); break;
					case C : C.add(romEnums.get(x)); break;
					case D : D.add(romEnums.get(x)); break;	
					case M : break;
					}
				}
				x++;
			}
	
			if (I.size() > 3 || V.size() > 0 || X.size() > 2 || L.size() > 0 || C.size() > 2 || D.size() > 0) {
				JOptionPane.showMessageDialog(null, "Det romerska talet har ett ogitigt antal lika tecken i rad.");
				System.exit(0);
				}
			
//			Kontroll av att värdet som står före ett annat inte är mindre än en tiondel av det som kommer efter. 
			for (int i = 0; i < romEnums.size() - 1; i++) {
				if (romEnums.get(i).getValue() < (romEnums.get(i+1).getValue() / 10)) {
					JOptionPane.showMessageDialog(null, "Ett eller flera värden har placerats före ett för stort värde.");
					System.exit(0);
				}
			}
//			Om allt ovan stämmer så anropas klassen som konverterar till decimaltal. 
			romanToDecimal.convertToDecimal(romEnums);
		}
		catch (ArrayIndexOutOfBoundsException g) {
			System.exit(0);
		}
	}
	
}

// Konverteringsklass för romerska numeraler till decimaltal.
class RomanToDecimal {
	
	public void convertToDecimal(List<Rom> romEnums) {
		double decimal = 0.0;
		
		if (romEnums.size() == 1) {
			decimal = romEnums.get(0).getValue();
		}
			else {
				for(int i = 0; i < romEnums.size() -1; i++) {
		
					if (romEnums.get(i).getValue() < romEnums.get(i+1).getValue()) {
						decimal -= romEnums.get(i).getValue();
					}
					else if (romEnums.get(i).getValue() > romEnums.get(i+1).getValue()) {
						decimal += romEnums.get(i).getValue();
					}
					else if (romEnums.get(i).getValue() == romEnums.get(i+1).getValue()) {
						decimal += romEnums.get(i).getValue();
					}
				}
					if (romEnums.get(romEnums.size()-2).getValue() == romEnums.get(romEnums.size()-1).getValue()) {
						decimal += romEnums.get(romEnums.size()-1).getValue();
					}
					else if (romEnums.get(romEnums.size()-1).getValue() < romEnums.get(romEnums.size()-2).getValue()) {
						decimal += romEnums.get(romEnums.size()-1).getValue();
					}
					else if (romEnums.get(romEnums.size()-1).getValue() > romEnums.get(romEnums.size()-2).getValue()) {
						decimal += romEnums.get(romEnums.size()-1).getValue();
					}			
		}
		String romEnumsToString = "";
		for (Rom n : romEnums) {
			romEnumsToString = romEnumsToString + n.toString();
		}
		JOptionPane.showMessageDialog(null, romEnumsToString  + "  =  " + decimal);
		System.exit(0);

	}
}

// Konverteringsklass för decimaltal till romerska tal.
class DecimalToRoman {
	
	static String toRoman = "";
	public void convertToRoman(double decimal) {

		Integer toConvert = (int) Math.round(decimal);
		String convert = toConvert.toString();
		
		switch (convert.length()) {
		case 1 : singulars(convert.charAt(0)); 
				 break;
				 
		case 2 : tens(convert.charAt(0)); 
				 singulars(convert.charAt(1)); 
				 break;
				 
		case 3 : hundreds(convert.charAt(0)); 
				 tens(convert.charAt(1)); 
				 singulars(convert.charAt(2));
				 break;
				 
		case 4 : thousands(convert.charAt(0)); 
				 hundreds(convert.charAt(1)); 
		 		 tens(convert.charAt(2)); 
		 		 singulars(convert.charAt(3));
		 		 break;
		 		 
		case 5 : tenThousands(convert.charAt(0));
				 thousands(convert.charAt(1));
			     hundreds(convert.charAt(2)); 
		 		 tens(convert.charAt(3)); 
		 		 singulars(convert.charAt(4));
		 		 break;
		}
		
		double result = (double) toConvert;
		JOptionPane.showMessageDialog(null, result + "  =  " + toRoman);
		System.exit(0);

	}
	private static void singulars(char s) { 
		switch (s) {
		case '0' : break;
		case '1' : toRoman = toRoman + Rom.I; break;
		case '2' : toRoman = toRoman + Rom.I + Rom.I; break;
		case '3' : toRoman = toRoman + Rom.I + Rom.I + Rom.I; break;
		case '4' : toRoman = toRoman + Rom.I + Rom.V; break;
		case '5' : toRoman = toRoman + Rom.V; break;
		case '6' : toRoman = toRoman + Rom.V + Rom.I; break;
		case '7' : toRoman = toRoman + Rom.V + Rom.I + Rom.I; break;
		case '8' : toRoman = toRoman + Rom.V + Rom.I + Rom.I + Rom.I; break;
		case '9' : toRoman = toRoman + Rom.I + Rom.X; break;
		}
	}
	
	private static void tens(char t) {
		switch (t) {
		case '0' : break;
		case '1' : toRoman = toRoman + Rom.X; break;
		case '2' : toRoman = toRoman + Rom.X + Rom.X; break;
		case '3' : toRoman = toRoman + Rom.X + Rom.X + Rom.X; break;
		case '4' : toRoman = toRoman + Rom.X + Rom.L; break;
		case '5' : toRoman = toRoman + Rom.L; break;
		case '6' : toRoman = toRoman + Rom.L + Rom.X; break;
		case '7' : toRoman = toRoman + Rom.L + Rom.X + Rom.X; break;
		case '8' : toRoman = toRoman + Rom.L + Rom.X + Rom.X + Rom.X; break;
		case '9' : toRoman = toRoman + Rom.X + Rom.C; break;
		}
		
	}
	
	private static void hundreds(char h) {
		switch (h) {
		case '0' : break;
		case '1' : toRoman = toRoman + Rom.C; break;
		case '2' : toRoman = toRoman + Rom.C + Rom.C; break;
		case '3' : toRoman = toRoman + Rom.C + Rom.C + Rom.C; break;
		case '4' : toRoman = toRoman + Rom.C + Rom.D; break;
		case '5' : toRoman = toRoman + Rom.D; break;
		case '6' : toRoman = toRoman + Rom.D + Rom.C; break;
		case '7' : toRoman = toRoman + Rom.D + Rom.C + Rom.C; break;
		case '8' : toRoman = toRoman + Rom.D + Rom.C + Rom.C + Rom.C; break;
		case '9' : toRoman = toRoman + Rom.C + Rom.M; break;
		}
	}
	
	private static void thousands(char t)	{
		int y = Character.getNumericValue(t);
		if (y == 0) {
			toRoman = toRoman + "";
		}
		else {
			for (int i = 0; i < y; i++) {
				toRoman = toRoman + Rom.M;
			}
		}
	}
	
	private static void tenThousands(char tt) {
		int y = Character.getNumericValue(tt) * 10;
		for (int i = 0; i < y; i++) {
			toRoman = toRoman + Rom.M;
		}
	}
	
}
	
