/**
 * @author:	Stefan Otto G�nther
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