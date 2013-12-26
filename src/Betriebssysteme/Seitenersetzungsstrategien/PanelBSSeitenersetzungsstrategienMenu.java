package Betriebssysteme.Seitenersetzungsstrategien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.BasePanelMenu;

public class PanelBSSeitenersetzungsstrategienMenu extends BasePanelMenu {;
	
	private String sToolTipStrategie = "";
	private String sToolTipReferenzfolge = "";
	private String sToolTipRam = "";
	private String sToolTipDisk = "";
	private String sToolTipR = "";
	private String sToolTipM = "";
	
	private JLabel lblStrategie;
	private JLabel lblReferenzfolge;
	private JLabel lblRam;
	private JLabel lblDisk;	
	private JTextField tfReferezfolge;
	private JTextField tfDisk;
	private JTextField tfRam;
	private JLabel lblToolTipR;
	private JLabel lblToolTipM;
	private JComboBox cbStrategie;
	private JButton btnExecute2;
	private JButton btnExecute1;
	private JButton btnR;
	private JButton btnM;
		
	
	private IPagingManagement paging;
	
	//private JPanel panel;	

	//@Override
	protected void updateComponents() {
		EnumPagingStatus status = paging.getStatus();
		switch (status) {
			case START: {
				
			}
			case SEARCH: {
				
			}
			case FINISHED: {
				
			}
		}
	}
	
	//@Override
	protected void initComponents() {		
		initToolTips();
				
		lblStrategie = new JLabel("Strategie:");
		lblStrategie.setIcon(IMG_HELP);
		lblStrategie.setToolTipText(sToolTipStrategie);
		
		lblReferenzfolge = new JLabel("Referenzfolge:");
		lblReferenzfolge.setIcon(IMG_HELP);
		lblReferenzfolge.setToolTipText(sToolTipReferenzfolge);
		
		tfReferezfolge = new JTextField();
		tfReferezfolge.setColumns(10);
		
		cbStrategie = new JComboBox();
		cbStrategie.setModel(new DefaultComboBoxModel(new String[] {"Optimale Strategie", "FIFO", "FIFO - 2nd Chance", "LRU", "NFU / LFU", "NRU/RNU"}));
		
		lblRam = new JLabel("Anzahl RAM:");
		lblRam.setIcon(IMG_HELP);
		lblRam.setToolTipText(sToolTipRam);
		
		lblDisk = new JLabel("Anzahl DISK:");
		lblDisk.setIcon(IMG_HELP);
		lblDisk.setToolTipText(sToolTipDisk);
		
		tfDisk = new JTextField();
		tfDisk.setColumns(10);
		
		tfRam = new JTextField();
		tfRam.setColumns(10);
		
		btnExecute1 = new JButton("Beispiel laden");
		btnExecute1.addActionListener(ActionExecute1);
		
		btnExecute2 = new JButton("übernehmen");
		btnExecute2.addActionListener(ActionExecute2);		
		
		btnR = new JButton("R-Bits zurücksetzen");
		btnR.addActionListener(ActionResetR);
		
		btnM = new JButton("M-Bit setzen");
		btnM.addActionListener(ActionSetM);
		
		lblToolTipR = new JLabel(" ");
		lblToolTipR.setIcon(IMG_HELP);
		lblToolTipR.setToolTipText(sToolTipR);
		
		lblToolTipM = new JLabel(" ");
		lblToolTipM.setIcon(IMG_HELP);
		lblToolTipM.setToolTipText(sToolTipM);
				
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblReferenzfolge)
						.addComponent(lblStrategie))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(tfReferezfolge)
						.addComponent(cbStrategie, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblDisk, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblRam, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(tfDisk, 0, 0, Short.MAX_VALUE)
						.addComponent(tfRam, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnExecute2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnExecute1, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblToolTipR)
						.addComponent(lblToolTipM))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnM, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnR, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(194, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblStrategie)
							.addComponent(cbStrategie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblRam)
							.addComponent(tfRam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnExecute1))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnR)
							.addComponent(lblToolTipR)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReferenzfolge)
						.addComponent(tfReferezfolge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDisk)
						.addComponent(tfDisk, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExecute2)
						.addComponent(btnM)
						.addComponent(lblToolTipM))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
	
	/**
	 * Create the panel.
	 * @param panelModel 
	 */
	public PanelBSSeitenersetzungsstrategienMenu(IPagingManagement ipaging) {		
		if (ipaging == null) {
			ipaging = new PagingManagement();
		}
		paging = ipaging;
		initComponents();
	}	
	
	@Override
	protected void initToolTips() {
		
		



		
		
		sToolTipStrategie = 	
	        	  "<html>"
		    	+ "<h3>:</h3>"
		    	+ "<br>"
		    	+ "<br>"
		    	+ "<br>"
		    	+ "<h3>:</h3>"
		    	+ "<br>"
		    	+ "<br>"		    	
		    	+ "<br>"
		    	+ "<br>"
		    	+ "</html>";
		
		sToolTipReferenzfolge = "";
		sToolTipRam = "";
		sToolTipDisk = "";
	}
	
	ActionListener ActionExecute1 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			// Beispiel laden und Reset
			paging.loadExample();
		}
	};
	
	ActionListener ActionExecute2 = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			// Starten und Weiter
			paging.execute();
		}
	};
	
	ActionListener ActionResetR = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			
		}
	};

	ActionListener ActionSetM = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			
		}
	};
}
