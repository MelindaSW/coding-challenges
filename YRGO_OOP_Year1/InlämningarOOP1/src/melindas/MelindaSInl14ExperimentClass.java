package melindas;

import java.util.ArrayList;
import java.util.List;

public class MelindaSInl14ExperimentClass {

	static List<Rom> I, V, X, L, C, D, M, romEnums;
	static String toRoman = "";

	public static void main(String[] args) {

		I = new ArrayList<>();
		V = new ArrayList<>();
		X = new ArrayList<>();
		L = new ArrayList<>();
		C = new ArrayList<>();
		D = new ArrayList<>();
		romEnums = new ArrayList<>();

		String r = "mmdccxlvii";
		r = r.toUpperCase();
		char[] romans = r.toCharArray();
		int isNumeralWrong = 0;
		
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
			System.out.println("Ett eller flera av bokstäverna är inte en giltig romersk numeral.");
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

		if (I.size() > 2 || V.size() > 0 || X.size() > 2 || L.size() > 0 || C.size() > 2 || D.size() > 0) {
			System.out.println("Ogitigt antal tecken i rad i det romerska talet.");
		}

		// Kolla om ett nummer som är mindre än en tiondel än det större talet står
		// framför något större tal.
		for (int i = 0; i < romEnums.size() - 1; i++) {
			if (romEnums.get(i).getValue() < (romEnums.get(i+1).getValue() / 10)) {
				System.out.println("Ett eller flera värden har placerats före ett för stort värde.");
				break;
			}
		}
		
		for (Rom ro : romEnums) {
			System.out.println(ro.getValue());
		}
		
		double decimal = 0;
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
			
		System.out.println("Romerskt nummer: " + romEnumsToString + "\nDecimaltal: " + decimal);
		 
//		Konvertera till romerska numeraler från decimal:
		
		double decimal2 = 2747.0;
		Integer toConvert = (int) Math.round(decimal2);
		String convert = toConvert.toString();
		System.out.println(convert);
		
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
		System.out.println(decimal2 + " = " + toRoman);
//		String convert = toConvert.toString().substring(0);
//		System.out.println("Integer storlek: " + s.length());	
		
	}
	
	private static void singulars(char s) { 
		switch (s) {
		case '0' : break;
		case '1' : toRoman = toRoman + "I"; break;
		case '2' : toRoman = toRoman + "II"; break;
		case '3' : toRoman = toRoman + "III"; break;
		case '4' : toRoman = toRoman + "IV"; break;
		case '5' : toRoman = toRoman + "V"; break;
		case '6' : toRoman = toRoman + "VI"; break;
		case '7' : toRoman = toRoman + "VII"; break;
		case '8' : toRoman = toRoman + "VIII"; break;
		case '9' : toRoman = toRoman + "IX"; break;
		}
	}
	
	private static void tens(char t) {
		switch (t) {
		case '0' : break;
		case '1' : toRoman = toRoman + "X"; break;
		case '2' : toRoman = toRoman + "XX"; break;
		case '3' : toRoman = toRoman + "XXX"; break;
		case '4' : toRoman = toRoman + "XL"; break;
		case '5' : toRoman = toRoman + "L"; break;
		case '6' : toRoman = toRoman + "LX"; break;
		case '7' : toRoman = toRoman + "LXX"; break;
		case '8' : toRoman = toRoman + "LXXX"; break;
		case '9' : toRoman = toRoman + "XC"; break;
		}

	}
	
	private static void hundreds(char h) {
		switch (h) {
		case '0' : break;
		case '1' : toRoman = toRoman + "C"; break;
		case '2' : toRoman = toRoman + "CC"; break;
		case '3' : toRoman = toRoman + "CCC"; break;
		case '4' : toRoman = toRoman + "CD"; break;
		case '5' : toRoman = toRoman + "D"; break;
		case '6' : toRoman = toRoman + "LC"; break;
		case '7' : toRoman = toRoman + "LCC"; break;
		case '8' : toRoman = toRoman + "LCCC"; break;
		case '9' : toRoman = toRoman + "CM"; break;
		}
	}
	
