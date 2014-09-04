package Rechnernetze.Pipeline_Protocol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.PanelMenuAbstract;

public class PanelRNPipelineProtocolMenuAutomaticMenuMenuImpl extends PanelMenuAbstract {

	public PanelRNPipelineProtocolMenuAutomaticMenuMenuImpl(ManagementPipelineProtocol pipeline) {
		super(pipeline);
	}

	private PanelRNPipelineProtocolMenuAutomaticMenuMenuImpl() {
		super(new ManagementPipelineProtocolImpl());		
		this.initComponents();
		this.initLayout();
	}
	
	@Override
	public Integer getPanelWidth() {
		return 400;
	}

	@Override
	public Integer getPanelHeight() {
		return 100;
	}

	@Override
	public void updatePanel() {
		// TODO Auto-generated method stub
		
	}
	
	private JButton btn1;	
	private JButton btn2;
	private ManagementPipelineProtocol pipeline;

	@Override
	protected void initComponentsMenu() {
		pipeline = (ManagementPipelineProtocol) this.getManagement();
		btn1 = new JButton("test");		
		btn2 = new JButton("New button");		
	}

	@Override
	protected void initLayout() {
		
		ComboBoxStrategy comboBox = new ComboBoxStrategy();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn2)
					.addContainerGap(402, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn1)
						.addComponent(btn2))
					.addContainerGap(266, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	

	@Override
	protected void initMethods() {
		ActionListener ActionExecute = new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				try {
					if (pipeline != null) {
						pipeline.executeNormal();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		};
		
		btn1.addActionListener(ActionExecute);
	}
}
