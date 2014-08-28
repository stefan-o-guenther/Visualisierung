/**
 * @author:	Stefan Otto Günther
 * @date:	11.03.2014
 */

package Base;

import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JRadioButton;

public abstract class ButtonGroupAbstract extends ButtonGroup {

	public ButtonGroupAbstract(Management management) {
		super();
		try {
			if (management == null) {
				throw new NullPointerException();
			}
			this.management = management;
			initButtonGroup();
		} catch (Exception ex) {
			throw ex;
		}		
	}
	
	protected HashMap<String, JRadioButton> mapRadioButtons = new HashMap<String, JRadioButton>();
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
			if (name == null) {
				throw new NullPointerException();
			}
			return mapRadioButtons.get(name);
		} catch (Exception ex) {
			throw ex;
		}		
	}
	
	protected void selectRadioButton(JRadioButton radioButton) {
		try {
			if (radioButton == null) {
				throw new NullPointerException();
			}
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