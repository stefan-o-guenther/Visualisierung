/**
 * @author:	Stefan Otto Günther
 * @date:	10.02.2014
 */

package Rechnernetze.Queueing_And_Loss;

import javax.swing.JComboBox;

public class ComboBoxTransferRate extends JComboBox {

	public ComboBoxTransferRate() {
		super(rates);		
	}
	
	private static String[] rates = {"500  packet/s","350 packet/s"};
	private static Double[] vals = {2E-3,3E-3};
	
	public Double getVal() {
		return  vals[super.getSelectedIndex()];
	}
}