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

import Base.PanelMenuAbstract;
import Base.PanelMenuButtonsAbstract;

public class PanelRNPipelineProtocolMenuImpl extends PanelMenuButtonsAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNPipelineProtocolMenuImpl(ManagementPipelineProtocol pipeline) {
		super(pipeline);
	}

	private PanelRNPipelineProtocolMenuImpl() {
		super(new ManagementPipelineProtocolImpl());
		this.initButtonts();
		this.initComponentsMenuButtons();
		this.initLayout();
	}
	
	@Override
	public Integer getPanelWidth() {
		return 170;
	}

	@Override
	public Integer getPanelHeight() {
		return 150;
	}
	
	private ManagementPipelineProtocol pipeline;

	//private JButton btnExampleReset;
	//private JButton btnAssumeInputExecute;
	
	private ComboBoxStrategy comboBox;
	private JButton btnTransmit;
	
	private void initButtonts() {
		btnExampleReset = new JButton("Reset");	
		btnAssumeSaveExecute = new JButton("Next");
	}
	
	@Override
	protected void initComponentsMenuButtons() {
		this.pipeline = (ManagementPipelineProtocol) this.getManagement();
		comboBox = new ComboBoxStrategy();
	}

	@Override
	protected void initLayout() {		
		
		btnTransmit = new JButton("Paket senden");
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
	protected void updatePanelMenuButtons() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initMethodsMenuButtons() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void loadExample() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void assume() {
		pipeline.assume();
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
