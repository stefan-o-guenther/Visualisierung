/**
 * @author:	Stefan Otto Günther
 * @date:	10.02.2014
 */

package Rechnernetze.Pipeline_Protocol;

import javax.swing.JComboBox;

public class ComboBoxStrategy extends JComboBox<Object> {

	private static final long serialVersionUID = 1L;

	public ComboBoxStrategy() {
		super(strategies);		
	}
	
	private static String[] strategies = {"Stop And Wait", "Go Back N", "Selective Repeat"};
	private static EnumARQStrategy[] vals = {EnumARQStrategy.STOP_AND_WAIT, EnumARQStrategy.GO_BACK_N, EnumARQStrategy.SELECTIVE_REPEAT};
		
	public EnumARQStrategy getStrategy() {
		return  vals[super.getSelectedIndex()];
	}
}