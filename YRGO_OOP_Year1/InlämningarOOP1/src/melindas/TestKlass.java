package melindas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TestKlass {

	public static void main(String[] args) {
//		int presentYear = Calendar.getInstance().get(Calendar.YEAR);
//		
//		System.out.println(presentYear);
		LocalTime locTime = LocalTime.now();
		LocalDate locDate = LocalDate.now();
		 DateTimeFormatter t = DateTimeFormatter.ofPattern("hh:m:ss");
		 DateTimeFormatter d = DateTimeFormatter.ofPattern("MMM EE dd");
		 
		 	System.out.println(locDate.format(d));
			System.out.println(locTime.format(t));
	}

}
