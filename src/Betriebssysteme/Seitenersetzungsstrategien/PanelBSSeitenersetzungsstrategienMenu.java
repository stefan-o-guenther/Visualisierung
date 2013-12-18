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
	private JLabel lblStrategie;
	private JLabel lblReferenzfolge;
	private JTextField tfReferezfolge;
	private JTextField tfDisk;
	private JTextField tfRam;
	
	protected ButtonGroup groupColor = new ButtonGroup();
	
	private IPaging paging = new Paging();
	
	//private JPanel panel;	

	//@Override
	protected void updateComponents() {
		// TODO Auto-generated method stub
		
	}
	
	//@Override
	protected void initComponents() {		
		initToolTips();
		
		//panel = new PanelBSSeitenersetzungsstrategienModel();
		
		lblStrategie = new JLabel("Strategie:");
		lblStrategie.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\img\\help16x16.png"));
		
		lblReferenzfolge = new JLabel("Referenzfolge:");
		lblReferenzfolge.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\img\\help16x16.png"));
		
		tfReferezfolge = new JTextField();
		tfReferezfolge.setColumns(10);
		
		JComboBox cbStrategie = new JComboBox();
		cbStrategie.setModel(new DefaultComboBoxModel(new String[] {"Optimale Strategie", "FIFO", "FIFO - 2nd Chance"}));
		
		JLabel lblRam = new JLabel("Anzahl RAM:");
		lblRam.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\img\\help16x16.png"));
		
		JLabel lblDisk = new JLabel("Anzahl DISK:");
		lblDisk.setIcon(new ImageIcon("C:\\Eclipse\\Workspace\\Visualisierung\\img\\help16x16.png"));
		
		tfDisk = new JTextField();
		tfDisk.setColumns(10);
		
		tfRam = new JTextField();
		tfRam.setColumns(10);
		
		JButton btnExecute = new JButton("\u00FCbernehmen");
		btnExecute.addActionListener(ActionExecute);
		
		JButton btnReset = new JButton("zur\u00FCcksetzen");
		
		JButton btnR = new JButton("R-Bits zur\u00FCcksetzen");
		
		JButton btnM = new JButton("M-Bit setzen");
		//panel = new JPanel();
		
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
						.addComponent(btnExecute, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnM, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnR, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(173, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStrategie)
						.addComponent(cbStrategie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRam)
						.addComponent(tfRam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnReset)
						.addComponent(btnR))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReferenzfolge)
						.addComponent(tfReferezfolge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDisk)
						.addComponent(tfDisk, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExecute)
						.addComponent(btnM))
					.addContainerGap(395, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
	
	/**
	 * Create the panel.
	 * @param panelModel 
	 */
	public PanelBSSeitenersetzungsstrategienMenu(PanelBSSeitenersetzungsstrategienModel panelModel) {		
		super(panelModel);
		initComponents();
	}
	
	ActionListener ActionExecute = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			//paging.execute();
			//panel.drawListSpace(paging.getListCache(),paging.getMaxRam(), paging.getMaxDisk());
		}
	};

	@Override
	protected void updateModel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initToolTips() {
		// TODO Auto-generated method stub
		
	}

	
}
