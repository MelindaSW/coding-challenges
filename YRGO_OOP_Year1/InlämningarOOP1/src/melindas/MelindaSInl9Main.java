package melindas;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

public class MelindaSInl9Main {

	public static void main(String[] args) throws IOException {

//		Programmet läser av en textfil, loopar igenom den och räknar raderna. 
//		Sedan slumpas ett nummer fram där värdet är inom och filen läses igenom fram till raden med det
//		slumpade numret. Därefter visas en dialogruta med texten ur den raden.
		
		Scanner sc = new Scanner(new File("src/Proverbs.txt"));
		Random random = new Random();
		
		int rowCounter = 0;
		String readThroughFile = "";
		String randomProverb ="";
		
		while (sc.hasNextLine()) {
			readThroughFile = sc.nextLine();
			rowCounter++;
		}
		sc.close();
		
		int randomNumber = random.nextInt(rowCounter+1);
		if (randomNumber == 0) {
			randomNumber++;
		}
		
		Scanner sc2 = new Scanner(new File("src/Proverbs.txt"));
		
		for (int y = 1; y <= randomNumber; y++) {
			randomProverb = sc2.nextLine();
		}
//		Toolkit.getDefaultToolkit().beep();
		JOptionPane.showMessageDialog(null, randomProverb);
		sc2.close();
	}

}
