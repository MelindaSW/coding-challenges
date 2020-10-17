package melindas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;


public class MelindaSWUppg3Main extends JFrame implements HyperlinkListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	JEditorPane editorPane;
	JTextField textField;
	JScrollPane scrollPane;
	URL url;
	
		public MelindaSWUppg3Main()  {
		
			setLayout(new BorderLayout());
			
			textField  = new JTextField();
			editorPane = new JEditorPane();
	
			editorPane.setEditable(false);
			editorPane.setOpaque(true);
			editorPane.addHyperlinkListener(this);
			
			textField.setText("http://");
			textField.addActionListener(e -> actionPerformed(e));	
//			Lägger editorPane i en scrollPane. ScrollPane är den som läggs in i frame objektet. 
//			EditorPane följer automatiskt med. 
			scrollPane = new JScrollPane(editorPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
							 						 JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			add(scrollPane, BorderLayout.CENTER);
			add(textField, BorderLayout.NORTH);
			
			setTitle("Melindas browser");
			setSize(600,600);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		}
	
	
	public static void main(String[] args) {

		MelindaSWUppg3Main m = new MelindaSWUppg3Main();
		
	}

//	När enter klickas under tiden textfältet är aktivt kommer den här metoden att anropas.
	public void actionPerformed (ActionEvent e) {

		try {
			url = new URL(textField.getText());
			
		} catch (MalformedURLException e1) {
			
			editorPane.setText("Ogiltig URL");
		}
		
		try {
			editorPane.setPage(url);
		} catch (IOException e1) {}
	}

//  Gör så att klick på länkar laddar nya sidor. Kopplat till editorPane 
	@Override
	public void hyperlinkUpdate(HyperlinkEvent e) {

		if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
			try {
				editorPane.setPage(e.getURL());
			} catch (IOException ie) {}
		}
	}
}
