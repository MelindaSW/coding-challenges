package melindas;
import java.awt.*; 
import java.awt.event.*; 
import java.io.*; 
import javax.swing.*; 

public class MelindaSInl19EditorPanel implements ActionListener {
	
//	Huvudpanelen instansieras. 
	JPanel 	   editorPanel = new JPanel();

//	Knappobjekt skapas.  
	JButton    open  = new JButton("Öppna"); 
	JButton    save  = new JButton("Spara");
	JButton    print = new JButton("Skriv ut");
	

//	Ett fält för att redigera text instansieras med specifierade rader och kolumner. 

	JTextArea  area  = new JTextArea(10,60);
//	textfältet läggs till i scrollPane objektet. Där bestäms att scrollbar alltid ska vara synliga, 
//	även när de inte behövs. 
	JScrollPane sp   = new JScrollPane(area,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
//	Panelerna som ska läggas in i huvudpanelen instansieras. 
	JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel textPanel   = new JPanel(new FlowLayout(FlowLayout.CENTER));

//	En FileChooser instansieras för att kunna öppna och spara filer från datorn. 
	private JFileChooser fc = new JFileChooser(new File("."));

//	En bufferedReader behövs för att kunna öppna(läsa från) en ny fil. 
	private BufferedReader infile;
	
	public MelindaSInl19EditorPanel() {

//		Fonten som ska synas i textfältet. 
		area.setFont(new Font("Monospaced", Font.PLAIN, 12)); 

		editorPanel.setLayout(new BorderLayout()); 
//		Save och print knapparna aktiveras bara om en text påbörjas i textfältet eller om 
//		en ny fil öppnas.
		save.setEnabled(false);
		print.setEnabled(false);
//		Om man börjar skriva något i textfältet så aktiveras händelserna i key. 
		area.addKeyListener(key);
//		Actionlistener kopplas till knapparna. 
		open.addActionListener(this);  
		save.addActionListener(this); 
		print.addActionListener(this);
//		Knapparna läggs till i knappPanelen
		buttonPanel.add(open);
		buttonPanel.add(save);
		buttonPanel.add(print);
//		textPanelen får en bestämd storlek och scrollPanelen läggs in.
		textPanel.setSize(600,450);
		textPanel.add(sp);
//		panelerna placeras slutligen i huvudpanelen. 
		editorPanel.add(buttonPanel, BorderLayout.NORTH);
		editorPanel.add(textPanel, BorderLayout.CENTER);
	}
	
	
	public JPanel getEditorPanel() {
		return editorPanel;
	}

	
	public void actionPerformed(ActionEvent e) { 
//		Olika metoder anropas beroende på vilken knapp det gäller. 
		if (e.getSource() == open) {       
		    openFile();
		}
		else if (e.getSource() == save) {
			saveFile();
		}
		else if (e.getSource() == print) { 

			try {
				area.print();  
			}
			catch (Exception ex) {}
		}
	} 
	
	
	public void openFile() {
//		Metoden som anropas om man vill öppna en fil från systemet. 
		int result = fc.showOpenDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {

			File file = fc.getSelectedFile();
			String name = fc.getSelectedFile().getName();

			try {
				infile = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				area.read(infile, "..");
				save.setEnabled(true);
				print.setEnabled(true);
			}
			catch (FileNotFoundException e) {

				JOptionPane.showMessageDialog(null, "Kan inte öppna filen " + name);
			} 
			catch (IOException i) {}
		}
	} 

		
		   
	public void saveFile() { 
//		Metod för att spara en text till en fil.
		JOptionPane.showMessageDialog(null, "Om filnamnet redan existerar, välj ett annat namn \neller tryck Spara för att spara över det gamla innehållet.");
//		Om filen existerar så ska det befintliga innehållet skrivas över det gamla. 
//		Om den inte existerar så ska en ny fil skapas. 
		int result = fc.showSaveDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			
			File file = new File(fc.getSelectedFile().getAbsolutePath());
			String name = fc.getSelectedFile().getName();

			if (file.exists()) {
				try {
					FileWriter w1 = new FileWriter(name, false);
					area.write(w1);
				} 
				catch (IOException e) {}
			}
			else {
				try {
					FileWriter w2 = new FileWriter(name);
					area.write(w2);
				}
				catch (IOException e) {}
			}
		}
	}

	public KeyListener key = new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
			save.setEnabled(true);
			print.setEnabled(true);
	}};
		
}










