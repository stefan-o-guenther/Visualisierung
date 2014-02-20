/**
 * @author:	Stefan Otto Günther
 * @date:	20.02.2014
 */

package Betriebssysteme.Belegungsstrategien;


public class AutoThread extends Thread {
   
	private PanelBSBelegungsstrategienMenu panelMenu;
	private IFragmentation fragmentation;
  
	public AutoThread(IFragmentation fragmentation, PanelBSBelegungsstrategienMenu panelMenu) {
    	super();
    	this.panelMenu = panelMenu;
    	this.fragmentation = fragmentation;
    }
  
    public void run() {
    	try {
    		while(fragmentation.isAutomaticRunning() && fragmentation.isAutomaticChecked() && ((fragmentation.getStatus() == EnumMemoryStatus.SEARCH) || (fragmentation.getStatus() == EnumMemoryStatus.CHOOSE) || (fragmentation.getStatus() == EnumMemoryStatus.FINISHED))) {
                panelMenu.foundSpace(fragmentation.execute());
                panelMenu.updateComponents();
                sleep(fragmentation.getSpeed());
            }
    		fragmentation.setAutomaticChecked(false);
    		fragmentation.setAutomaticRunning(false);
        } catch (InterruptedException e) {
        	System.out.println("Thread abgebrochen");
        }
    	panelMenu.updateComponents();
    }
}