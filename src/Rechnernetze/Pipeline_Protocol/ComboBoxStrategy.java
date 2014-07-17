/**
 * @author:	Stefan Otto Günther
 * @date:	10.02.2014
 */

package Rechnernetze.Pipeline_Protocol;

import javax.swing.JComboBox;

public class ComboBoxStrategy extends JComboBox {

	public ComboBoxStrategy() {
		super(strategies);		
	}
	
	private static String[] strategies = {"Stop And Wait", "Go Back N", "Selective Repeat"};
	private static EnumPipelineProtocolStrategy[] vals = {EnumPipelineProtocolStrategy.GO_BACK_N, EnumPipelineProtocolStrategy.SELECTIVE_REPEAT};
		
	public EnumPipelineProtocolStrategy getStrategy() {
		return  vals[super.getSelectedIndex()];
	}
}