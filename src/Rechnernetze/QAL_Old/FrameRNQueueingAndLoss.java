/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.QAL_Old;

import Base.FrameAbstract;

public class FrameRNQueueingAndLoss extends FrameAbstract {

	public FrameRNQueueingAndLoss() {
		super("Queueing And Loss");
        initUI(new PanelRNQueueingAndLossMainImpl());
    }
}
