/**
 * @author:	Stefan Otto Günther
 * @date:	11.02.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JRadioButton;

public class ButtonGroupProcess extends ButtonGroup {

	public ButtonGroupProcess(String nameStart, String nameStop, ActionListener actionProcess) {
		super();
		if ((nameStart == null) || nameStart == "") {
			nameStart = "start";
		}
		if ((nameStop == null) || (nameStop == "")) {
			nameStart = "stop";
		}
		rdbtnStart = new JRadioButton(nameStart);
		rdbtnStart.setActionCommand(nameStart);
		rdbtnStart.addActionListener(actionProcess);		
		
		rdbtnStop = new JRadioButton(nameStop);
		rdbtnStop.setActionCommand(nameStop);		
		rdbtnStop.addActionListener(actionProcess);
		
		mapProcess = new HashMap<String, EnumProcess>();
		mapProcess.put(nameStart, EnumProcess.PROCESS_START);
		mapProcess.put(nameStop, EnumProcess.PROCESS_STOP);		
		
		add(rdbtnStart);
		add(rdbtnStop);
		rdbtnStart.setSelected(true);
	}
	
	private JRadioButton rdbtnStart;	
	private JRadioButton rdbtnStop;
	
	private HashMap<String, EnumProcess> mapProcess;
	
	public JRadioButton geRadioButtonStart() {
		return rdbtnStart;
	}
	
	public JRadioButton getRadioButtonStop() {
		return rdbtnStop;
	}
	
	public EnumProcess getSelectedButtonEnum() {
		ButtonModel model = getSelection();
		String actionCommand = (model == null) ? "" : model.getActionCommand();
		return mapProcess.get(actionCommand);
	}
	
	public String getSelectedButtonString() {
		ButtonModel model = getSelection();
		String actionCommand = (model == null) ? "" : model.getActionCommand();
		return actionCommand;
	}
}
