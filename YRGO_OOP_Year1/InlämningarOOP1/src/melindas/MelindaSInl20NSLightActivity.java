package melindas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

// Trådklass för trafikljusen i norr och söder. 

public class MelindaSInl20NSLightActivity implements Runnable {

	ImageIcon r;
	ImageIcon y;
	ImageIcon g;
	ImageIcon off;
	JLabel n1;
	JLabel n2;
	JLabel n3;
	JLabel s1;
	JLabel s2;
	JLabel s3;
	
	public MelindaSInl20NSLightActivity(ImageIcon r, ImageIcon y, ImageIcon g, ImageIcon off,
										JLabel n1, JLabel n2, JLabel n3,
										JLabel s1, JLabel s2, JLabel s3) {
		this.r = r;
		this.y = y;
		this.g = g;
		this.off = off;
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
	}
	
	public Thread lightSwitch = new Thread(this);

	@Override
	public void run() {

		while (!lightSwitch.isInterrupted()) {
			
			try {
				n1.setIcon(off);
				s1.setIcon(off);

				n3.setIcon(g);
				s3.setIcon(g);
				
				Thread.sleep(4000);
				
				n3.setIcon(off);
				s3.setIcon(off);
				
				n2.setIcon(y);
				s2.setIcon(y);

				Thread.sleep(2000);
				
				n2.setIcon(off);
				s2.setIcon(off);
				
				n1.setIcon(r);
				s1.setIcon(r);
				
				Thread.sleep(8000);
			} 
			catch (InterruptedException e) {
				
				n1.setIcon(off);
				n2.setIcon(off);
				n3.setIcon(off);
				
				s1.setIcon(off);
				s2.setIcon(off);
				s3.setIcon(off);
				
				break;
			}
		}
	}

}
