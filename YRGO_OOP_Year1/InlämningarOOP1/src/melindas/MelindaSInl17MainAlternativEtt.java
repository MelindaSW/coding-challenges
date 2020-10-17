package melindas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class MelindaSInl17MainAlternativEtt extends JFrame {
	JFrame frame = new JFrame();
	JPanel pnlToC = new JPanel();
	JPanel pnlToF = new JPanel(); 

//	Omvandlingsbuttons, längst till vänster. 
	JButton btnToF = new JButton();
	JButton btnToC = new JButton();

//	Dessa ska stå till höger om omvandlingsknapparna. Bakgrund grå. 
	JLabel lbl1ToCInstr = new JLabel("Ange temp i Fahrenheit:", JLabel.CENTER);
	JLabel lbl1ToFInstr = new JLabel("Ange temp i Celsius:", JLabel.CENTER);
	
//	Dessa ska stå framför labeln med respektive resultat för konverteringarna. 
	JLabel lbl2ToF = new JLabel();
	JLabel lbl2ToC = new JLabel();
	
//	Skapar tomma textfält med plats för 7 tecken. 
	JTextField inputToF = new JTextField(10);
	JTextField inputToC = new JTextField(10);
	
//	Labels nedan ska visa resultaten av konverteringarna. 
	JLabel lbl3ToFShowRes = new JLabel();
	JLabel lbl3ToCShowRes = new JLabel();

	MelindaSInl17Converter convert = new MelindaSInl17Converter();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MelindaSInl17MainAlternativEtt() {
//		Skapar en gridlayout med en kolumn och två rader. 2 bildpunkter mellan raderna i vertikal led. 
		setLayout(new GridLayout(2, 1, 0, 2));
//		Gör bakgrundsfärgen svart, den syns som en svart rad mellan kolumnerna när bildpunkterna mellan raderna är större än 0. 
		getContentPane().setBackground(Color.BLACK);
//		Lägger till en text i ramens titel:
		setTitle("Temperaturomvandlare");
//		Gör så att rutan först visas i mitten av rutan.
		setLocationRelativeTo(null);
//		Gör så att ramen blir synlig:
		setVisible(true);
//		Trycker man på krysset så ska rutan stängas:
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		Anropar metoden som skapar och lägger till innehållet i ramen.
		createWindowContent();
//		Anpassar storleken på ramen efter innehållet: 
		pack();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MelindaSInl17MainAlternativEtt();
			}
		});
	}

	public void createWindowContent()  {
		
//		Panelen som innehåller konverteringen till Celsius:
		pnlToF.setOpaque(true);
		pnlToF.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 20));
		pnlToF.setPreferredSize(new Dimension(510, 70));
		pnlToF.setBackground(Color.WHITE);
		pnlToF.setVisible(true);
		
		lbl1ToFInstr.setOpaque(true);
		lbl1ToFInstr.setBackground(Color.LIGHT_GRAY);
		lbl1ToFInstr.setPreferredSize(new Dimension(150, 25));
		
		lbl2ToF.setOpaque(true);
		lbl2ToF.setText("F = ");
		lbl2ToF.setBackground(Color.WHITE);
		
		lbl3ToFShowRes.setOpaque(true);
		lbl3ToFShowRes.setPreferredSize(new Dimension(70, 25));
//		Lägger till ett actioncommand till inputrutan och en action listener.
		inputToF.setActionCommand("ConvertToF");
		inputToF.addActionListener(l);
		
		btnToF.setText("Omvandla");
		btnToF.setToolTipText("Omvandla till Fahrenheit");
		btnToF.setBackground(Color.WHITE);
//		Lägger till samma actioncommand och actionlistener som inputrutan.
		btnToF.setActionCommand("ConvertToF");
		btnToF.addActionListener(l);
//		Lägger till knapparna och alla labels i en panel i den ordning som de ska visas från vänster. 
		pnlToF.add(btnToF);
		pnlToF.add(lbl1ToFInstr);
		pnlToF.add(inputToF);
		pnlToF.add(lbl2ToF);
		pnlToF.add(lbl3ToFShowRes);

