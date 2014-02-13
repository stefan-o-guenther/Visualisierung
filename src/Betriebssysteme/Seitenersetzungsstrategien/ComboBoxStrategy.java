/**
 * @author:	Stefan Otto Günther
 * @date:	10.02.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import javax.swing.JComboBox;

public class ComboBoxStrategy extends JComboBox {

	public ComboBoxStrategy() {
		super(strategies);		
	}
	
	private static String[] strategies = {"Optimale Strategie", "FIFO", "FIFO - Second Chance", "NRU / RNU - FIFO", "NRU / RNU - FIFO Second Chance"};
	private static EnumPagingStrategy[] vals = {EnumPagingStrategy.OPTIMAL, EnumPagingStrategy.FIFO, EnumPagingStrategy.FIFO_SECOND_CHANCE, EnumPagingStrategy.NRU_RNU, EnumPagingStrategy.NRU_RNU_SECOND_CHANCE};
	
	public EnumPagingStrategy getStrategy() {
		return  vals[super.getSelectedIndex()];
	}
}
