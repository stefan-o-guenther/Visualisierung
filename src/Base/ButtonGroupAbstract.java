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

	public ButtonGroupAbstract() {
		super();
		mapRadioButtons = new HashMap<String, JRadioButton>();
	}
	
	private HashMap<String, JRadioButton> mapRadioButtons;
	private ActionListener actionListener;	
	
	public String getSelectedButtonString() {
		ButtonModel model = getSelection();
		String actionCommand = "";
		if (model != null) {
			actionCommand = model.getActionCommand();
		}
		return actionCommand;
	}
	
	protected void setRadioButtons(String[] arrayNames) {
		try {
			if (arrayNames == null) {
				throw new NullPointerException();
			}
			Integer length = arrayNames.length;
			for (Integer i = 0; i < length; i++) {
				int j = i.intValue();
				Boolean selected = (j == 0);
				String name = arrayNames[i];
				JRadioButton rdbtn = new JRadioButton(arrayNames[i]);
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
	
	protected void setActionListener(ActionListener action) {
		try {
			if (action == null) {
				throw new NullPointerException();
			}
			actionListener = action;
		} catch (Exception ex) {
			throw ex;
		}		
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
}
