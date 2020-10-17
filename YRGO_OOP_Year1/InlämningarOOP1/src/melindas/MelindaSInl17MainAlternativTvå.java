package melindas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.border.TitledBorder;

public class MelindaSInl17MainAlternativTvå extends JFrame {
	JFrame frame = new JFrame();
	JPanel pnlToC = new JPanel();
	JPanel pnlToF = new JPanel(); 

	JButton btnToF = new JButton();
	JButton btnToC = new JButton();

	JLabel lbl1ToCInstr = new JLabel("Write temp in Fahrenheit:", JLabel.RIGHT);
	JLabel lbl1ToFInstr = new JLabel("Write temp in Celsius:", JLabel.RIGHT);
	
	JLabel lbl2ToF = new JLabel();
	JLabel lbl2ToC = new JLabel();
	
	JTextField inputToF = new JTextField(10);
	JTextField inputToC = new JTextField(10);
	
	JLabel lbl3ToFShowRes = new JLabel();
	JLabel lbl3ToCShowRes = new JLabel();

	MelindaSInl17Converter convert = new MelindaSInl17Converter();
	
	private static final long serialVersionUID = 1L;
	
	public MelindaSInl17MainAlternativTvå() {
		setLayout(new FlowLayout()); 
		setTitle("Converter");
		setSize(600, 210);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		createWindowContent();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MelindaSInl17MainAlternativTvå();
			}
		});
	}

	public void createWindowContent()  {
		
		Font font = new Font("TimesRoman", Font.BOLD, 16);
//		Panelen som innehåller konverteringen till Celsius:
		pnlToF.setOpaque(true);
		pnlToF.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
		pnlToF.setPreferredSize(new Dimension(510, 70));
		pnlToF.setBackground(Color.WHITE);
		pnlToF.setBorder(new TitledBorder("From C to F"));
		pnlToF.setVisible(true);
		
		lbl1ToFInstr.setOpaque(true);
		lbl1ToFInstr.setBackground(Color.WHITE);
		lbl1ToFInstr.setPreferredSize(new Dimension(150, 25));
		
		lbl2ToF.setOpaque(true);
		lbl2ToF.setText("F = ");
		lbl2ToF.setBackground(Color.WHITE);
		
		lbl3ToFShowRes.setOpaque(true);
		lbl3ToFShowRes.setFont(font);
		lbl3ToFShowRes.setPreferredSize(new Dimension(70, 25));
		
		inputToF.setActionCommand("ConvertToF");
		inputToF.addActionListener(l);
		
		btnToF.setText("Convert");
		btnToF.setToolTipText("Convert to Fahrenheit");
		btnToF.setBackground(Color.LIGHT_GRAY);
		btnToF.setActionCommand("ConvertToF");
		btnToF.addActionListener(l);
		
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
		pnlToC.setBorder(new TitledBorder("From F to C"));
		pnlToC.setVisible(true);

		lbl1ToCInstr.setOpaque(true);
		lbl1ToCInstr.setBackground(Color.WHITE);
		lbl1ToCInstr.setPreferredSize(new Dimension(150, 25));
		
		lbl2ToC.setOpaque(true);
		lbl2ToC.setText("C = ");
		lbl2ToC.setBackground(Color.WHITE);
		
		lbl3ToCShowRes.setOpaque(true);
		lbl3ToCShowRes.setFont(font);
		lbl3ToCShowRes.setPreferredSize(new Dimension(70, 25));
		
		inputToC.setActionCommand("ConvertToC");
		inputToC.addActionListener(l);
		
		btnToC.setText("Convert");
		btnToC.setToolTipText("Convert to Celsius");
		btnToC.setBackground(Color.LIGHT_GRAY);
		btnToC.setActionCommand("ConvertToC");
		btnToC.addActionListener(l);
		
		pnlToC.add(btnToC);
		pnlToC.add(lbl1ToCInstr);
		pnlToC.add(inputToC);
		pnlToC.add(lbl2ToC);
		pnlToC.add(lbl3ToCShowRes);
		
		add(pnlToF);
		add(pnlToC);
	}
	
	
	ActionListener l = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			double convertedValueC;
			double convertedValueF;
			
			if (command.equals("ConvertToC")) {

				if (convert.isInputCorrect(inputToC.getText()) == true) {
					convertedValueC = convert.convertToCelsius(inputToC.getText());
					String outputC = String.valueOf(convertedValueC);
					labelColorChange("C" + outputC);
					lbl3ToCShowRes.setText(outputC);
				}
				else if (convert.isInputCorrect(inputToC.getText()) == false) {
					lbl3ToCShowRes.setText("...");
					lbl3ToCShowRes.setBackground(Color.GRAY);
				}
			}
			
			if (command.equals("ConvertToF")) {

				if (convert.isInputCorrect(inputToF.getText()) == true) {
					convertedValueF = convert.convertToFahrenheit(inputToF.getText());
					String outputF = String.valueOf(convertedValueF);
					labelColorChange("F" + outputF);
					lbl3ToFShowRes.setText(outputF);
				}
				else if (convert.isInputCorrect(inputToF.getText()) == false) {
					lbl3ToFShowRes.setText("...");
					lbl3ToFShowRes.setBackground(Color.GRAY);
				}
			}
		}};
	
	public void labelColorChange(String x) {
		
		double a;
		double b;
		if (x.charAt(0) == 'F') {
			
			a = Double.parseDouble(x.substring(1));
			if ( a <= 32 ) {
				lbl3ToFShowRes.setBackground(Color.BLUE);
			} 
			else if (a > 32){
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

