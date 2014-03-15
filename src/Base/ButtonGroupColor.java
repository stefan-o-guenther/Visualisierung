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

public class ButtonGroupColor extends BaseButtonGroup {

	public ButtonGroupColor(ActionListener actionColor) {
		super();
		this.setActionListener(actionColor);
		this.setRadioButtons(arrayNames);
		this.initMapColors();
	}
	
	private String[] arrayNames = {"farbig", "grau"};
	
	private HashMap<String, EnumSurface> mapColors;
	
	private void initMapColors() {
		mapColors = new HashMap<String, EnumSurface>();
		mapColors.put(arrayNames[0], EnumSurface.COLORED);
		mapColors.put(arrayNames[1], EnumSurface.GRAY);		
	}
	
	public JRadioButton geRadioButtonColored() {
		return this.getRadioButton(arrayNames[0]);
	}
	
	public JRadioButton getRadioButtonGray() {
		return this.getRadioButton(arrayNames[1]);
	}
	
	public EnumSurface getSelectedButton() {		
		String actionCommand = this.getSelectedButtonString();
		return mapColors.get(actionCommand);
	}	
}