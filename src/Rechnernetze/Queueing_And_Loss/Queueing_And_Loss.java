/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Queueing_And_Loss;

import Base.MainAbstract;

public class Queueing_And_Loss extends MainAbstract {

	public Queueing_And_Loss() {
		super();
	}
	
	public static void main(String[] args) {
		ManagementQueueingAndLoss qal = new ManagementQueueingAndLossImpl();
		initialize();
		panelMain = new PanelRNQueueingAndLossMainImpl(qal);
    	baseMain();	
    }
}
