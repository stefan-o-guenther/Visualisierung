/**
 * @author:	Stefan Otto Günther
 * @date:	11.02.2014
 */

package Base;

import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JRadioButton;

public class ButtonGroupColor extends ButtonGroup {

	public ButtonGroupColor(String nameColored, String nameGray, ActionListener actionColor) {
		super();
		if ((nameColored == null) || nameColored == "") {
			nameColored = "colored";
		}
		if ((nameGray == null) || (nameGray == "")) {
			nameColored = "gray";
		}
		rdbtnColored = new JRadioButton(nameColored);
		rdbtnColored.setActionCommand(nameColored);
		rdbtnColored.addActionListener(actionColor);		
		
		rdbtnGray = new JRadioButton(nameGray);
		rdbtnGray.setActionCommand(nameGray);		
		rdbtnGray.addActionListener(actionColor);
		
		mapColors = new HashMap<String, EnumSurface>();
		mapColors.put(nameColored, EnumSurface.COLORED);
		mapColors.put(nameGray, EnumSurface.GRAY);		
		
		add(rdbtnColored);
		add(rdbtnGray);
		rdbtnColored.setSelected(true);
	}
	
	private JRadioButton rdbtnColored;	
	private JRadioButton rdbtnGray;
	
	private HashMap<String, EnumSurface> mapColors;
	
	public JRadioButton geRadioButtonColored() {
		return rdbtnColored;
	}
	
	public JRadioButton getRadioButtonGray() {
		return rdbtnGray;
	}
	
	public EnumSurface getSelectedButton() {
		ButtonModel model = getSelection();
		String actionCommand = (model == null) ? "" : model.getActionCommand();
		return mapColors.get(actionCommand);
	}	
}
