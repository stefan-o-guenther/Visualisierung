/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class PanelMenuButtonsAbstract extends PanelMenuAbstract implements PanelMenuButtons {

	private static final long serialVersionUID = 1L;
	
	public PanelMenuButtonsAbstract(Management management) {
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

	private Management management;
	
	protected JButton btnExampleReset;
	protected JButton btnAssumeSaveExecute;
	
	protected abstract void loadExample();
	protected abstract void assume();
	protected abstract void input();
	protected abstract void clearFields();
	
	protected abstract Boolean hasExample();
	
	@Override
	public void updatePanel() {
		this.btnExampleReset.setEnabled(this.enableBtnExampleReset());
		this.btnAssumeSaveExecute.setEnabled(this.enableBtnAssumeExecute());
		
		EnumVisualizationStatus status = management.getStatus();
		switch (status) {
			case START: {
				btnExampleReset.setText(this.getBtnExampleText());
				btnAssumeSaveExecute.setText(this.getBtnAssumeText());
				break;
			}
			case INPUT: {
				btnExampleReset.setText(this.getBtnResetText());
				btnAssumeSaveExecute.setText(this.getBtnSaveText());
				break;
			}
			case RUN: {
				btnExampleReset.setText(this.getBtnResetText());
				btnAssumeSaveExecute.setText(this.getBtnExecuteText());
				break;
			}
			case NEXT: {
				btnExampleReset.setText(this.getBtnResetText());				
				btnAssumeSaveExecute.setText(this.getBtnExecuteText());
				break;
			}
			case FINISHED: {
				btnExampleReset.setText(this.getBtnResetText());
				btnAssumeSaveExecute.setText(this.getBtnExecuteText());				
				break;
			}
			default: {
				break;
			}
		}
		this.updatePanelExtra();
	}
	
	protected abstract void updatePanelExtra();
	
	private Boolean enableBtnExampleReset() {
		Boolean hasExample = this.hasExample();
		if (hasExample == null) {
			hasExample = true;
		}
		if ((management.getStatus() == EnumVisualizationStatus.START) && (!(hasExample))) {
			return false;
		} else {
			return true;
		}
	}
	
	private Boolean enableBtnAssumeExecute() {
		if (management.getStatus() == EnumVisualizationStatus.FINISHED) {
			return false;
		} else {
			return true;
		}
	}
	
	protected String getBtnExampleText() {
		Boolean hasExample = this.hasExample();
		if (hasExample == null) {
			hasExample = true;
		}		
		if (hasExample) {
			return Labeling.LOAD_EXAMPLE;
		} else {
			return Labeling.RESET;
		}
	}
	
	protected String getBtnResetText() {
		return Labeling.RESET;
	}
	
	protected String getBtnAssumeText() {
		return Labeling.ASSUME;
	}
	
	protected String getBtnSaveText() {
		return Labeling.SAVE;
	}
	
	protected String getBtnExecuteText() {
		if ((management.isAutomaticChecked()) && (management.getStatus() == EnumVisualizationStatus.RUN)) {
    		if (management.isAutomaticRunning()) {
        		return Labeling.STOP;
        	} else {
        		return Labeling.START;
        	}
    	} else {
    		return Labeling.NEXT_STEP;
    	}
	}
	
	protected void execute() {
		executeExtra();
		management.executeNormal();
	}	
	
	protected abstract void executeExtra();
	
	protected void reset() {
		clearFields();
		management.reset();
	}
	
	@Override
	protected void createMenuComponents() {
		btnExampleReset = new JButton(Labeling.LOAD_EXAMPLE);		
		btnAssumeSaveExecute = new JButton(Labeling.ASSUME);
		this.createMenuComponentsExtra();
	}
	
	protected abstract void createMenuComponentsExtra();

	@Override
	protected void createMenuMethods() {
		ActionListener actionExampleReset = new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				switch (management.getStatus()) {
					case START: {
						loadExample();
						break;
					}
					case INPUT: {
						reset();
						break;
					}
					case RUN: {
						reset();
						break;
					}
					case NEXT: {
						reset();
						break;
					}
					case FINISHED: {
						reset();
						break;
					}
					case ERROR: {
						
						break;
					}
					default: {						
						break;
					}
				}
				updatePanel();
			}
		};		
		
		ActionListener actionAssumeInputExecute = new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				switch (management.getStatus()) {
					case START: {				
						assume();						
						break;
					}
					case INPUT: {
						input();
						break;
					}
					case RUN: {		
						execute();
						break;
					}
					case NEXT: {
						execute();
						break;
					}
					case FINISHED: {
						execute();
						break;
					}
					case ERROR: {
						
						break;
					}
					default: {					
						break;
					}
				}
				updatePanel();
			}
		};
		btnExampleReset.addActionListener(actionExampleReset);
		btnAssumeSaveExecute.addActionListener(actionAssumeInputExecute);		
		
		this.createMenuMethodsExtra();
	}
	
	protected abstract void createMenuMethodsExtra();
}