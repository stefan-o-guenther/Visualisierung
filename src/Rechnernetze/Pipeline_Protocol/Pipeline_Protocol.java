/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Rechnernetze.Pipeline_Protocol;

import Base.VisualizationAbstract;

public class Pipeline_Protocol extends VisualizationAbstract {

	public Pipeline_Protocol() {
		super();
	}
	
	public static void main(String[] args) {
		initialize();
		baseVisualization(new PanelRNPipelineProtocolMainImpl());	
    }
}
