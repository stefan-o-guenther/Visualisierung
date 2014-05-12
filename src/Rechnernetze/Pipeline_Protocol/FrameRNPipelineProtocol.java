/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Pipeline_Protocol;

import Base.FrameAbstract;

public class FrameRNPipelineProtocol extends FrameAbstract {

	public FrameRNPipelineProtocol() {
		super("Pipeline Protocol");
        initUI(new PanelRNPipelineProtocolMainImpl());
    }

    public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameRNPipelineProtocol());	
    }
}