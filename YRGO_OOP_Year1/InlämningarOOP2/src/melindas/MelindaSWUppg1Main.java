package melindas;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MelindaSWUppg1Main {

	public static void main(String[] args) {
		
		InetAddress inetAddress;
		
		try {
			inetAddress = InetAddress.getByName("www.sunet.se");
			
//			Alternativ 1:
//			Metoden getHostAdress() returnerar en string med adressens ip nr. 
//			System.out.println(inetAddress.getHostAddress());
			
//			Alternativ 2:
//			Använder maskning vid konverteringen av byte till int.
			
			byte[] ba = inetAddress.getAddress();
			String ip = "";
			
			for (int i = 0; i < ba.length; i++) {
				
				int x = (int) ba[i] & 0xFF;
				ip += x + ".";
			}
			System.out.println(ip.substring(0, ip.length() - 1));
		}
		catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
