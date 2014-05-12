/**
 * @author:	Stefan Otto Günther
 * @date:	11.02.2014
 */

package Rechnernetze.Congestion_Avoidance;

import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JRadioButton;

import Base.ButtonGroupAbstract;

public class ButtonGroupNetworkStrategyImpl extends ButtonGroupAbstract {

	public ButtonGroupNetworkStrategyImpl(ActionListener actionStrategy) {
		super();
		this.setActionListener(actionStrategy);
		this.setRadioButtons(arrayNames);
		this.initMapColors();
	}
	
	private String[] arrayNames = {"timeout", "tripple dupl. ACK"};
	
	private HashMap<String, EnumNetworkStrategy> mapStrategy;
	
	private void initMapColors() {
		mapStrategy = new HashMap<String, EnumNetworkStrategy>();
		mapStrategy.put(arrayNames[0], EnumNetworkStrategy.TIMEOUT);
		mapStrategy.put(arrayNames[1], EnumNetworkStrategy.TRIPPLE_DUBL_ACK);		
	}
	
	public JRadioButton geRadioButtonTimout() {
		return this.getRadioButton(arrayNames[0]);
	}
	
	public JRadioButton getRadioButtonTrippleDublACK() {
		return this.getRadioButton(arrayNames[1]);
	}
	
	public EnumNetworkStrategy getSelectedButton() {		
		String actionCommand = this.getSelectedButtonString();
		return mapStrategy.get(actionCommand);
	}	
}