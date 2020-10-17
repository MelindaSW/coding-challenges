package melindas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class MelindaSWUppg4FlightClient extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<MelindaSWUppg4FlightBoardPanel> panels;
	private MelindaSWUppg4FlightBoardPanel flightBoard;
	
	
	public MelindaSWUppg4FlightClient() throws UnknownHostException, IOException {
		
//		JFrames layout 
		setLayout(new GridLayout(4, 1, 0, 1)); // 4 rader, 1 kolumn, inget mellanrum mellan kolumnerna, 1 px mellanrum mellan raderna
		
//		Upprätta koppling till servern.
		Socket socket = new Socket("127.0.0.1", 11111);
		DataInputStream fromServer = new DataInputStream(socket.getInputStream());
		
//		För att lägga till panelerna i ramen.
		
		panels = new ArrayList<>();
//		Hämtar data från servern och lägger till i parametrarna i panelobjektet flightBoard. Panelobjektet läggs sedan till i ramen.
			for (int i = 0; i < 4; i++) {
				flightBoard = new  MelindaSWUppg4FlightBoardPanel(fromServer.readUTF(), fromServer.readUTF(), 
						fromServer.readInt(), fromServer.readInt());
				panels.add(flightBoard);
				add(panels.get(i)); 
			}
			
			panels.get(0).delay(15);
			panels.get(0).setFont(new Font(panels.get(0).getFont().getFontName(), Font.ITALIC, panels.get(0).getFont().getSize()));
			panels.get(1).setComment("Boarding gate 15");
			panels.get(1).setForeground(Color.RED);

//			För att göra bakgrunden svart, så att linjerna syns
			setBackground(Color.BLACK);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			pack();
		
			socket.close();
	}
	
	public static void main(String[] args) throws IOException {

		MelindaSWUppg4FlightClient client = new MelindaSWUppg4FlightClient();
				
	}

}
