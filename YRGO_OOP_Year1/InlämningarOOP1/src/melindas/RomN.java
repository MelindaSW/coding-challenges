package melindas;

public enum RomN {
//	Enum med romerska nummer
	I (1.0),
	V (5.0), 
	X (10.0), 
	L (50.0), 
	C (100.0), 
	D (500.0), 
	M (1000.0);
	
	private final double value;

	RomN(double value)
	{
		this.value = value;
	}
	
	public double getValue()
	{
		return this.value;
	}
}
