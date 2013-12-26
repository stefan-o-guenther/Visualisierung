package Betriebssysteme.Verklemmungen;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelBSVerklemmungenMain extends BasePanelMain {

	/**
	 * Create the panel.
	 */
	public PanelBSVerklemmungenMain() {
		super(new DeadlockManagement());
		initComponents();
	}	
	
	protected void initComponents() {
		IDeadlockManagement deadlock = (IDeadlockManagement) management;
		
		String tooltip = 
	        	  "<html>"
	        	+ "Mit diesem Geschwindigkeitsregeler können Sie einstellen,<br>"
	        	+ "wie schnell der Auto-Durchlauf ausgeführt werden soll.<br>"
	        	+ "Standardmäßig ist die Geschwindigkeit auf 50% eingestellt.<br>"
	        	+ "</html>";
		
		panelModel = new PanelBSVerklemmungenModelScroll(deadlock);
		panelMenu = new PanelBSVerklemmungenMenu(deadlock);
		panelTitle = new PanelTitle("Verklemmungen", tooltip, deadlock);		
		initLayout(200);
	}
}
