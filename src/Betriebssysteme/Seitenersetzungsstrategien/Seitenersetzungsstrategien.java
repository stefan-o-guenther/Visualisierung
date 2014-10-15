/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import Base.VisualizationAbstract;

public class Seitenersetzungsstrategien extends VisualizationAbstract {

	public Seitenersetzungsstrategien() {
		super();
	}
	
	public static void main(String[] args) {
		initialize();		
    	baseVisualization(new PanelBSSeitenersetzungsstrategienMainImpl());	
    }
}