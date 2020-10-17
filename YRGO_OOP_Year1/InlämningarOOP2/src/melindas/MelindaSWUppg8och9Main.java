package melindas;

import java.util.Arrays;

public class MelindaSWUppg8och9Main {

	public static void main(String[] args) {

		MelindaSWUppg8och9President obama;
		MelindaSWUppg8och9President bush2;
		MelindaSWUppg8och9President clinton;
		MelindaSWUppg8och9President bush1;
		MelindaSWUppg8och9President trump;
		MelindaSWUppg8och9President carter;
		
//		Uppgift 8:

		MelindaSWUppg8och9President[] presidents = { obama = new MelindaSWUppg8och9President("Barack Obama", 1961),
													 bush2 = new MelindaSWUppg8och9President("George Bush", 1946),
													 clinton = new MelindaSWUppg8och9President("Bill Clinton", 1946),
													 bush1 = new MelindaSWUppg8och9President("George HW Bush", 1924),
													 trump = new MelindaSWUppg8och9President("Donald Trump", 1946)
													};

//		Gör en stream av arrayen presidents och med hjälp av metoderna max och min tar fram den yngsta och äldsta presidenten.
		
		MelindaSWUppg8och9President youngest = Arrays.stream(presidents).max( (u, i) -> u.getYear() - i.getYear() ).get();
		
		MelindaSWUppg8och9President oldest = Arrays.stream(presidents).min( (u, i) -> u.getYear() - i.getYear() ).get();
		
		System.out.printf("Äldst = %s\nYngst = %s\n", oldest.toString(), youngest.toString());
		
		
//		Uppgift 9:

		MelindaSWUppg8och9President[] presidents2 = { obama = new MelindaSWUppg8och9President("Barack Obama", 1961),
													  bush2 = new MelindaSWUppg8och9President("George Bush", 1946),
													  clinton = new MelindaSWUppg8och9President("Bill Clinton", 1946),
													  bush1 = new MelindaSWUppg8och9President("George HW Bush", 1924),
													  trump = new MelindaSWUppg8och9President("Donald Trump", 1946),
													  carter = new MelindaSWUppg8och9President("Jimmy Carter", 1924)
													};
		
		System.out.println("\nÄldst =");
		
//		Skapa en stream av presidents2. Via metoden min, få fram objektet med det lägsta årtalet. .get() returnerar objektet, 
//		slutligen getYear() som returnerar året av typen int. 
		
		int oldestPresidentBirthYear = Arrays.stream(presidents2).min( (u,i) -> u.getYear() - i.getYear() ).get().getYear();
		
//		Använd årtalet ovan för få en ström där eventuella årtal som är samma som det högsta årtalet hänger med. 
//		Skriver slutligen ut varje objekt ur strömmen med forEach.
		
		Arrays.stream(presidents2)
		.filter(president -> president.getYear() == oldestPresidentBirthYear)
		.forEach(s -> System.out.println('\t' + s.toString()));		
		
	}

}
