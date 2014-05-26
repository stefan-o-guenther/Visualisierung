/**
 * @author:	Stefan Otto Günther
 * @date:	20.02.2014
 */

package Base;

public class AutomaticThread extends Thread {
   
	private PanelAutomaticAbstract panelAutomatic;
	private ManagementAutomatic management;
  
	public AutomaticThread(ManagementAutomatic management, PanelAutomaticAbstract panelMenu) {
    	super();
    	try {
    		if ((management == null) || (panelMenu == null)) {
    			throw new NullPointerException();
    		}
    		this.panelAutomatic = panelMenu;
        	this.management = management;
    	} catch (Exception ex) {
    		throw ex;
    	}
    }
  
    public void run() {
    	try {
    		while(management.isAutomaticRunning() && management.isAutomaticChecked()) {
                if (!(management.execute())) {
                	panelAutomatic.error();
                }
    			panelAutomatic.updatePanel();
                sleep(management.getSpeed());
            }
    		management.setAutomaticChecked(false);
    		management.setAutomaticRunning(false);
        } catch (InterruptedException e) {
        	System.out.println("Thread abgebrochen");
        }
    	panelAutomatic.updatePanel();
    }
}