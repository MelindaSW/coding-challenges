package melindas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class MelindaSInl19EditorPanel1 extends MelindaSInl19EditorPanel implements ActionListener{
//	Klassen ärver från den första editorklassen. 
	private JButton newFile = new JButton();

	public MelindaSInl19EditorPanel1() {
//		En panel med en editor skapas. Editorn har tre knappar i nederkant, open, save och newFile. 
//		Redigeringsrutan täcker resten av rutan. Redigeringsrutan och sparknappen aktiveras när ny fil trycks in eller när man 
//		öppnar en fil från filechoosern.
//		Klassen ärver egenskaper och metoder från den första editorn. 
		
		editorPanel = new JPanel(new BorderLayout());
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		textPanel = new JPanel(new BorderLayout());
		textPanel.setSize(700, 700);
		
		area = new JTextArea();
		sp = new JScrollPane(area, 
							JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
							JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
//		Passande actionListeners kopplas till knapparna. Både via superklassens actionlistener och 
//		via Lambda uttryck till metoden openNewFile() som finns i den aktuella klassen. 
		open = new JButton("Öppna");
		open.addActionListener(this);
		open.addActionListener(e -> openNewFile());

		newFile.setText("Ny fil");
		newFile.addActionListener(e -> openNewFile());
		
		save = new JButton("Spara");
		save.addActionListener(this);
		save.setEnabled(false);
		
//		Editable och opaque sätts till false för att det ska synas att den inte är aktiverad. 
		area.setOpaque(false);
		area.setEditable(false);
		area.setFont(new Font("Monospaced", Font.PLAIN, 16)); 

		textPanel.add(sp);
				
		buttonPanel.add(newFile);
		buttonPanel.add(open);
		buttonPanel.add(save);
		
		editorPanel.add(textPanel, BorderLayout.CENTER);
		editorPanel.add(buttonPanel, BorderLayout.SOUTH);
		
	}
	
	public JPanel getEditorPanel1() {
		return editorPanel;
	}

	
	private void openNewFile() {
//		När knappen ny fil används så ska textfältet aktiveras.
//		Sparknappen ska aktiveras. 
//		Likaså när en fil öppnas.
		area.setOpaque(true);
		area.setEditable(true);
		save.setEnabled(true);
	}
}
