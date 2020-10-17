package melindas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MelindaSWUppg7UI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

		
//		Huvudpanelen instansieras. 
		JPanel 	   editorPanel = new JPanel();

//		Knappobjekt skapas.  
		JButton    open  = new JButton("OPEN"); 
		JButton    save  = new JButton("SAVE");
		JButton    encrypt = new JButton("ENCRYPT");
		JButton	   decrypt = new JButton("DECRYPT");
		JButton    encryptToFile = new JButton("ENCRYPT AND SEND TO FILE");

//		Ett fält för att redigera text instansieras med specifierade rader och kolumner. 

		JTextArea  area  = new JTextArea(10,60);
		
//		Textfältet läggs till i scrollPane objektet. Där bestäms att scrollbar alltid ska vara synliga, 
//		även när de inte behövs. 
		JScrollPane sp   = new JScrollPane(area,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
//		Panelerna som ska läggas in i huvudpanelen instansieras. 
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel textPanel   = new JPanel(new FlowLayout(FlowLayout.CENTER));

//		En FileChooser instansieras för att kunna öppna och spara filer från datorn. 
		private JFileChooser fc = new JFileChooser(new File("."));

//		En bufferedReader behövs för att kunna öppna(läsa från) en ny fil. 
		private BufferedReader infile;
		
		
		public MelindaSWUppg7UI() {

//			Fonten som ska synas i textfältet. 
			area.setFont(new Font("Monospaced", Font.PLAIN, 12)); 

			editorPanel.setLayout(new BorderLayout()); 
//			Save och print knapparna aktiveras bara om en text påbörjas i textfältet eller om 
//			en ny fil öppnas.
			save.setEnabled(false);
			encrypt.setEnabled(false);
			decrypt.setEnabled(false);
//			Om man börjar skriva något i textfältet så aktiveras händelserna i key. 
			area.addKeyListener(key);
			area.setText("(Choose between opening a text file to encrypt\nor write your text here)");
			
//			Actionlistener kopplas till knapparna. 
			open.addActionListener(this);  
			save.addActionListener(this); 
			encrypt.addActionListener(this);
			decrypt.addActionListener(this);
			encryptToFile.addActionListener(this);
			
//			Knapparna läggs till i knappPanelen
			buttonPanel.add(open);
			buttonPanel.add(save);
			buttonPanel.add(encrypt);
			buttonPanel.add(decrypt);
			buttonPanel.add(encryptToFile);
			
//			textPanelen får en bestämd storlek och scrollPanelen läggs in.
			textPanel.setSize(600,450);
			textPanel.add(sp);
			
//			panelerna placeras slutligen i huvudpanelen. 
			editorPanel.add(buttonPanel, BorderLayout.NORTH);
			editorPanel.add(textPanel, BorderLayout.CENTER);
			
//			Lägg till komponeneterna i JFrame
			setTitle("Encrypt and Decrypt");
			add(editorPanel);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			pack();
		}
		
		
		public JPanel getEditorPanel() {
			return editorPanel;
		}

		
		public void actionPerformed(ActionEvent e) { 
//			Olika metoder anropas beroende på vilken knapp det gäller. 
			MelindaSWUppg7EncryptionAndDecryption encrypter = new MelindaSWUppg7EncryptionAndDecryption();
			
			if (e.getSource() == open) {       
			    openFile();
			    encrypt.setEnabled(true);
			    
			} else if (e.getSource() == save) {
				saveFile();
				
			} else if (e.getSource() == encrypt) { 
//				Skicka texten i rutan till krypteringsklassen och skriv ut resultatet i rutan.
				area.setText(encrypter.encrypt(area.getText()));
				encrypt.setEnabled(false);
				decrypt.setEnabled(true);
		
				
			} else if (e.getSource() == decrypt) {
//				Skicka texten i rutan till dekrypteringsklassen. Skriv in det nya resultatet. 
				area.setText(encrypter.decrypt(area.getText()));
				encrypt.setEnabled(true);
				decrypt.setEnabled(false);
				
			} else if (e.getSource() == encryptToFile) {
				area.setText(encrypter.encrypt(area.getText()));
				saveFile();
			}
		} 
		
		
		public void openFile() {
//			Metoden som anropas om man vill öppna en fil från systemet. 
			int result = fc.showOpenDialog(null);

			if (result == JFileChooser.APPROVE_OPTION) {

				File file = fc.getSelectedFile();
				String name = fc.getSelectedFile().getName();

				try {
					infile = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
					area.read(infile, "..");
					save.setEnabled(true);
					encrypt.setEnabled(true);
				}
				catch (FileNotFoundException e) {

					JOptionPane.showMessageDialog(null, "Kan inte öppna filen " + name);
				} 
				catch (IOException i) {}
			}
		} 

			
			   
		public void saveFile() { 
//			Metod för att spara en text till en fil.
			JOptionPane.showMessageDialog(null, "Om filnamnet redan existerar, välj ett annat namn \neller tryck Spara för att spara över det gamla innehållet.");
//			Om filen existerar så ska det befintliga innehållet skrivas över det gamla. 
//			Om den inte existerar så ska en ny fil skapas. 
			int result = fc.showSaveDialog(null);

			if (result == JFileChooser.APPROVE_OPTION) {
				
				File file = new File(fc.getSelectedFile().getAbsolutePath());
				String name = fc.getSelectedFile().getName();

				if (file.exists()) {
					try {
						FileWriter w1 = new FileWriter(name, false);
						area.write(w1);
					} catch (IOException e) {}
				}
				else {
					try {
						FileWriter w2 = new FileWriter(name);
						area.write(w2);
					} catch (IOException e) {}
				}
			}
		}

		
		public KeyListener key = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				save.setEnabled(true);
				encrypt.setEnabled(true);
		}};
			
}











	
	
