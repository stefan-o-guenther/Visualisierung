/**
 * @author:	Stefan Otto Günther
 * @date:	14.01.2014
 */

package Visualisierungen;

import Base.MainAbstract;

public class Visualisierungen extends MainAbstract {

	public Visualisierungen() {
		super();
	}
	
	public static void main(String[] args) {
		initialize();
    	baseMain(new FrameDefaultImpl());
    }
}
