/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Hauptprogramm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Base.BaseFrame;
import Betriebssysteme.Belegungsstrategien.PanelBSBelegungsstrategienMain;
import Betriebssysteme.Buddy_Systeme.PanelBSBuddySystemeMain;
import Betriebssysteme.Seitenersetzungsstrategien.PanelBSSeitenersetzungsstrategienMain;
import Rechnernetze.Dijkstra.PanelRNDijkstraMain;

public class FrameMain extends BaseFrame {
	
	private JPanel globalPanel = new PanelDefaultMain();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameMain());	
	}
	
	/**
	 * Create the frame.
	 */
	public FrameMain() {	
		super("Bachelorarbeit - Visualisierung");
		showMenuBar();        
        pack();
        initUI(globalPanel);
        
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
	
	private ActionListener PR_Start = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			showNewPanel(new PanelDefaultMain());
		}
	};
	
	private ActionListener PR_Beenden = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			System.exit(0);
		}
	};	
	
	// Betriebssysteme
	
	private ActionListener BS_Belegungsstrategien = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			showNewPanel(new PanelBSBelegungsstrategienMain());
		}
	};
	
	private ActionListener BS_Buddy_Systeme = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			showNewPanel(new PanelBSBuddySystemeMain());
		}
	};
	
	private ActionListener BS_Seitenersetzungsstrategien = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			showNewPanel(new PanelBSSeitenersetzungsstrategienMain());
		}
	};
	
	private ActionListener BS_Verklemmungen = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
						
		}
	};	
	
	// Rechnernetze
	
	private ActionListener RN_Congestion_Avoidance = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			
		}
	};
	
	private ActionListener RN_Dijkstra = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			showNewPanel(new PanelRNDijkstraMain());
		}
	};
	
	private ActionListener RN_Pipeline_Protocol = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			
		}
	};
	
	private ActionListener RN_Queueing_And_Loss = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			
		}
	};
	
	private ActionListener RN_TCP_Retransmission = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			
		}
	};
	
	private ActionListener RN_TCP_Fairness = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			
		}
	};
}
