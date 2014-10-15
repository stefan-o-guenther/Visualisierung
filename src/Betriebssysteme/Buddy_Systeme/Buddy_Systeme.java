/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import Base.VisualizationAbstract;

public class Buddy_Systeme extends VisualizationAbstract {

	public Buddy_Systeme() {
		super();
	}
	
	public static void main(String[] args) {
		initialize();
		baseVisualization(new PanelBSBuddySystemeMainImpl());	
    }
}