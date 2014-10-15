/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Belegungsstrategien;

import Base.VisualizationAbstract;

public class Belegungsstrategien extends VisualizationAbstract {
	
	public Belegungsstrategien() {
		super();
	}
	
	public static void main(String[] args) {
		initialize();
    	baseVisualization(new PanelBSBelegungsstrategienMainImpl());
    }
}