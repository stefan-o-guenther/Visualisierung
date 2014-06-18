/**
 * @author:	Stefan Otto Günther
 * @date:	20.02.2014
 */

package Base;

public class ThreadAutomatic extends Thread {
   
	private ManagementAutomatic management;
  
	public ThreadAutomatic(ManagementAutomatic management) {
    	super();
    	try {
    		if (management == null) {
    			throw new NullPointerException();
    		}
    		this.management = management;
    	} catch (Exception ex) {
    		throw ex;
    	}
    }
  
    public void run() {
    	try {
    		while(management.isAutomaticRunning() && management.isAutomaticChecked()) {
                if (!(management.execute())) {
    				management.setAutomaticChecked(false);
            		management.setAutomaticRunning(false);
                	management.showErrorMessage();
                }
    			sleep(management.getSpeed());
            }
    		management.setAutomaticChecked(false);
    		management.setAutomaticRunning(false);
        } catch (InterruptedException e) {
        	System.out.println("Thread abgebrochen");
        }
    }
}