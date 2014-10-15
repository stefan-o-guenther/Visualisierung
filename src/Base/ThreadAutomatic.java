/**
* @author: Stefan Otto Günther
* @date: 20.02.2014
*/

package Base;

public class ThreadAutomatic extends Thread {

	private Management management;

	public ThreadAutomatic(Management management) {
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
			management.setAutomaticRunning(true);
			while(management.isAutomaticPlay() && management.isAutomaticChecked() && (management.getStatus() == EnumVisualizationStatus.RUN)) {				
				management.executeThread();				
				sleep(0);
			}
			management.setAutomaticRunning(false);
			management.setAutomaticChecked(false);
			management.setAutomaticRunning(false);
			management.updateViews();
		} catch (InterruptedException e) {
			System.out.println("Thread abgebrochen");
		}
	}
}