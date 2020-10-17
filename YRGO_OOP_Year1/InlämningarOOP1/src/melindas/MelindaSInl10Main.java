package melindas;

public class MelindaSInl10Main {

	public static void main(String[] args) {
		
//		Skapar en instans till klassen MelindaSInl10Observation
		MelindaSInl10Observation b = new MelindaSInl10Observation();
		
//		Sätter värden på instansvariablerna:
		b.setNr(8431);
		b.setTim(19);
		b.setMin(30);
		b.setTemp(12.5);
		b.setVindhast(2.5);
		b.setVindriktning(123); 
		
//		Skriver ut en lista med värden och hämtar värdet från riktningsmetoden:
		System.out.printf("Observation nr. %d. Kl %02d:%02d%nTemperatur: %.1f%n"
							+ "Vindhastighet: %.1f%nVindriktning: %.2f%nRiktning: %s",
							b.getNr(),
							b.getTim(),
							b.getMin(),
							b.getTemp(),
							b.getVindhast(),
							b.getVindriktning(),
							b.returnRiktning());
	}

}
