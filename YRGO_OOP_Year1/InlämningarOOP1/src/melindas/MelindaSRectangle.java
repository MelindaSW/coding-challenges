package melindas;

public class MelindaSRectangle {
	
//	Instansvariabler:
	private double h;
	private double w;
	
//	Konstruktor för rektangelklassen:
	public MelindaSRectangle(double h, double w) {
		this.h = h;
		this.w = w;
	}
	
//	Metod för att avläsa area på rektangeln:
	public double readArea()
	{
		double rectangleArea = h *w;
		return rectangleArea;
	}
	
//	Metod för att räkna ut omkrets på rektangeln:
	public double readCircumference()
	{
		double rectangleCircumference = h * 2 + w * 2;
		return rectangleCircumference;
	}
//	Metod för att räkna ut hypotenusan:
	public double readHypotenuse()
	{
		double hypotenuse = Math.sqrt(h*h + w*w);
		return hypotenuse;
	}

}
