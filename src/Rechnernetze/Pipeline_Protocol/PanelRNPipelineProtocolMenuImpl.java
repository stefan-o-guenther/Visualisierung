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

import Base.EnumVisualizationStatus;
import Base.ManagementFactory;
import Base.PanelMenuButtonsAbstract;

public class PanelRNPipelineProtocolMenuImpl extends PanelMenuButtonsAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNPipelineProtocolMenuImpl() {
		super(ManagementFactory.getManagementAutomaticRepeatRequest());
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
		return 160;
	}

	@Override
	public Integer getPanelHeight() {
		return 140;
	}
	
	private ManagementAutomaticRepeatRequest pipeline;
	private ToolTipManagerARQ tooltip;

	//private JButton btnExampleReset;
	//private JButton btnAssumeSaveExecute;
	
	private ComboBoxStrategy cbStategy;
	private JButton btnTransmit;
	
	private void initButtons() {
		btnExampleReset = new JButton("Reset");	
		btnAssumeSaveExecute = new JButton("Next");
	}
	
	@Override
	protected void createMenuComponentsExtra() {
		this.pipeline = ManagementFactory.getManagementAutomaticRepeatRequest();
		this.tooltip = ToolTipManagerARQImpl.getInstance();
		
		this.cbStategy = new ComboBoxStrategy();
		this.btnTransmit = new JButton("Paket senden");
	}

	@Override
	protected void createLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(cbStategy, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
						.addComponent(btnAssumeSaveExecute, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
						.addComponent(btnExampleReset, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
						.addComponent(btnTransmit, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(cbStategy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
		EnumVisualizationStatus status = pipeline.getStatus();
		switch (status) {
			case START: {
				this.btnTransmit.setEnabled(false);
				this.cbStategy.setEnabled(true);
				break;
			}
			case RUN: {
				this.btnTransmit.setEnabled(pipeline.isAutomaticPlay() && pipeline.canSendPacket());
				this.cbStategy.setEnabled(false);
				break;
			}
			case FINISHED: {
				this.btnTransmit.setEnabled(false);
				this.cbStategy.setEnabled(false);
				break;
			}
			default: {
				break;
			}
		}		
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
		
	}

	@Override
	protected void assume() {
		pipeline.assume(this.cbStategy.getStrategy());
	}

	@Override
	protected void clearFields() {
		
	}

	@Override
	protected void executeExtra() {
		
	}

	@Override
	protected Boolean hasExample() {
		return false;
	}

	@Override
	protected void input() {
		
	}
}
