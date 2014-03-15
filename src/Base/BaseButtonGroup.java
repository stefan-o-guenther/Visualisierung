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

public abstract class BaseButtonGroup extends ButtonGroup {

	public BaseButtonGroup() {
		super();
		mapRadioButtons = new HashMap<String, JRadioButton>();
	}
	
	public String getSelectedButtonString() {
		ButtonModel model = getSelection();
		String actionCommand = "";
		if (model != null) {
			actionCommand = model.getActionCommand();
		}
		return actionCommand;
	}
	
	protected void setRadioButtons(String[] arrayNames) {
		if (arrayNames != null) {
			Integer length = arrayNames.length;
			for (Integer i = 0; i < length; i++) {
				Boolean selected = (i.equals(0));
				String name = arrayNames[i];
				JRadioButton rdbtn = new JRadioButton(arrayNames[i]);
				rdbtn.setName(name);
				rdbtn.setActionCommand(name);
				rdbtn.addActionListener(actionListener);
				rdbtn.setSelected(selected);
				mapRadioButtons.put(name, rdbtn);				
				add(rdbtn);
			}
		}
	}
	
	protected void setActionListener(ActionListener action) {
		actionListener = action;
	}
	
	protected JRadioButton getRadioButton(String name) {
		return mapRadioButtons.get(name);
	}
	
	private HashMap<String, JRadioButton> mapRadioButtons;
	private ActionListener actionListener;	
}
