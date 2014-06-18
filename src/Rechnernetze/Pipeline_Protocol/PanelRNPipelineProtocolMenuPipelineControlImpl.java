package Rechnernetze.Pipeline_Protocol;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;

import Base.Management;
import Base.PanelMenuAbstract;
import Base.ToolTipManager;

public class PanelRNPipelineProtocolMenuPipelineControlImpl extends PanelMenuAbstract {

	
	
	public PanelRNPipelineProtocolMenuPipelineControlImpl(Management management, ToolTipManager tooltip) {
		super(management, tooltip);
		// TODO Auto-generated constructor stub
	}

	private JButton btnX00;
	private JButton btnX01;
	private JButton btnX02;
	private JButton btnX03;
	private JButton btnX04;
	private JButton btnX05;
	private JButton btnX06;
	private JButton btnX07;
	private JButton btnX08;
	private JButton btnX09;
	private JButton btnX10;
	private JButton btnX11;
	private JButton btnX12;
	private JButton btnX13;
	private JButton btnX14;
	private JButton btnX15;
	private JButton btnX16;
	private JButton btnX17;
	private JButton btnX18;
	private JButton btnX19;
	private JButton btnX20;
	private JButton btnX21;

	@Override
	public Integer getHeightMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initComponents() {
		
		
		btnX00 = new JButton("X");
		btnX01 = new JButton("X");
		btnX02 = new JButton("X");
		btnX03 = new JButton("X");
		btnX04 = new JButton("X");
		btnX05 = new JButton("X");
		btnX06 = new JButton("X");
		btnX07 = new JButton("X");
		btnX08 = new JButton("X");
		btnX09 = new JButton("X");
		btnX10 = new JButton("X");
		btnX11 = new JButton("X");
		btnX12 = new JButton("X");
		btnX13 = new JButton("X");
		btnX14 = new JButton("X");
		btnX15 = new JButton("X");
		btnX16 = new JButton("X");
		btnX17 = new JButton("X");
		btnX18 = new JButton("X");
		btnX19 = new JButton("X");
		btnX20 = new JButton("X");
		btnX21 = new JButton("X");
		
		
	}

	@Override
	protected void initLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnX00)
					.addComponent(btnX01)
					.addComponent(btnX02)
					.addComponent(btnX03)
					.addComponent(btnX04)
					.addComponent(btnX05)
					.addComponent(btnX06)
					.addComponent(btnX07)
					.addComponent(btnX08)
					.addComponent(btnX09)
					.addComponent(btnX10)
					.addComponent(btnX11)
					.addComponent(btnX12)
					.addComponent(btnX13)
					.addComponent(btnX14)
					.addComponent(btnX15)
					.addComponent(btnX16)
					.addComponent(btnX17)
					.addComponent(btnX18)
					.addComponent(btnX19)
					)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnX00)
						.addComponent(btnX01)
						.addComponent(btnX02)
						.addComponent(btnX03)
						.addComponent(btnX04)
						.addComponent(btnX05)
						.addComponent(btnX06)
						.addComponent(btnX07)
						.addComponent(btnX08)
						.addComponent(btnX09)
						.addComponent(btnX10)
						.addComponent(btnX11)
						.addComponent(btnX12)
						.addComponent(btnX13)
						.addComponent(btnX14)
						.addComponent(btnX15)
						.addComponent(btnX16)
						.addComponent(btnX17)
						.addComponent(btnX18)
						.addComponent(btnX19)
						)
					)
		);
		setLayout(groupLayout);
	}

}
