/**
 * @author:	Stefan Otto G�nther
 * @date:	14.01.2014
 */

package Visualisierungen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Base.FrameAbstract;
import Betriebssysteme.Belegungsstrategien.PanelBSBelegungsstrategienMainImpl;
import Betriebssysteme.Buddy_Systeme.PanelBSBuddySystemeMainImpl;
import Betriebssysteme.Seitenersetzungsstrategien.PanelBSSeitenersetzungsstrategienMainImpl;
import Rechnernetze.Congestion_Avoidance.PanelRNCongestionAvoidanceMainImpl;
import Rechnernetze.Dijkstra_Algorithmus.Version_B.PanelRNDijkstraAlgorithmMainImpl;
import Rechnernetze.Pipeline_Protocol.PanelRNPipelineProtocolMainImpl;
import Rechnernetze.Queueing_And_Loss.PanelRNQueueingAndLossMainImpl;
import Rechnernetze.TCP_Fairness.PanelRNTCPFairnessMainImpl;

public class FrameDefaultImpl extends FrameAbstract {
	
	private static final long serialVersionUID = 1L;

	private JPanel globalPanel = new PanelDefaultMainImpl();	
	
	public FrameDefaultImpl() {	
		super(new PanelDefaultMainImpl());
		showMenuBar();
		pack();
		this.showNewPanel(new PanelDefaultMainImpl());
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
		
		// Men�leiste
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
			showNewPanel(new PanelDefaultMainImpl());
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
			showNewPanel(new PanelBSBelegungsstrategienMainImpl());
		}
	};
	
	private ActionListener BS_Buddy_Systeme = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			showNewPanel(new PanelBSBuddySystemeMainImpl());
		}
	};
	
	private ActionListener BS_Seitenersetzungsstrategien = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			showNewPanel(new PanelBSSeitenersetzungsstrategienMainImpl());
		}
	};
	
	private ActionListener BS_Verklemmungen = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
		
		}
	};	
	
	// Rechnernetze
	private ActionListener RN_Congestion_Avoidance = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			showNewPanel(new PanelRNCongestionAvoidanceMainImpl());
		}
	};
	
	private ActionListener RN_Dijkstra = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			showNewPanel(new PanelRNDijkstraAlgorithmMainImpl());
		}
	};
	
	private ActionListener RN_Pipeline_Protocol = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			showNewPanel(new PanelRNPipelineProtocolMainImpl());
		}
	};
	
	private ActionListener RN_Queueing_And_Loss = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			showNewPanel(new PanelRNQueueingAndLossMainImpl());
		}
	};
	
	private ActionListener RN_TCP_Retransmission = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
	
		}
	};
	
	private ActionListener RN_TCP_Fairness = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			showNewPanel(new PanelRNTCPFairnessMainImpl());
		}
	};
}
