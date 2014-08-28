/**
 * @author:	Stefan Otto Günther
 * @date:	11.02.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JRadioButton;

import Base.ButtonGroupAbstract;

public class ButtonGroupProcessImpl extends ButtonGroupAbstract {

	public ButtonGroupProcessImpl(ManagementBuddyMemoryAllocation buddy) {
		super(buddy);
		try {
			this.initMapProcess();
		} catch (Exception ex) {
			throw ex;
		}		
	}
	
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
	
	public void selectRadioButtonStart() {
		this.selectRadioButton(getRadioButtonStart());
	}
	
	public void selectRadioButtonStop() {
		this.selectRadioButton(getRadioButtonStop());
	}

	@Override
	protected String[] getArrayNames() {
		String[] arrayNames = {"Prozess starten", "Prozess beenden"};
		return arrayNames;
	}

	@Override
	protected ActionListener getActionListener() {
		return new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				ManagementBuddyMemoryAllocation buddy = (ManagementBuddyMemoryAllocation) getManagement();
				buddy.setProcessOperation(getSelectedButtonEnum());
			}	
		};
	}
}