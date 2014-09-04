/**
 * @author:	Stefan Otto Günther
 * @date:	11.02.2014
 */

package Base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JRadioButton;

public class ButtonGroupColorImpl extends ButtonGroupAbstract {

	private static final long serialVersionUID = 1L;
	
	public ButtonGroupColorImpl(Management management) {
		super(management);
		try {
			this.initMapColors();
		} catch (Exception ex) {
			throw ex;
		}	
	}
	
	private HashMap<String, EnumSurface> mapColors;
	
	private void initMapColors() {
		mapColors = new HashMap<String, EnumSurface>();
		mapColors.put(arrayNames[0], EnumSurface.COLORED);
		mapColors.put(arrayNames[1], EnumSurface.GRAY);		
	}
	
	private EnumSurface getSelectedButtonEnum() {		
		String actionCommand = this.getSelectedButtonString();
		return mapColors.get(actionCommand);
	}	
	
	public JRadioButton getRadioButtonColored() {
		return this.getRadioButton(arrayNames[0]);
	}
	
	public JRadioButton getRadioButtonGray() {
		return this.getRadioButton(arrayNames[1]);
	}
	
	public void selectRadioButtonColored() {
		this.selectRadioButton(getRadioButtonColored());
	}
	
	public void selectRadioButtonGray() {
		this.selectRadioButton(getRadioButtonGray());
	}

	@Override
	protected String[] getArrayNames() {
		String[] arrayNames = {"farbig", "grau"};
		return arrayNames;
	}

	@Override
	protected ActionListener getActionListener() {
		return new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if (management != null) {
					management.setSurface(getSelectedButtonEnum());
				}				
			}	
		};
	}
}