package melindas;

public class MelindaSSquare extends MelindaSRectangle{ 
// Extends betyder att kvadratklassen ärver variabler och metoder från rektangelklassen. 
	
	public MelindaSSquare(double h)
	{
//		Anrop av rektangelklassens (superklassens) variabler och metoder.
		super(h, h);
	}

}
