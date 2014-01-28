/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Pipeline_Protocol;

import Base.BaseFrame;

public class FrameRNPipelineProtocol extends BaseFrame {

	public FrameRNPipelineProtocol() {
		super("Pipeline Protocol");
        initUI(new PanelRNPipelineProtocolMain());
    }

    public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameRNPipelineProtocol());	
    }
}