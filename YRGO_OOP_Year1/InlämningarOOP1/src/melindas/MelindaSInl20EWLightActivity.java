package melindas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//  Trådklass för trafikljusen i öster och väster. 
public class MelindaSInl20EWLightActivity implements Runnable {
	
	ImageIcon r;
	ImageIcon y;
	ImageIcon g;
	ImageIcon off;
	JLabel e1;
	JLabel e2;
	JLabel e3;
	JLabel w1;
	JLabel w2;
	JLabel w3;
	
	public MelindaSInl20EWLightActivity(ImageIcon r, ImageIcon y, ImageIcon g, ImageIcon off,
										JLabel e1, JLabel e2, JLabel e3,
										JLabel w1, JLabel w2, JLabel w3) {
		this.r = r;
		this.y = y;
		this.g = g;
		this.off = off;
		this.e1 = e1;
		this.e2 = e2;
		this.e3 = e3;
		this.w1 = w1;
		this.w2 = w2;
		this.w3 = w3;
	}
	
	public Thread lightSwitch = new Thread(this);

	@Override
	public void run() {

		while (!lightSwitch.isInterrupted()) {
			
			try {
				e2.setIcon(off);
				w2.setIcon(off);

				e1.setIcon(r);
				w1.setIcon(r);
				
				Thread.sleep(8000);
				
				e1.setIcon(off);
				w1.setIcon(off);
				
				e3.setIcon(g);
				w3.setIcon(g);

				Thread.sleep(4000);
				
				e3.setIcon(off);
				w3.setIcon(off);
				
				e2.setIcon(y);
				w2.setIcon(y);
				
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) {
				
				e1.setIcon(off);
				e2.setIcon(off);
				e3.setIcon(off);
				
				w1.setIcon(off);
				w2.setIcon(off);
				w3.setIcon(off);
				
				break;
			}
		}
	}
}
