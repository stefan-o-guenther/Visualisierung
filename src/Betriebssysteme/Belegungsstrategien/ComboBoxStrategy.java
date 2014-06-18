/**
 * @author:	Stefan Otto Günther
 * @date:	10.02.2014
 */

package Betriebssysteme.Belegungsstrategien;

import javax.swing.JComboBox;

public class ComboBoxStrategy extends JComboBox {

	public ComboBoxStrategy() {
		super(strategies);		
	}
	
	private static String[] strategies = {"First Fit", "Next Fit", "Best Fit", "Worst Fit", "Schneiderinnen Best Fit"};
	private static EnumMemoryStrategy[] vals = {EnumMemoryStrategy.FIRST_FIT, EnumMemoryStrategy.NEXT_FIT, EnumMemoryStrategy.BEST_FIT, EnumMemoryStrategy.WORST_FIT, EnumMemoryStrategy.SCHNEIDERINNEN_BEST_FIT};
		
	public EnumMemoryStrategy getStrategy() {
		return  vals[super.getSelectedIndex()];
	}
}