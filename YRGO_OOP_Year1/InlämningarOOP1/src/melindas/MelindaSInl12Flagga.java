package melindas;

public class MelindaSInl12Flagga {
	
//	Klassvariabel
	private String[][] flagArray;
	
//	Konstruktor
	public MelindaSInl12Flagga(String[][] flagArray)
	{
		this.flagArray = flagArray;
	}
	
	public void returnFlagArray()
	{
		for (int i = 0; i < flagArray.length; i++)				// For loop, loopar genom arrayens längd.
		{
			for (int j = 0; j < flagArray[i].length; j++)		// Nästad loop, loopar genom den nästade arrayerna.
			{
				if (flagArray[i][j].equals(flagArray[i][0]))	// Om värdet är lika med värdet på någon av de första positionerna i arrayerna, gör det här.
				{ 
					char[] country = flagArray[i][0].toCharArray(); // Gör om det första värdet i arrayerna (landet) till en char array så att bokstäverna kan räknas.  
					int sum = country.length;

					while (sum < 14)  			// Lägger till ett mellanslag till landet till dess att sum uppnår värdet i while villkoret. 
					{
						flagArray[i][0] += " ";
						sum++;
					}
					System.out.print(flagArray[i][0]);		// Skriver ut landet med anpassat antal mellanslag.  
				}
				else 
				{
				System.out.print(flagArray[i][j] + " ");   // Skriver ut värdena som har positionerna 1 och uppåt i arrayerna. 
				}
			}
			System.out.println();
		}
	}
	
}