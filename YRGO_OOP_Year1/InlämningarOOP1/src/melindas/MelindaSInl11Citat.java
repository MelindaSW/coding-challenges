package melindas;

public class MelindaSInl11Citat {
	
	private int numberOfRows;
	private String quote;
	
//	Konstruktor
	public MelindaSInl11Citat() {	
	}
//	Konstruktor med två parametrar
	public MelindaSInl11Citat(String quote, int numberOfRows)
	{
		this.quote = quote;
		this.numberOfRows = numberOfRows;
	}
	
//	Getters och setters 
	public int getNumberOfRows() {
		return numberOfRows;
	}
	
	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}
	
	public String getQuote() {
		return quote;
	}
	
	public void setQuote(String quote) 
	{
		this.quote = quote;
	}

//	Metod som returnerar en utskrift beroende på värdet som sätts på instansvariablerna
	public void displayQuotes()
	{
		System.out.println("-------");
		for (int i = 0; i < numberOfRows; i++)
		{
			System.out.println(quote);
		}
		System.out.println("\n");
	}
}
