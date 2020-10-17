package melindas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MelindaSInl16Main {

	private JFrame frame = new JFrame("Button and CheckBox");
	private JButton button = new JButton("Inaktiverad");
	private JCheckBox box = new JCheckBox("JA");
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel("Vill du att knappen ska aktiveras?");
	
	public MelindaSInl16Main() {
		makeBox();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MelindaSInl16Main();
			}
		});
	}
	
	private void makeBox() {
		
		button.setEnabled(false);
		box.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (box.isSelected()) {
						button.setEnabled(true);
						button.setText("Aktiverad");
					}
					else if (!box.isSelected()) {
						button.setEnabled(false);
						button.setText("Inaktiverad");
					}
				}});
		
		panel.add(label);
		panel.add(box);
		panel.add(button);

		frame.setLocationRelativeTo(null);
		frame.setSize(300, 150);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

}
