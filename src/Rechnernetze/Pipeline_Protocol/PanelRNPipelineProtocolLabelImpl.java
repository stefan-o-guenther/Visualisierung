/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Rechnernetze.Pipeline_Protocol;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.PanelMenuAbstract;

public class PanelRNPipelineProtocolLabelImpl extends PanelMenuAbstract {

	private static final long serialVersionUID = 1L;

	public PanelRNPipelineProtocolLabelImpl() {
		super();
		//this.initializeExtra();
		this.createPanel();		
	}
	
	private void initializeExtra() {		
		this.createMenuComponents();
		this.createLayout();
	}
	
	private JLabel lblPacket;
	private JLabel lblPacketReceived;
	private JLabel lblAck;
	private JLabel lblAckReceived;
	private JLabel lblPacketAckFalsified;	
	
	@Override
	public void updatePanel() {
		// nothing
	}

	@Override
	protected void createMenuComponents() {
		lblPacket = new JLabel("Paket");
		lblPacket.setIcon(new ImageIcon(PanelRNPipelineProtocolLabelImpl.class.getResource("/Base/img/boxCyan.png")));
		
		lblPacketReceived = new JLabel("Paket empfangen");
		lblPacketReceived.setIcon(new ImageIcon(PanelRNPipelineProtocolLabelImpl.class.getResource("/Base/img/boxRed.png")));
		
		lblAck = new JLabel("ACK");
		lblAck.setIcon(new ImageIcon(PanelRNPipelineProtocolLabelImpl.class.getResource("/Base/img/boxYellow.png")));
		
		lblAckReceived = new JLabel("ACK empfangen");
		lblAckReceived.setIcon(new ImageIcon(PanelRNPipelineProtocolLabelImpl.class.getResource("/Base/img/boxBlue.png")));
		
		lblPacketAckFalsified = new JLabel("Paket/ACK verf\u00E4lscht");
		lblPacketAckFalsified.setIcon(new ImageIcon(PanelRNPipelineProtocolLabelImpl.class.getResource("/Base/img/boxLightGray.png")));
	}

	@Override
	protected void createLayout() {		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblPacket))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAck))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAckReceived))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblPacketReceived))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblPacketAckFalsified)))
					.addContainerGap(884, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPacket)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAck)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAckReceived)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPacketReceived)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPacketAckFalsified)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	@Override
	protected void createMenuMethods() {
		// nothing
	}	

	@Override
	public Integer getPanelHeight() {
		return 120;
	}

	@Override
	public Integer getPanelWidth() {
		return 150;
	}
}
