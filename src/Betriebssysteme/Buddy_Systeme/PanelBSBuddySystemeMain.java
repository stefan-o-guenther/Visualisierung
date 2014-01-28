/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Betriebssysteme.Buddy_Systeme;

import java.util.ArrayList;
import java.util.List;

import Base.BasePanelMain;
import Base.BasePanelModel;
import Base.PanelTitle;

public class PanelBSBuddySystemeMain extends BasePanelMain {

	/**
	 * Create the panel.
	 */
	public PanelBSBuddySystemeMain() {
		super(new BuddyMemoryAllocation());
		initComponents();
	}
	
	/*
	 * 
	 * 





Ihre Anfangsadressen sind identisch bis auf das k-te Bit in ihrer Adresse, das invertiert ist. Beispiel: ...XYZ0000... und ...XYZ1000... sind die Anfangsadressen von Partnern.

Dies l�sst sich ausnutzen, um sehr schnell (in einem Schritt!) pr�fen zu k�nnen, ob ein freigewordenes Speicherst�ck einen freien Partner in der Belegungstabelle hat, mit dem es zu einem (doppelt so gro�en) St�ck verschmolzen werden kann.

Beide Vorg�nge, sowohl das Suchen eines passenden freien St�cks (bzw. das daf�r n�tigen Auseinanderbrechen eines gr��eren) als auch das Zusammenf�gen zu gr��eren Einheiten l�sst sich rekursiv �ber mehrere Partnerebenen (mehrere Zweierpotenzen) durchf�hren.
	 * 
	 * 
	 * 
	 * 
	 *
	 * */
	
	
	protected PanelBSBuddySystemeExplanationScroll panelExplanation;
	
	protected void initComponents() {
		IBuddyMemoryAllocation buddy = (IBuddyMemoryAllocation) management;
		
		String tooltip = 
	        	  "<html>"
	        	+ "F�r jede g�ngige Belegungsgr��e (am besten Speicher in den Gr��en von Zweierpotenzen)<br>"
	        	+ "wird eine eigene Liste vorgesehen und nur Speicherst�cke einer solchen festen Gr��e vergeben.<br>"
	        	+ "Alle Anforderungen m�ssen also auf die n�chste Zweierpotenz aufgerundet werden.<br>"
	        	+ "<br>"
	        	+ "Ein Speicherplatz der L�nge 280 Bytes = 256+16+8 = 28 + 24 + 23 Bytes muss also auf 29 = 512 Bytes aufgerundet werden.<br>"
	        	+ "<br>"
	        	+ "Ist kein freies Speicherst�ck der Gr��e 2k vorhanden, so muss ein freies Speicherst�ck der Gr��e 2k+1 in zwei St�cke von je 2k Byte aufgeteilt werden. <br>"
	        	+ "Beide St�cke, die Partner (Buddy), sind genau gekennzeichnet:<br>"
	        	+ "Standardm��ig ist die Geschwindigkeit auf 50% eingestellt.<br>"
	        	+ "Standardm��ig ist die Geschwindigkeit auf 50% eingestellt.<br>"
	        	+ "Standardm��ig ist die Geschwindigkeit auf 50% eingestellt.<br>"
	        	+ "</html>";
		
		panelModel = new PanelBSBuddySystemeModel(buddy);
		//panelModel = new PanelBSBuddySystemeModelScroll(buddy);
		panelMenu = new PanelBSBuddySystemeMenu(buddy, panelModel);
		panelTitle = new PanelTitle(buddy, panelModel, "Buddy Systeme", tooltip);
		initLayout(110);
	}
		
	
}
