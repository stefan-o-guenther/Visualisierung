/**
 * @author:	Stefan Otto Günther
 * @date:	23.04.2014
 */

package Rechnernetze.Congestion_Avoidance;

import javax.swing.JComboBox;

public class ComboBoxNetworkTypeImpl extends JComboBox {

	public ComboBoxNetworkTypeImpl() {
		super(types);		
	}
	
	private static String[] types = {"TCP Reno", "TCP Tahoe", "Both"};
	private static EnumNetworkType[] vals = {EnumNetworkType.TCP_RENO, EnumNetworkType.TCP_TAHOE, EnumNetworkType.BOTH};
		
	public EnumNetworkType getType() {
		return  vals[super.getSelectedIndex()];
	}
}