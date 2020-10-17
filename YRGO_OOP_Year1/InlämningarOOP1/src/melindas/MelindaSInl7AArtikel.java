package melindas;

public class MelindaSInl7AArtikel {

	private int antal;
	private String vara;
	private double pris;
	private double totalPris;
	
	public MelindaSInl7AArtikel(int antal, String vara, double pris) 
	{
		this.antal = antal;
		this.vara = vara;
		this.pris = pris;
	}
	
	public int getAntal() 
	{
		return antal;
	}
	
	public String getVara() 
	{
		return vara;
	}
	
	public double getPris()
	{
		return pris;
	}
	
	public double getTotalPris() 
	{
		totalPris = this.antal * this.pris;
		return totalPris;
	}

}






















