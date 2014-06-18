package Rechnernetze.Pipeline_Protocol;

import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;

public class ButtonGroupPipelineProtocolImpl extends ButtonGroup {

	public ButtonGroupPipelineProtocolImpl(Integer count, ActionListener actionListener) {
		super();
		try {
			if ((count == null) || (actionListener == null)) {
				throw new NullPointerException();
			}
			int c = count.intValue();
			if (c <= 0) {
				throw new IllegalArgumentException();
			}
			this.count = count;
			this.actionListener = actionListener;
			mapButtons = new HashMap<String, JButton>();
		} catch (Exception ex) {
			throw ex;
		}		
	}	
	
	private HashMap<String, JButton> mapButtons;
	private HashMap<String, Integer> mapIndex;
	private ActionListener actionListener;
	private Integer count;
	
	public Integer getSelectedButton() {	
		ButtonModel model = getSelection();
		String actionCommand = "";
		if (model != null) {
			actionCommand = model.getActionCommand();
		}		
		return mapIndex.get(actionCommand);
	}	
	
	private void setButtons() {
		for (Integer i = 0; i < count; i++) {
			int j = i.intValue();
			Boolean selected = (j == 0);
			String name = "btn"+i.toString();
			JButton btn = new JButton(name);
			btn.setName(name);
			btn.setText("X");
			btn.setActionCommand(name);
			btn.addActionListener(actionListener);
			btn.setSelected(selected);
			mapButtons.put(name, btn);
			mapIndex.put(name, i);
			add(btn);
		}		
	}
	
	protected JButton getButton(String name) {
		try {
			if (name == null) {
				throw new NullPointerException();
			}
			return mapButtons.get(name);
		} catch (Exception ex) {
			throw ex;
		}		
	}	
	
}
