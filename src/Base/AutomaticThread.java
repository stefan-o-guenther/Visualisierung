/**
 * @author:	Stefan Otto Günther
 * @date:	20.02.2014
 */

package Base;

public class AutomaticThread extends Thread {
   
	private PanelAutomaticImpl panelAutomatic;
	private ManagementAutomatic management;
  
	public AutomaticThread(ManagementAutomatic management, PanelAutomaticImpl panelMenu) {
    	super();
    	this.panelAutomatic = panelMenu;
    	this.management = management;
    }
  
    public void run() {
    	try {
    		while(management.isAutomaticRunning() && management.isAutomaticChecked()) {
                if (!(management.execute())) {
                	panelAutomatic.error();
                }
    			panelAutomatic.updateAutomatic();
                sleep(management.getSpeed());
            }
    		management.setAutomaticChecked(false);
    		management.setAutomaticRunning(false);
        } catch (InterruptedException e) {
        	System.out.println("Thread abgebrochen");
        }
    	panelAutomatic.updateAutomatic();
    }
}