//		Panelen som innehåller konverteringen till Fahrenheit.
		
		pnlToC.setOpaque(true);
		pnlToC.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 20));
		pnlToC.setPreferredSize(new Dimension(510, 70));
		pnlToC.setBackground(Color.WHITE);
		pnlToC.setVisible(true);

		lbl1ToCInstr.setOpaque(true);
		lbl1ToCInstr.setBackground(Color.LIGHT_GRAY);
		lbl1ToCInstr.setPreferredSize(new Dimension(150, 25));
		
		lbl2ToC.setOpaque(true);
		lbl2ToC.setText("C = ");
		lbl2ToC.setBackground(Color.WHITE);
		
		lbl3ToCShowRes.setOpaque(true);
		lbl3ToCShowRes.setPreferredSize(new Dimension(70, 25));
//		Lägger till ett actioncommand till inputrutan och en action listener.
		inputToC.setActionCommand("ConvertToC");
		inputToC.addActionListener(l);

		btnToC.setText("Omvandla");
		btnToC.setToolTipText("Omvandla till Celsius");
		btnToC.setBackground(Color.WHITE);
//		Lägger till samma actioncommand och actionlistener som inputrutan.
		btnToC.setActionCommand("ConvertToC");
		btnToC.addActionListener(l);
//		Lägger till knapparna och alla labels i en panel i den ordning som de ska visas från vänster. 
		pnlToC.add(btnToC);
		pnlToC.add(lbl1ToCInstr);
		pnlToC.add(inputToC);
		pnlToC.add(lbl2ToC);
		pnlToC.add(lbl3ToCShowRes);
		
//		Lägg till de två panelobjekten i ramen
		add(pnlToF);
		add(pnlToC);
	}
	
//	Om enter trycks eller om någon av omvandlingsknapparna klickas på så anropas den dolda klassen nedan. 
	ActionListener l = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			double convertedValueC;
			double convertedValueF;
			
//			Konverterar till Celsius och skriver ut resultatet. Om inputen är fel skrivs det ut i resultatlabeln. 
			if (command.equals("ConvertToC")) {

				if (convert.isInputCorrect(inputToC.getText()) == true) {
					convertedValueC = convert.convertToCelsius(inputToC.getText());
					String outputC = String.valueOf(convertedValueC);
//					Anropar metoden som änrar färg på resultatlabeln.
					labelColorChange("C" + outputC);
					lbl3ToCShowRes.setText(outputC);
				}
				else if (convert.isInputCorrect(inputToC.getText()) == false) {
					lbl3ToCShowRes.setText("Fel input");
					lbl3ToCShowRes.setBackground(Color.GRAY);
				}
			}
//			Konverterar till Fahrenheit. Om inputen är fel skrivs det ut i resultatlabeln.
			if (command.equals("ConvertToF")) {

				if (convert.isInputCorrect(inputToF.getText()) == true) {
					convertedValueF = convert.convertToFahrenheit(inputToF.getText());
					String outputF = String.valueOf(convertedValueF);
//					Anropar metoden som ändrar färg på resultatlabeln.
					labelColorChange("F" + outputF);
					lbl3ToFShowRes.setText(outputF);
				}
				else if (convert.isInputCorrect(inputToF.getText()) == false) {
					lbl3ToFShowRes.setText("Fel input");
					lbl3ToFShowRes.setBackground(Color.GRAY);
				}
			}
		}};
	
//	Ändrar färgen på resultatrutorna beroende på om tempen är under eller över fryspunkten.	
	public void labelColorChange(String x) {
		double a;
		double b;
//		Kontrollerar om värdet i argumentet är fahrenheit eller celsius baserat på det första tecknet. 
		if (x.charAt(0) == 'F') {
			
//			Konverterar allt utom första tecknet till en double och kontrollerar om det är över eller under fryspunkten.
			a = Double.parseDouble(x.substring(1));
			if ( a <= 32 ) {
				lbl3ToFShowRes.setBackground(Color.BLUE);
			} 
			else if (a > 32) {
				lbl3ToFShowRes.setBackground(Color.RED);
			}
		}
		
		if (x.charAt(0) == 'C') {
			
			b = Double.parseDouble(x.substring(1));
			if ( b <= 0 ) {
				lbl3ToCShowRes.setBackground(Color.BLUE);
			} 
			else if (b > 0) {
				lbl3ToCShowRes.setBackground(Color.RED);
			}
		}
	}
	
}


