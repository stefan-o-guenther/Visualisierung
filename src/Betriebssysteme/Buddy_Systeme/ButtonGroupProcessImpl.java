/**
 * @author:	Stefan Otto Günther
 * @date:	11.02.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JRadioButton;

import Base.ButtonGroupAbstract;

public class ButtonGroupProcessImpl extends ButtonGroupAbstract {

	public ButtonGroupProcessImpl(ActionListener actionProcess) {
		super();		
		this.setActionListener(actionProcess);
		this.setRadioButtons(arrayNames);
		this.initMapProcess();
	}
	
	private String[] arrayNames = {"Prozess starten", "Prozess beenden"};
	
	private HashMap<String, EnumProcess> mapProcess;
	
	private void initMapProcess() {
		mapProcess = new HashMap<String, EnumProcess>();
		mapProcess.put(arrayNames[0], EnumProcess.PROCESS_START);
		mapProcess.put(arrayNames[1], EnumProcess.PROCESS_STOP);		
	}
	
	public JRadioButton getRadioButtonStart() {
		return this.getRadioButton(arrayNames[0]);
	}
	
	public JRadioButton getRadioButtonStop() {
		return this.getRadioButton(arrayNames[1]);
	}
	
	public EnumProcess getSelectedButtonEnum() {		
		String actionCommand = this.getSelectedButtonString();
		return mapProcess.get(actionCommand);
	}
}