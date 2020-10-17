package melindas;

import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MelindaSInl13Main {
//	Instansvariabler
	static String nameOfTestFile;
	static int pointsForG;
	static int pointsForVg;
	static int nrOfValues;
	static int maxTestPoints;
//	Tre olika arrayer. Grades är final. Betygens benämningar ska inte ändras. 
	final String[] grades = {"IG", "G", "VG"};
	static List<String> names = new ArrayList<>();
	static List<Integer> points = new ArrayList<>();
//	Deklarering av File och PrintWriter som behövs för att skapa och skriva in till fil. 
	static File file;
	static PrintWriter tentamen;
//	Skapar referenser till klassens metoder
	static MelindaSInl13Main ms13 = new MelindaSInl13Main();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {

//	 	Variabeln date innehåller dagens datum i formatet ÅÅMMDD.
		LocalDate ld = LocalDate.now();
		String date = ld.format(DateTimeFormatter.BASIC_ISO_DATE).substring(2); 

//		Ta reda på inledande värden.
		System.out.print("Ange skrivningens maxpoäng: ");
		maxTestPoints = sc.nextInt();
		
		System.out.print("Hur många värden vill du mata in?: ");
		nrOfValues = sc.nextInt();
		
		System.out.print("Ange betygsgräns för G: ");
		pointsForG = sc.nextInt();
		
		System.out.print("Ange betygsgräns för VG: ");
		pointsForVg = sc.nextInt();
		
//		Ta reda på om datumet ska skrivas in automatiskt eller manuellt.
		while (true)
		{
			System.out.println("Vill du mata in datumet för skrivningen manuellt? Y/N");
			String choice = sc.next();	
			if (choice.equalsIgnoreCase("Y"))
			{
				System.out.print("Ange skrivningens namn (namnet måste vara unikt): ");   
				nameOfTestFile = sc.next();
				sc.nextLine();
				ms13.doesFileExist(nameOfTestFile);
				break;
			}
			else if (choice.equalsIgnoreCase("N"))
			{
				System.out.print("Ange skrivningens namn (namnet måste vara unikt): ");
				nameOfTestFile = sc.next();
				sc.nextLine();
				nameOfTestFile = nameOfTestFile + date;
				ms13.doesFileExist(nameOfTestFile);
				break;
			}	
			else 
			{
				System.out.println("Skriv antingen Y eller N.");
				continue;
			}
		}	
//		Ta reda på namn och poäng och lägg in i arraylistorna. 
		int i = 0;
		while (i < nrOfValues)
		{
			System.out.print("\nAnge namn: ");
			String name = sc.nextLine();
			names.add(name);
			
//			Ta emot poäng och testa om värdet på poängen är inom gränsvärdet.
			boolean value = false;
			while (!value)
			{
				int point;
				System.out.print("Ange poäng: ");
				point = sc.nextInt();
				sc.nextLine();
				
				if (point <= 0 || point > maxTestPoints)
				{
					System.out.println("Värdet är antingen för litet eller för stort.");
				}
				else 
				{
					points.add(point);
					i++;
					value = true;
				}
			}
		}
//		Kalla på metoden som formaterar och skriver ut samtliga värden till filen. 
		ms13.writeAllToFile();
		
		System.out.println("\nTryck ner valfri tangent för att fortsätta..."); 
		sc.close();
		System.exit(0);
	}
//	Metod som testar om filen existerar. Om Y så skrivs filen över. Om N så läggs texten till i filen som redan finns. 
	public void doesFileExist(String testNamn) throws IOException
	{
		file = new File(testNamn);
		if(file.exists())
		{
			while (true)
			{	
				System.out.println("Filen existerar redan! Vill du att den ska skrivas över? Y/N");
				String yOrN = sc.next();
				sc.nextLine();
				
				if (yOrN.equalsIgnoreCase("Y"))
				{
					tentamen = new PrintWriter(new FileWriter(file, false));
					break;
				}
				else if (yOrN.equalsIgnoreCase("N"))
				{
					tentamen = new PrintWriter(new FileWriter(file, true));
					break;
				}
				else 
				{
					System.out.println("Skriv antingen Y eller N");
					continue;
				}
			}
		}
		else if (!file.exists())
		{
			tentamen = new PrintWriter(file);
		}
	}
//	Metod som räknar ut betyget baserat på gränsvärdena för betygen.
	public String giveGrade(Integer point)
	{
		if (point < pointsForG) 
		{
			return grades[0];
		}
		else if (point < pointsForVg && point >= pointsForG)
		{
			return grades[1];	
		}
		else
		{
			return grades[2];
		}
	}
//	Metod som räknar ut genomsnittet för poängen.
	public double returnAverage()
	{
		double averageOfPoints = 0;
		for (int i = 0; i < nrOfValues; i++)
		{
		averageOfPoints += points.get(i);
		}
		return averageOfPoints/nrOfValues;
	}
//	Metod som skriver in all samlad information till filen.
	public void writeAllToFile()
	{
		tentamen.printf("%nResultat %s%nMaxpoäng %d%nG gräns %d%nVG gräns %d%n%-20s %-10s %s%n%s%n", 
						nameOfTestFile, maxTestPoints, pointsForG, pointsForVg, "Namn", "Poäng", "Betyg", 
						"===========================================================");

		for(int y = 0; y < nrOfValues; y++)
		{
			tentamen.printf("%-23s%-11s%s%n", 
							names.get(y), points.get(y), ms13.giveGrade(points.get(y)));
		}
		
		tentamen.printf("%nGenomsnitt: %.2f%n%n", ms13.returnAverage());
		tentamen.flush();
		tentamen.close();
	}
}
