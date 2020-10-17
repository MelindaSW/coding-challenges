package melindas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MelindaSWUppg2Server {

	
	public static void main(String[] args) throws IOException {

		Socket socket = null;
		String result;

		MelindaSWUppg2Converter converter = new MelindaSWUppg2Converter();
//		En serversocket skapas. Den binds till porten i parametern.
		ServerSocket serversocket = new ServerSocket(11111);
	
		System.out.println("Väntar på klienten.");
		
		try {
//			När klienten vill ansluta via den definierade socketen accepterar 
//			servern anslutningen via raden nedan.
			socket = serversocket.accept();
//			Strömmar för input från klienten och outout till klienten skapas:
			DataInputStream fromClient = new DataInputStream(socket.getInputStream());
			DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
			System.out.println("Port" + socket.getPort() + " är ansluten.");
//			
			while (true) {

						result = converter.evaluateAndConvert(fromClient.readUTF());
						toClient.writeUTF(result);						
			}
			
		} catch (EOFException e) {
//			Om klienten stängs bildas denna exception. 
			System.out.println("Klienten avslutades.");
		} finally {
//			Efter att klienten avslutas visas ett meddelande och sockets stängs ner.  
			System.out.println("Servern stängs");
			socket.close();
			serversocket.close();
		}
	}

}
