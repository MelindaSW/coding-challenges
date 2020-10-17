package melindas;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MelindaSWUppg4FlightServer {

	
	public static void main(String[] args) throws IOException {
//		Arrayer med information om flighterna. 
		String[] flightNo = 	{"BA1853", "AF3142", "TP0678", "SK5971"};
		String[] destination = 	{"London", "Paris", "Lisbon", "Gothenburg"};
		int[] depHour = 		{8, 8, 8, 8};
		int[] depMin = 			{10, 20, 35, 40};
		
//		Skapar koppling till klienten.
		ServerSocket serverSocket = new ServerSocket(11111);
		Socket socket = serverSocket.accept();
//		Gör det möjligt att skicka data till klienten.
		DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
		
//		Skickar informationen i arrayerna till klienten: 
		for (int i = 0; i < 4; i++) {
			toClient.writeUTF(flightNo[i]);
			toClient.writeUTF(destination[i]);
			toClient.writeInt(depHour[i]);
			toClient.writeInt(depMin[i]);
		}
		
		socket.close();
		serverSocket.close();
	}

}
