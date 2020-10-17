package melindas;

public class MelindaSInl11Main {

	public static void main(String[] args) {
		
		String[] badDeeds = {"Jag skall inte rita bilder av nakna kvinnor i klassen.", 
							"Jag skall inte skrika \"Elden är lös\" i ett fullt klassrum.",
							"Jag skall inte göra fotostatkopior av min rumpa."};
		
//		Skriver ut första värdet i arrayen 10 gånger. 
		MelindaSInl11Citat d = new MelindaSInl11Citat(badDeeds[0] , 10);
		d.displayQuotes();
		
//		Skriver ut andra och tredje värdet i arrayen 20 ggr var.
		MelindaSInl11Citat c = new MelindaSInl11Citat();
		c.setNumberOfRows(20);
		
		for (int i = 1; i < badDeeds.length; i++) 
		{
			c.setQuote(badDeeds[i]);
			System.out.println("-------");
			
			for (int j = 0; j < c.getNumberOfRows(); j++)
			{
				System.out.println(c.getQuote());
			}
			System.out.println();
		}
	}
}