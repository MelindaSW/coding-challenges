package melindas;

public class MelindaSInl12Main {

	public static void main(String[] args) {
		
//		Skickar värden till arrayen i konstruktorn i klassen flagga. 
		MelindaSInl12Flagga flagga = new MelindaSInl12Flagga(new String[][] {
															{"Sverige", "Blå", "Gul"},
															{"USA", "Röd", "Vit", "Blå"},
															{"Italien", "Grön", "Röd", "Vit"},
															{"Danmark", "Röd", "Vit"},
															{"Tyskland", "Röd", "Svart", "Gul"}
															});
		
//		Hämtar en formaterad utskrift av arrayen från metoden returnFlagArray. 
		flagga.returnFlagArray();
	}

}
