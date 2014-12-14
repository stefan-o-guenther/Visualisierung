package Rechnernetze.Pipeline_Protocol;

import Base.ManagementFactory;
import Base.PanelLayoutAbstract;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

public class PanelRNPipelineProtocolMessageImpl extends PanelLayoutAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNPipelineProtocolMessageImpl() {
		super();
		//this.createExtra();
		this.createPanel();
	}
	
	private void createExtra() {
		this.createComponents();
		this.createLayout();
	}

	private ManagementAutomaticRepeatRequest pipeline;
	private JLabel lblMessage;
	
	@Override
	protected void createComponents() {
		pipeline = ManagementFactory.getManagementAutomaticRepeatRequest();
		lblMessage = new JLabel(" ");
	}

	@Override
	protected void createLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMessage)
					.addContainerGap(394, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMessage)
					.addContainerGap(275, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	@Override
	public void updatePanel() {
		lblMessage.setText(pipeline.getMessage() + " ");
	}

	@Override
	public Integer getPanelHeight() {
		return 30;
	}

	@Override
	public Integer getPanelWidth() {
		return 100;
	}
}
