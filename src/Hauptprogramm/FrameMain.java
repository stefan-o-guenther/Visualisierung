package Hauptprogramm;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;

import Betriebssysteme.Belegungsstrategien.PanelBSBelegungsstrategien;
import Betriebssysteme.Buddy_Systeme.PanelBSBuddySysteme;
import Betriebssysteme.Seitenersetzungsstrategien.PanelBSSeitenersetzungsstrategien;
import Betriebssysteme.Verklemmungen.PanelBSVerklemmungen;

public class FrameMain extends JFrame {
	
	private final int LENGTH = 1024;
	private final int HEIGHT = 768;

	private JPanel globalPanel = new PanelDefault();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ToolTipManager.sharedInstance().setDismissDelay(2147483647);
        ToolTipManager.sharedInstance().setInitialDelay(0);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMain fm = new FrameMain();
					fm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public FrameMain() {
		super("FrameMain");
		initUI();
	}
	
	
	private void showMenuBar() {	
        
		// Programm
		
        JMenu pr = new JMenu("Programm");
        
        JMenuItem miStart = new JMenuItem("Start");
        JMenuItem miBeenden = new JMenuItem("Beenden");
        
        miStart.addActionListener(PR_Start);
        miBeenden.addActionListener(PR_Beenden);        
        
        pr.add(miStart);
        pr.add(miBeenden);
        
        
        // Betriebssysteme
        
        JMenu bs = new JMenu("Betriebssysteme");
        
        JMenuItem miBelegung = new JMenuItem("Belegungsstrategien");
        JMenuItem miBuddy = new JMenuItem("Buddy Systeme");
        JMenuItem miSeiten = new JMenuItem("Seitenersetzungsstrategien");        
        JMenuItem miVerklemmung = new JMenuItem("Verklemmungen");
        
        miBelegung.addActionListener(BS_Belegungsstrategien);
        miBuddy.addActionListener(BS_Buddy_Systeme);
        miSeiten.addActionListener(BS_Seitenersetzungsstrategien);
        miVerklemmung.addActionListener(BS_Verklemmungen);       
        
        bs.add(miBelegung);
        bs.add(miBuddy);
        bs.add(miSeiten);
        bs.add(miVerklemmung);
        
        
        // Rechnernetze
        
        JMenu rn = new JMenu("Rechnernetze");
        
        JMenuItem miCongestion = new JMenuItem("Congestion Avoidance");
        JMenuItem miDijkstra = new JMenuItem("Dijkstra");
        JMenuItem miPipeline = new JMenuItem("Pipeline Protocol");
        JMenuItem miQueueing = new JMenuItem("Queueing And Loss");
        JMenuItem miRetransmission = new JMenuItem("TCP-Retransmission");
        JMenuItem miFairness = new JMenuItem("TCP-Fairness");
        
        miCongestion.addActionListener(RN_Congestion_Avoidance);
        miDijkstra.addActionListener(RN_Dijkstra);
        miPipeline.addActionListener(RN_Pipeline_Protocol);
        miQueueing.addActionListener(RN_Queueing_And_Loss);
        miRetransmission.addActionListener(RN_TCP_Retransmission);
        miFairness.addActionListener(RN_TCP_Fairness);
        
        rn.add(miCongestion);
        rn.add(miDijkstra);
        rn.add(miPipeline);
        rn.add(miQueueing);
        rn.add(miRetransmission);
        rn.add(miFairness);
        
        
        // Menüleiste
     	JMenuBar menuBar = new JMenuBar();
        
        menuBar.add(pr);
        menuBar.add(bs);
        menuBar.add(rn);
        
        setJMenuBar(menuBar);
	}
	
	private void showWindowCenterScreen() {
		// Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
         
        // Determine the new location of the window
        int w = getSize().width;
        int h = getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
         
        // Move the window
        setLocation(x, y); 
	}
	
	private void initWindowSize() {
		setSize(LENGTH, HEIGHT);
	}

	private void initUI() {
        setTitle("Bachelorarbeit - Visualisierung");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        showMenuBar();        
        pack();
        initWindowSize();
        showWindowCenterScreen();
        add(globalPanel);        
    }
	
	private void showNewPanel(JPanel panel) {
		remove(globalPanel);
		globalPanel = panel;
		globalPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); 
        add(globalPanel); //, BorderLayout.CENTER);
        revalidate();
        repaint();
        pack();
        initWindowSize();
        showWindowCenterScreen();
	}
	
	
	
	// Programm
	
	ActionListener PR_Start = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			showNewPanel(new PanelDefault());
		}
	};
	
	ActionListener PR_Beenden = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			System.exit( 0 );
		}
	};
	
	
	
	// Betriebssysteme
	
	ActionListener BS_Belegungsstrategien = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			showNewPanel(new PanelBSBelegungsstrategien());
		}
	};
	
	ActionListener BS_Buddy_Systeme = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			showNewPanel(new PanelBSBuddySysteme());
		}
	};
	
	ActionListener BS_Seitenersetzungsstrategien = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			showNewPanel(new PanelBSSeitenersetzungsstrategien());
		}
	};
	
	ActionListener BS_Verklemmungen = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			showNewPanel(new PanelBSVerklemmungen());			
		}
	};
	
	
	
	// Rechnernetze
	
	ActionListener RN_Congestion_Avoidance = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			
		}
	};
	
	ActionListener RN_Dijkstra = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			
		}
	};
	
	ActionListener RN_Pipeline_Protocol = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			
		}
	};
	
	ActionListener RN_Queueing_And_Loss = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			
		}
	};
	
	ActionListener RN_TCP_Retransmission = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			
		}
	};
	
	ActionListener RN_TCP_Fairness = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			
		}
	};
	
	
}
