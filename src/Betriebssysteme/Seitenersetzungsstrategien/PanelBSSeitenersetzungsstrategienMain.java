package Betriebssysteme.Seitenersetzungsstrategien;

import Base.BasePanelMain;
import Base.PanelTitle;

public class PanelBSSeitenersetzungsstrategienMain extends BasePanelMain {
	
	/**
	 * Create the panel.
	 */
	public PanelBSSeitenersetzungsstrategienMain() {
		super(new MemoryManager());
		initComponents();
	}	
	
	protected void initComponents() {
		IMemoryManager paging = (IMemoryManager) management;
		
		/*
		 *  

 




Optimale Strategie
FIFO
FIFO - Second Chance
NRU / RNU
		 * 
		 */
		
		String tooltip = 
	        	  "<html>"
	        	+ "Bei einem Seitenfehler wählt der Memory-Manager, sofern nicht noch Seitenrahmen frei sind, eine Seite aus, die verdrängt,<br>"
	        	+ "also in die Paging-Area ausgelagert werden muss, um Platz für die neue Seite zu schaffen. Die Strategie,<br>"
	        	+ "die verwendet wird, um eine zu verdrängende Seite auszuwählen, wird als Seitenersetzungsstrategie (Replacement-Strategy) bezeichnet.<br>"
	        	+ "Optimal wäre, wenn alle zukünfigen Seitenzugriffe vorher bestimmt werden könnten. Dies ist aber nicht zu realisieren.<br>"
	        	+ "Bedarfsgerechte Strategien, auch als Demand-Paging bezeichnet, reagieren erst,<br>"
	        	+ "wenn eine Anforderung zur Seiteneinlagerung da ist und kein freier Seitenrahmen mehr verfügbar ist.<br>"
	        	+ "Man unterscheidet prozesslokale und globale Strategien zur Seitenersetzung.<br>"
	        	+ "Bei ersteren wird die Seitenersetzung für jeden Prozess isoliert durchgeführt, bei letzteren für das ganze System.<br>"
	        	+ "Globale Strategien bieten mehr Möglichkeiten der Optimierung.<br><br>"
	        	+ "In dieser Animation werden die folgenden Algorithmen behandelt:<br>"
	        	+ "<ul>"
	        	+ "<li>Optimale Strategie</li>"
	        	+ "<li>FIFO</li>"
	        	+ "<li>FIFO - Second Chance</li>"
	        	+ "<li>LRU</li>"
	        	+ "<li>NFU / LFU</li>"
	        	+ "<li>NRU / RNU - FIFO</li>"
	        	+ "<li>NRU / RNU - FIFO Second Chance</li>"
	        	+ "</ul>"
	        	+ "</html>";
		
		panelModel = new PanelBSSeitenersetzungsstrategienModel(paging);
		panelMenu = new PanelBSSeitenersetzungsstrategienMenu(paging);
		panelTitle = new PanelTitle("Seitenersetzungsstrategien", tooltip, paging);
		initLayout(70);
	}
}