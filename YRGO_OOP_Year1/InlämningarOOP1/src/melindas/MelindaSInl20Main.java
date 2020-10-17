package melindas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;



public class MelindaSInl20Main extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	Paus och start knappen:
	JButton stBtn = new JButton();
//	Panelen som läggs in i ramen:
	JPanel pnlMain = new JPanel();
	
//	Labels för trafikljusen:
	JLabel n1 = new JLabel();
	JLabel n2 = new JLabel();
	JLabel n3 = new JLabel();
	
	JLabel s1 = new JLabel();
	JLabel s2 = new JLabel();
	JLabel s3 = new JLabel();
	
	JLabel e1 = new JLabel();
	JLabel e2 = new JLabel();
	JLabel e3 = new JLabel();
	
	JLabel w1 = new JLabel();
	JLabel w2 = new JLabel();
	JLabel w3 = new JLabel();
	
//	Labels för texten ovanför trafikljusen:
	JLabel noTxt = new JLabel("NORR", JLabel.CENTER);
	JLabel soTxt = new JLabel("SÖDER", JLabel.CENTER);
	JLabel weTxt = new JLabel("VÄSTER", JLabel.CENTER);
	JLabel eaTxt = new JLabel("ÖSTER", JLabel.CENTER);
	
//	Paneler för trafikljusen:
	JPanel pnlNo = new JPanel();
	JPanel pnlSo = new JPanel();
	JPanel pnlWe = new JPanel();
	JPanel pnlEa = new JPanel();
	
//	Gridbaglayout för mainpanelen:
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints con;
//	
	Font font = new Font("SansSerif", Font.BOLD, 16);
	
	JPanel soPnl = new JPanel();
	JPanel noPnl = new JPanel();
	
	MelindaSInl20NSLightActivity ns;
	MelindaSInl20EWLightActivity ew;

	
	ImageIcon off = new ImageIcon(getClass().getResource("off.png"));
	ImageIcon g = new ImageIcon(getClass().getResource("green.png"));
	ImageIcon y = new ImageIcon(getClass().getResource("yellow.png"));
	ImageIcon r = new ImageIcon(getClass().getResource("red.png"));
	
	ImageIcon start = new ImageIcon(getClass().getResource("start.png"));
	ImageIcon pause = new ImageIcon(getClass().getResource("pause.png"));
	
	
	public MelindaSInl20Main() {
		
		addComponents();
		
		setTitle("Traffic lights simulator");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(700, 900);
	
	}
	

	public static void main(String[] args) {

		MelindaSInl20Main ms = new MelindaSInl20Main();
		
		
		
	}

	
	private void addComponents() {
//		Lägg till GridBagLayout i mainpanelen. 
		pnlMain.setLayout(gbl);
		
		
//		NORR:
		con = new GridBagConstraints();
		pnlNo.setLayout(new GridLayout(4,1));
		noTxt.setFont(font);
		pnlNo.add(noTxt); 
		n1.setIcon(off);
		n2.setIcon(off);
		n3.setIcon(off);
		pnlNo.add(n1); 
		pnlNo.add(n2); 
		pnlNo.add(n3);
		con.gridy = 1;
		con.gridx = 1;
		con.weighty = 1;
		con.weightx = 1;
		con.anchor = GridBagConstraints.NORTH;
		gbl.setConstraints(pnlNo, con);
		
		pnlMain.add(pnlNo);
		
		

//		SÖDER:
		con = new GridBagConstraints();
		pnlSo.setLayout(new GridLayout(4,1));
		soTxt.setFont(font);
		pnlSo.add(soTxt);
		s1.setIcon(off);
		s2.setIcon(off);
		s3.setIcon(off);
		pnlSo.add(s1); 
		pnlSo.add(s2); 
		pnlSo.add(s3);
		con.gridy = 3;
		con.gridx = 1;
		con.weighty = 1;
		con.weightx = 1;
		con.anchor = GridBagConstraints.SOUTH;
		gbl.setConstraints(pnlSo, con);

		pnlMain.add(pnlSo);
		

		
//		ÖSTER:
		con = new GridBagConstraints();
		pnlEa.setLayout(new GridLayout(4,1));
		eaTxt.setFont(font);
		pnlEa.add(eaTxt);
		e1.setIcon(off);
		e2.setIcon(off);
		e3.setIcon(off);
		pnlEa.add(e1); 
		pnlEa.add(e2); 
		pnlEa.add(e3);
		con.gridy = 2;
		con.gridx = 2;
		con.weighty = 1;
		con.weightx = 1;
		con.anchor = GridBagConstraints.EAST;
		gbl.setConstraints(pnlEa, con);
		
		pnlMain.add(pnlEa);

		
		
//		VÄSTER:
		con = new GridBagConstraints();
		pnlWe.setLayout(new GridLayout(4,1));
		weTxt.setFont(font);
		pnlWe.add(weTxt); 
		w1.setIcon(off);
		w2.setIcon(off);
		w3.setIcon(off);
		pnlWe.add(w1); 
		pnlWe.add(w2); 
		pnlWe.add(w3);
		con.gridy = 2;
		con.gridx = 0;
		con.weighty = 1;
		con.weightx = 1;
		con.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(pnlWe, con);
		pnlMain.add(pnlWe);
		
		
		
//		START/STOP button:
		stBtn.setFont(font);
		stBtn.setBackground(Color.LIGHT_GRAY);
		stBtn.setForeground(Color.DARK_GRAY);
		stBtn.setIcon(start);
		stBtn.setBorder(new BevelBorder(BevelBorder.RAISED));
		stBtn.setActionCommand("Start");
		stBtn.addActionListener(this);
		con = new GridBagConstraints();
		con.gridy = 3;
		con.gridx = 0;
		con.weighty = 1;
		con.weightx = 1;
		con.anchor = GridBagConstraints.SOUTHWEST;
		gbl.setConstraints(stBtn, con);
		pnlMain.add(stBtn);

		pnlMain.setBorder(new CompoundBorder(new LineBorder(Color.DARK_GRAY, 10), new EtchedBorder(EtchedBorder.RAISED)));
		add(pnlMain);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent a) {
		
		if (a.getActionCommand().equals("Start")) {
			
//			När knappen start trycks in så ska trådarna starta som slår av och på knapparna.
			
				ns = new MelindaSInl20NSLightActivity(r, y, g, off, n1, n2, n3, s1, s2, s3);
				ew = new MelindaSInl20EWLightActivity(r, y, g, off, e1, e2, e3, w1, w2, w3);

				ew.lightSwitch.start();
			 	ns.lightSwitch.start();
			
				stBtn.setActionCommand("Pause");
				stBtn.setIcon(pause);
			
		}
		else if (a.getActionCommand().equals("Pause")) {
			
//		    När knappen stop trycks in så ska alla knappar få en grå ikon.
//			Ikonen får en pausikon.
//			Och trådarna avbryts. 

				ns.lightSwitch.interrupt();
				ew.lightSwitch.interrupt();
				
				stBtn.setActionCommand("Start");
				stBtn.setIcon(start);
				
			}
		
	}
	

}
