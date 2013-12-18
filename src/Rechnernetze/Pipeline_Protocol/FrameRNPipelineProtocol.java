package Rechnernetze.Pipeline_Protocol;

import Base.BaseFrame;

public class FrameRNPipelineProtocol extends BaseFrame {

	public FrameRNPipelineProtocol() {
        initUI("Belegungsstrategien", new PanelRNPipelineProtocol());
    }

    public static void main(String[] args) {
    	initToolTipManager();
    	initLookAndFeel();
    	baseMain(new FrameRNPipelineProtocol());	
    }
}