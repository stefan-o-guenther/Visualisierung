/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Pipeline_Protocol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.PanelMenuButtonsAbstract;

public class PanelRNPipelineProtocolMenuImpl extends PanelMenuButtonsAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNPipelineProtocolMenuImpl() {
		super(ManagementARQImpl.getInstance());
		//this.initializeExtra();
		this.createPanel();
	}
	
	private void initializeExtra() {		
		this.createMenuComponentsExtra();
		this.initButtons();
		this.createLayout();
	}
	
	@Override
	public Integer getPanelWidth() {
		return 170;
	}

	@Override
	public Integer getPanelHeight() {
		return 150;
	}
	
	private ManagementARQ pipeline;
	private ToolTipManagerARQ tooltip;

	//private JButton btnExampleReset;
	//private JButton btnAssumeInputExecute;
	
	private ComboBoxStrategy comboBox;
	private JButton btnTransmit;
	
	private void initButtons() {
		btnExampleReset = new JButton("Reset");	
		btnAssumeSaveExecute = new JButton("Next");
	}
	
	@Override
	protected void createMenuComponentsExtra() {
		this.pipeline = ManagementARQImpl.getInstance();
		this.tooltip = ToolTipManagerARQImpl.getInstance();
		
		this.comboBox = new ComboBoxStrategy();
		this.btnTransmit = new JButton("Paket senden");
	}

	@Override
	protected void createLayout() {	
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAssumeSaveExecute, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExampleReset, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTransmit, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(281, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAssumeSaveExecute)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExampleReset)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnTransmit)
					.addContainerGap(99, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}	

	@Override
	protected void updatePanelExtra() {
		this.btnTransmit.setEnabled(pipeline.canSendPacket());
	}

	@Override
	protected void createMenuMethodsExtra() {
		ActionListener actionSendPacket = new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				pipeline.sendPacket();
			}
		};
		
		this.btnTransmit.addActionListener(actionSendPacket);
	}

	@Override
	protected void loadExample() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void assume() {
		pipeline.assume(this.comboBox.getStrategy());
	}

	@Override
	protected void clearFields() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void executeExtra() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Boolean hasExample() {
		return false;
	}

	@Override
	protected void input() {
		
	}
}
