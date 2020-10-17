package melindas;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class MelindaSInl19Main extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	JTabbedPane p = new JTabbedPane();
	
	public MelindaSInl19Main() throws IOException {
//		Skapar en ram med fast storlek och som visas mitt på skärmen. 
//		Metoden som anropas nedan lägger till tabs i JTabbedPane p. 
//		Sedan läggs hela tabbedpane in i ramen. 
		addTabs();
		
		setTitle("Mitt fönster");
		add(p);
		setSize(800, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public static void main(String[] args) throws IOException {
		
		MelindaSInl19Main ms = new MelindaSInl19Main();
	}
	
	
	public void addTabs() throws IOException {
		
//		Skapar instanser av de olika tabbarna som sedan hjälper till att nå getters för 
//		panelerna som läggs in i tabbedPane med addTab() metoden.
		MelindaSInl19StartPanel ts = new MelindaSInl19StartPanel();
		MelindaSInl19PhotoAlbumPanel album = new MelindaSInl19PhotoAlbumPanel();
		MelindaSInl19EditorPanel editor = new MelindaSInl19EditorPanel();
		MelindaSInl19EditorPanel1 editor1 = new MelindaSInl19EditorPanel1();
		MelindaSInl19EditorPanel2 editor2 = new MelindaSInl19EditorPanel2();
		MelindaSInl19ClockPanel clockPanel = new MelindaSInl19ClockPanel();
		

		p.addTab("Start", ts.getStartPanel());
		p.addTab("Fotoalbum", album.getFotoalbum());
		p.addTab("Editor", editor.getEditorPanel());
		p.addTab("Editor1", editor1.getEditorPanel1());
		p.addTab("Editor2", editor2.getEditorPanel2());
		p.addTab("Klocka", clockPanel.getClockPanel());
	}
}























