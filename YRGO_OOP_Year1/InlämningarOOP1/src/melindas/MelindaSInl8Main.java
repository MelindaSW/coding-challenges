package melindas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MelindaSInl8Main {

	public static void main(String[] args) {
	
		 Scanner sc = new Scanner(System.in);
//		 Skapar en scanner och ber användaren att välja ett av tre alternativ.
//		 Om inmatningen är ett tecken annat än en siffra eller en annan siffra än 1,2, eller 3 
//		 så visas felmeddelanden.
		 try
		 {
		 System.out.print("---------------\n"
				 			+ "1. Circle:\n2. Rectangle:\n3. Square:\n"
				 			+"---------------\nWrite the number for your chosen figure:");
		 int selectedFigure = sc.nextInt();

		 switch(selectedFigure) 
		 {
//		 Om nr 1, cirkel väljs:
		 case 1:
			 System.out.print("Circle radius(cm): ");
			 double radius = sc.nextDouble();
			 MelindaSCircle circle = new MelindaSCircle(radius);
			 System.out.format("%nRadius: %.2f%nArea: %.2f cm%nDiameter: %.2f cm%nCircumference: %.2f cm", 
					 			radius, circle.readArea(), circle.readDiameter(), circle.readCircumference());
			 break;
//			 Om nr 2, rektangel väljs:
		 case 2:
			 System.out.print("Rectangle height(cm): ");
			 double height = sc.nextDouble();
			 System.out.print("Rectangle width(cm): ");
			 double width = sc.nextDouble();
			 MelindaSRectangle rectangle = new MelindaSRectangle(height, width);
			 System.out.format("%nHeight: %.2f cm%nWidth: %.2f cm%nArea: %.2f cm%nHypotenuse: %.2f cm%nCircumference: %.2f cm",
					 			height, width, rectangle.readArea(), rectangle.readHypotenuse(), rectangle.readCircumference());
			 break;
//			 Om nr 3, kvadrat väljs:
		 case 3:
			 System.out.println("Square side(cm): ");
			 double side = sc.nextDouble();
			 MelindaSSquare square = new MelindaSSquare(side);
			 System.out.format("%nSide: %.2f cm%nArea: %.2f cm%nHypotenuse: %.2f cm%nCircumference: %.2f cm", 
			 					side, square.readArea(), square.readHypotenuse(), square.readCircumference());
			 break;
//		 Felmeddelande om en siffra som inte är 1,2 eller 3 matas in:			 
		 default:
			 System.out.println("This number is not matching the figure values.");
			 break;
		 }
		 }
//		 Felmeddelande om en annan symbol än en siffra matas in
		 catch (InputMismatchException e)
		 {
			 System.out.println("Wrong input, are you sure you wrote a number?");
		 } 
	}
}
