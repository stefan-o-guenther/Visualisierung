/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import javax.swing.JFrame;

public class RunFrame implements Runnable {

	public RunFrame(JFrame jframe) {
		super();
		frame = jframe;
	}
	
	private JFrame frame;	
	
	@Override
	public void run() {
		try {            		
    		frame.setVisible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
