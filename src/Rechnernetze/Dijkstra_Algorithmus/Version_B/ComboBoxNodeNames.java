package Rechnernetze.Dijkstra_Algorithmus.Version_B;

import javax.swing.JComboBox;

public class ComboBoxNodeNames extends JComboBox<Object> {

	private static final long serialVersionUID = 1L;

	public ComboBoxNodeNames() {
		super(names);		
	}
	
	private static String[] names = {"U", "V", "W", "X", "Y", "Z"};
	
	public String getNodeName() {
		return names[super.getSelectedIndex()];
	}
}
