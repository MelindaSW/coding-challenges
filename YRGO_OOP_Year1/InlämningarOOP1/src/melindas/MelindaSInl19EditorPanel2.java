package melindas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MelindaSInl19EditorPanel2 extends MelindaSInl19EditorPanel implements ActionListener{
	
//	Skapar en menybar att placera menyerna i.
	JMenuBar menuBar = new JMenuBar();
	
//	Skapar klickbara menyer.
	JMenu archive = new JMenu("Arkiv");
	JMenu theme = new JMenu("Tema");
	
//	Skapar menyitems som ska placeras under respektive meny.
	JMenuItem newFile = new JMenuItem("Ny");
	JMenuItem open = new JMenuItem("Öppna");
	JMenuItem save = new JMenuItem("Spara");
	
	JMenuItem dark = new JMenuItem("Mörkt");
	JMenuItem gray = new JMenuItem("Grått");
	JMenuItem light = new JMenuItem("Ljust");
	
//	Skapar en panel till menybaren. Komponenterna som läggs in placeras från vänster. 
	JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//	Den här fonten är basfonten i redigeraren. 
	Font font = new Font("Monospaced", Font.PLAIN, 16);

	public MelindaSInl19EditorPanel2() {
		
//		Lägger till menyitems under respektive meny.
		archive.add(newFile);
		archive.add(open);
		archive.add(save);
		
		theme.add(dark);
		theme.add(gray);
		theme.add(light);
		
//		Lägger till menyerna i menybaren. 
		menuBar.add(archive);
		menuBar.add(theme);
//		Lägger till menybaren i menypanelen. 
		menuPanel.add(menuBar);
		
//		Lägger till actionListeners till de olika menyvalen. 
		newFile.addActionListener(e -> openNewFile());
		
		open.addActionListener(e -> openFile());
		open.addActionListener(e -> openNewFile());
		
//		Vid start ska save vara inaktiverad. Den aktiveras vid ny fil eller när en fil öppnas. 
		save.setEnabled(false);
		save.addActionListener(e -> saveFile());

//		Kopplar temavalen till metoden setTheme. Stringen i parametern bestämmer vilket tema som visas.  
		dark.addActionListener(e -> setTheme("dark"));
		gray.addActionListener(e -> setTheme("gray"));
		light.addActionListener(e -> setTheme("light"));
		
//		Textpanelen som ska innehålla textredigeraren får en borderlayout och en bestämt storlek.
		textPanel = new JPanel(new BorderLayout());
		textPanel.setSize(700, 700);
		
//		Redigeraren får en bestämd font och opaque sätts till false. 
//		Den ska aktiveras när ny fil eller öppna ny fil används. 
		area = new JTextArea();
		area.setFont(font);
		area.setEditable(false);
		area.setOpaque(false);
		
//		Skapar en scrollpane runt textfältet. 		
		sp = new JScrollPane(area, 
							JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
							JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
//		Man lägger bara till scrollpane i panelen eftersom den redan omsluter redigeraren.
		textPanel.add(sp);
		

//		Skapar en ny panel med borderlayout att placera allt i.
		editorPanel = new JPanel(new BorderLayout());
		editorPanel.add(menuPanel, BorderLayout.NORTH);
		editorPanel.add(textPanel, BorderLayout.CENTER);
	
	}
	
	public JPanel getEditorPanel2() {
//		Returnerar den färdiga panelen så att den kan läggas in i tabbedPane i mainklassen. 
		return editorPanel;
	}
	
	private void openNewFile() {
//		När knappen ny fil används eller när en fil öppnas så ska textfältet sättas till redigeringsläge.
//		Sparknappen ska även den aktiveras. 
		area.setOpaque(true);
		area.setEditable(true);
		save.setEnabled(true);
	}
	
	private void setTheme(String theme) {
//		Metoden sätter temat till dark, gray eller light med tillhörande textfärg 
//		och fetstil eller ej när de väljs i menyn tema. 
		
		area.setOpaque(true);
//		Arean måste sättas till opaque för att färgen ska kunna synas. 
		
		if (theme.equals("dark")) {
			area.setBackground(Color.DARK_GRAY);
			font.isBold();
			area.setForeground(Color.YELLOW);
			area.setCaretColor(Color.YELLOW);
		}
		else if (theme.equals("gray")) {
			area.setBackground(Color.LIGHT_GRAY);
			font.isBold();
			area.setForeground(Color.BLACK);
			area.setCaretColor(Color.BLACK);
		}
		else if (theme.equals("light")) {
			area.setBackground(Color.WHITE);
			area.setForeground(Color.BLACK);
			area.setCaretColor(Color.BLACK);
		}
	}
	

}
