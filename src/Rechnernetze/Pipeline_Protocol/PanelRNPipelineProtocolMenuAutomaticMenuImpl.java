package Rechnernetze.Pipeline_Protocol;

import Base.PanelMenuAutomaticMenuAbstract;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;

public class PanelRNPipelineProtocolMenuAutomaticMenuImpl extends PanelMenuAutomaticMenuAbstract {

	public PanelRNPipelineProtocolMenuAutomaticMenuImpl(ManagementPipelineProtocol pipeline, ToolTipManagerPipelineProtocol tooltip) {
		super(pipeline, tooltip);
		// TODO Auto-generated constructor stub
	}
	
	private PanelRNPipelineProtocolMenuAutomaticMenuImpl() {
		super(new ManagementPipelineProtocolImpl(), new ToolTipManagerPipelineProtocolImpl());
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(876, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
		);
		
		JLabel lblPacket = new JLabel("Paket");
		lblPacket.setIcon(new ImageIcon(PanelRNPipelineProtocolMenuAutomaticMenuImpl.class.getResource("/Base/img/boxCyan.png")));
		
		JLabel lblPacketReceived = new JLabel("Paket empfangen");
		lblPacketReceived.setIcon(new ImageIcon(PanelRNPipelineProtocolMenuAutomaticMenuImpl.class.getResource("/Base/img/boxRed.png")));
		
		JLabel lblAck = new JLabel("ACK");
		lblAck.setIcon(new ImageIcon(PanelRNPipelineProtocolMenuAutomaticMenuImpl.class.getResource("/Base/img/boxYellow.png")));
		
		JLabel lblAckReceived = new JLabel("ACK empfangen");
		lblAckReceived.setIcon(new ImageIcon(PanelRNPipelineProtocolMenuAutomaticMenuImpl.class.getResource("/Base/img/boxBlue.png")));
		
		JLabel lblPacketAckFalsified = new JLabel("Paket/ACK verf\u00E4lscht");
		lblPacketAckFalsified.setIcon(new ImageIcon(PanelRNPipelineProtocolMenuAutomaticMenuImpl.class.getResource("/Base/img/boxLightGray.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPacket)
						.addComponent(lblPacketReceived)
						.addComponent(lblAck)
						.addComponent(lblAckReceived)
						.addComponent(lblPacketAckFalsified))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPacket)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPacketReceived)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAck)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAckReceived)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPacketAckFalsified)
					.addContainerGap(54, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		this.initPanel();
	}

	@Override
	public Integer getLengthMenu() {
		// TODO Auto-generated method stub
		return null;
	}

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
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initLayout() {
		// TODO Auto-generated method stub
		
	}	
}
