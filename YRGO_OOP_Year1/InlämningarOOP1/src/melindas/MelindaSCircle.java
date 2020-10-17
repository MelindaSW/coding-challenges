package melindas;

public class MelindaSCircle {
	
//	Instansvariabel:
	private double radius;
	
//	Kontruktor för cirkelklassen:
	public MelindaSCircle(double radius) {
		this.radius = radius;
	}

//	Metod för att räkna ut area på cirkeln:
	public double readArea()
	{
		double circleArea = Math.PI * Math.pow(radius, 2);
		return circleArea;
	}
	
//	Metod för att räkna ut omkretsen av cirkeln:
	public double readCircumference()
	{
		double circleCircumferance = 2 * Math.PI * radius;
		return circleCircumferance;
	}
	
//	Metod för att räkna ut diametern av cirkeln:
	public double readDiameter()
	{
		double circleDiameter = 2 * radius;
		return circleDiameter;
	}
}