	private static void thousands(char t)	{
		int y = Character.getNumericValue(t);
		if (y == 0) {
			toRoman = toRoman + "";
		}
		else {
			for (int i = 0; i < y; i++) {
				toRoman = toRoman + "M";
			}
		}
	}
	
	private static void tenThousands(char tt) {
		int y = Character.getNumericValue(tt) * 10;
		for (int i = 0; i < y; i++) {
			toRoman = toRoman + "M";
		}
	}
}
		
		
		// Teori 1: lösning på test om antalet tecken i rad stämmer:
		// Gör om stringen till en char array.
		// Skapa instansarrayer char[] för varje tecken.
		// Iterera igenom. Kolla efter fler än ett tecken i rad.
		// Stoppa in rätt tecken i rätt array om det finns dubletter/tripletter mm.
		// Kolla storleken på arrayerna.
		// M får vara ett obestämt antal
		// V 5, L 50, och D 500 får bara stå en gång.
		// C, X, och I får inte stå fler än tre ggr i rad.
		// Om det finns en annan bokstav med än de korrekta romerska siffrorna måste ett
		// felmeddelande visas.

		// Att lösa: Problemet med räknereglerna. Efter koll om dubletter/tripletter
		// stämmer
		// Ett tal som är mindre än en tiondel får inte stå framför ett tal som är tio
		// ggr större än det talet.

		// Uträkning/konvertering till decimal:
		// Ett tal som är mindre än talet som kommer efter ska subtraheras från det
		// större.
		// Ett tal som är mindre än talet som kommer före ska adderas till talet/talen
		// som ligger före.

		// Konvertering till romerskt nr : ???
		// Parse till int?måste vi räkna ut decimaler också? finns de i romerska nummer?
//		
//		if (romans.get(i).equals(romans.get(x))) {
//			Göra om till switch?
//			if (romans.get(x).equals("I")) {
//				I.add(romans.get(0));
//			} 
//			else if (romans.get(x).equals("V")) {
//				V.add(romans.get(0));
//			} 
//			else if (romans.get(x).equals("X")) {
//				X.add(romans.get(x));
//			} 
//			else if (romans.get(x).equals("L")) {
//				L.add(romans.get(x));
//			} 
//			else if (romans.get(x).equals("C")) {
//				C.add(romans.get(x));
//			} 
//			else if (romans.get(x).equals("D")) {
//				D.add(romans.get(x));
//			} 
		
//		int y = 1;
//		for (int i = 0; i < r.length(); i++) {
//			romans.add(r.substring(i, y));
//			y++;
//		}
//		boolean isNrCorrect = true;
//		for (int i = 0; i < romans.size(); i++) {
//			if (!romans.get(i).equals("I") && !romans.get(i).equals("V") && !romans.get(i).equals("X")
//					&& !romans.get(i).equals("L") && !romans.get(i).equals("C") && !romans.get(i).equals("D")
//					&& !romans.get(i).equals("M")) {
//				isNrCorrect = false;
//			} 
//			else {
//				isNrCorrect = true;
//			}
//		}
//		List<Double> rom = new ArrayList<>();
//		
//		for (int i = 0; i < romans.size(); i++) {
//			switch (romans.get(i)) {
//			case "I" : rom.add(Rom.I.getValue()); break;
//			case "V" : rom.add(Rom.V.getValue()); break;
//			case "X" : rom.add(Rom.X.getValue()); break;
//			case "L" : rom.add(Rom.L.getValue()); break;
//			case "C" : rom.add(Rom.C.getValue()); break;
//			case "D" : rom.add(Rom.D.getValue()); break;
//			case "M" : rom.add(Rom.M.getValue()); break;
//			}
//		}
		
//		for (RomNrs rn : RomNrs.values()) {
//			for (int i = 0; i < romans.size(); i++) {
//				if (!rn.name().equals(romans.get(i))) {
//					isNrCorrect = false;
//				}
//				else {
//					isNrCorrect = true;
////					lägg till det aktuella värdet i en lista med enumvärden.
//				}
//			}
//		}
//		System.out.println("Talet är korrekt!");
