/**
 * @author:	Stefan Otto Günther
 * @date:	11.03.2014
 */

package Base;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JRadioButton;

public abstract class ButtonGroupAbstract extends ButtonGroup {

	private static final long serialVersionUID = 1L;
	
	public ButtonGroupAbstract(Management management) {
		super();
		try {
			Checker.checkIfNotNull(management);
			this.management = management;
			initButtonGroup();
		} catch (Exception ex) {
			throw ex;
		}		
	}
	
	protected Map<String, JRadioButton> mapRadioButtons = new HashMap<String, JRadioButton>();
	protected ActionListener actionListener;	
	protected Management management;
	protected String[] arrayNames = {};
	
	protected abstract String[] getArrayNames();
	protected abstract ActionListener getActionListener();
	
	private void initButtonGroup() {
		try {
			this.actionListener = this.getActionListener();
			this.arrayNames = this.getArrayNames();			
			Integer length = arrayNames.length;
			for (Integer i = 0; i < length; i++) {
				int j = i.intValue();
				Boolean selected = (j == 0);
				String name = arrayNames[i];
				JRadioButton rdbtn = new JRadioButton(name);
				rdbtn.setName(name);
				rdbtn.setActionCommand(name);
				rdbtn.addActionListener(actionListener);
				rdbtn.setSelected(selected);
				mapRadioButtons.put(name, rdbtn);				
				add(rdbtn);
			}
		} catch (Exception ex) {
			throw ex;
		}
	}	
	
	public String getSelectedButtonString() {
		ButtonModel model = getSelection();
		String actionCommand = "";
		if (model != null) {
			actionCommand = model.getActionCommand();
		}
		return actionCommand;
	}
	
	protected JRadioButton getRadioButton(String name) {
		try {
			Checker.checkIfNotNull(name);
			return mapRadioButtons.get(name);
		} catch (Exception ex) {
			throw ex;
		}		
	}
	
	protected void selectRadioButton(JRadioButton radioButton) {
		try {
			Checker.checkIfNotNull(radioButton);
			this.setSelected(radioButton.getModel(), true);
			this.actionListener.actionPerformed(null);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	protected Management getManagement() {
		return management;
	}
}