/**
 * @author:	Stefan Otto Günther
 * @date:	09.09.2014
 */

package Base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class PanelMenuMenuButtonsAbstract extends PanelMenuAbstract {

	private static final long serialVersionUID = 1L;
	
	public PanelMenuMenuButtonsAbstract(Management management) {
		super(management);
	}

	protected JButton btnExampleReset;
	protected JButton btnAssumeExecute;	
	
	protected abstract void updatePanelMenuButtons();
	protected abstract void initComponentsMenuButtons();
	protected abstract void initMethodsMenuButtons();
	protected abstract void loadExample();
	protected abstract void assume();
	protected abstract void clearFields();
	protected abstract void executeExtra();
	
	@Override
	public void updatePanel() {
		btnExampleReset.setEnabled(true);
		EnumVisualizationStatus status = management.getStatus();
		switch (status) {
			case START: {
				btnExampleReset.setText(Labeling.LOAD_EXAMPLE);
				btnAssumeExecute.setEnabled(true);
				btnAssumeExecute.setText(Labeling.ASSUME);
				break;
			}
			case INPUT: {
				btnExampleReset.setText(Labeling.RESET);
				btnAssumeExecute.setEnabled(true);
				btnAssumeExecute.setText(Labeling.SAVE);
				break;
			}
			case RUN: {				
				btnExampleReset.setText(Labeling.RESET);				
				btnAssumeExecute.setEnabled(true);
				btnAssumeExecute.setText(management.getButtonAutomaticText());
				break;
			}
			case NEXT: {
				btnExampleReset.setText(Labeling.RESET);				
				btnAssumeExecute.setEnabled(true);
				btnAssumeExecute.setText(Labeling.NEXT_STEP);
				break;
			}
			case FINISHED: {
				btnExampleReset.setText(Labeling.RESET);
				btnAssumeExecute.setEnabled(false);
				btnAssumeExecute.setText(Labeling.NEXT_STEP);				
				break;
			}
			default: {
				break;
			}
		}
		this.updatePanelMenuButtons();
	}

	@Override
	protected void initComponentsMenu() {
		btnExampleReset = new JButton(Labeling.LOAD_EXAMPLE);		
		btnAssumeExecute = new JButton(Labeling.ASSUME);
		this.initComponentsMenuButtons();
	}

	@Override
	protected void initMethods() {
		ActionListener actionExampleReset = new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				switch (management.getStatus()) {
					case START: {
						loadExample();
						break;
					}
					case RUN:
					case FINISHED: {
						clearFields();
						management.reset();
						break;
					}
					default: {						
						break;
					}
				}
				updatePanel();
			}
		};		
		
		ActionListener actionAssumeExecute = new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				switch (management.getStatus()) {
					case START: {				
						assume();						
						break;
					}
					case RUN: {		
						executeExtra();
						management.executeNormal();
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
		btnAssumeExecute.addActionListener(actionAssumeExecute);		
		
		this.initMethodsMenuButtons();
	}
}