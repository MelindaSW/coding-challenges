package melindas;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MelindaSWUppg1Main {

	public static void main(String[] args) {
		
		InetAddress inetAddress;
		
		try {
			inetAddress = InetAddress.getByName("www.sunet.se");
			System.out.println(inetAddress.getHostAddress());
		}
		catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
