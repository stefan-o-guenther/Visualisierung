/**
 * @author:	Stefan Otto Günther
 * @date:	11.02.2014
 */

package Rechnernetze.Congestion_Avoidance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JRadioButton;

import Base.ButtonGroupAbstract;

public class ButtonGroupNetworkStrategyImpl extends ButtonGroupAbstract {

	private static final long serialVersionUID = 1L;

	public ButtonGroupNetworkStrategyImpl(ManagementCongestionAvoidance network) {
		super(network);
		this.initMapColors();
	}
	
	private HashMap<String, EnumNetworkStrategy> mapStrategy;
	
	private void initMapColors() {
		mapStrategy = new HashMap<String, EnumNetworkStrategy>();
		mapStrategy.put(arrayNames[0], EnumNetworkStrategy.TIMEOUT);
		mapStrategy.put(arrayNames[1], EnumNetworkStrategy.TRIPPLE_DUBL_ACK);		
	}
	
	public JRadioButton getRadioButtonTimout() {
		return this.getRadioButton(arrayNames[0]);
	}
	
	public JRadioButton getRadioButtonTrippleDublACK() {
		return this.getRadioButton(arrayNames[1]);
	}
	
	public EnumNetworkStrategy getSelectedButton() {		
		String actionCommand = this.getSelectedButtonString();
		return mapStrategy.get(actionCommand);
	}	
	
	public void selectRadioButtonTimeout() {
		this.selectRadioButton(this.getRadioButtonTimout());
	}
	
	public void selectRadioButtonTrippleDublACK() {
		this.selectRadioButton(getRadioButtonTrippleDublACK());
	}

	@Override
	protected String[] getArrayNames() {
		String[] arrayNames = {"timeout", "tripple dupl. ACK"};
		return arrayNames;
	}
		
	@Override
	protected ActionListener getActionListener() {
		return new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				ManagementCongestionAvoidance network = (ManagementCongestionAvoidance) getManagement();
				network.setNetworkStrategy(getSelectedButton());					
			}
		};
	}
}