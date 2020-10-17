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


public class MelindaSInl20Ui extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton stBtn = new JButton();
	
	JPanel pnlMain = new JPanel();

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
	
	
	JLabel noTxt = new JLabel("NORR", JLabel.CENTER);
	JLabel soTxt = new JLabel("SÖDER", JLabel.CENTER);
	JLabel weTxt = new JLabel("VÄSTER", JLabel.CENTER);
	JLabel eaTxt = new JLabel("ÖSTER", JLabel.CENTER);
	
	
	JPanel pnlNo = new JPanel();
	JPanel pnlSo = new JPanel();
	JPanel pnlWe = new JPanel();
	JPanel pnlEa = new JPanel();
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints con;
	
	Font font = new Font("SansSerif", Font.BOLD, 16);

	ImageIcon off = new ImageIcon(getClass().getResource("/lights/off.png"));
	ImageIcon g = new ImageIcon(getClass().getResource("/lights/green.png"));
	ImageIcon y = new ImageIcon(getClass().getResource("/lights/yellow.png"));
	ImageIcon r = new ImageIcon(getClass().getResource("/lights/red.png"));
	ImageIcon start = new ImageIcon(getClass().getResource("/lights/start.png"));
	ImageIcon pause = new ImageIcon(getClass().getResource("/lights/pause.png"));


	JPanel soPnl = new JPanel();
	JPanel noPnl = new JPanel();

	MelindaSInl20NSLightActivity la;

	
	public MelindaSInl20Ui() {
		
		addComponents();
		
		setTitle("Traffic lights simulator");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(700, 900);
		
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
		// TODO Auto-generated method stub
		if (a.getActionCommand().equals("Start")) {
			
//			När knappen start trycks in så ska trådarna starta som slår av och på knapparna.
//				n1.setIcon(r);
//				n2.setIcon(y);
//				n3.setIcon(g);
//
//				s1.setIcon(r);
//				s2.setIcon(y);
//				s3.setIcon(g);
//				
//				e1.setIcon(r);
//				e2.setIcon(y);
//				e3.setIcon(g);
//
//				w1.setIcon(r);
//				w2.setIcon(y);
//				w3.setIcon(g);
//				la = new MelindaSInl20NSLightActivity();
			 	la.lightSwitch.start();
			
				stBtn.setActionCommand("Pause");
				stBtn.setIcon(pause);
			}
		else if (a.getActionCommand().equals("Pause")) {
			
//		    När knappen stop trycks in så ska alla knappar få en grå ikon. 
//				Och trådarna ska stoppas. 

				la.lightSwitch.interrupt();
			
				n1.setIcon(off);
				n2.setIcon(off);
				n3.setIcon(off);
				
				s1.setIcon(off);
				s2.setIcon(off);
				s3.setIcon(off);
				
				e1.setIcon(off);
				e2.setIcon(off);
				e3.setIcon(off);
				
				w1.setIcon(off);
				w2.setIcon(off);
				w3.setIcon(off);
				
				
				
				stBtn.setActionCommand("Start");
				stBtn.setIcon(start);
				
			}
		
	}
	
	

	
	

}























