/**
 * @author:	Stefan Otto Günther
 * @date:	21.02.2014
 */

package Base;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public abstract class PanelMenuControlSliderAbstract extends PanelMenuControlAbstract {	
		
	public PanelMenuControlSliderAbstract(Management management, ToolTipManager tooltip) {
		super(management, tooltip);
	}
	
	private PanelMenuControlSliderAbstract() {
		super(new ManagementTestImpl(), new ToolTipManagerTestImpl());		
	}
	
	private JLabel lblImageIconLeft;
	private JLabel lblImageIconRight;
	private JLabel lblLabel;
	private JSlider slider;
	
	protected abstract Integer getMax();
	protected abstract Integer getMin();
	protected abstract Integer getStep();
	protected abstract Integer getInit();
	protected abstract ImageIcon getImageIconLeft();
	protected abstract ImageIcon getImageIconRight();
	protected abstract String getLabel();
	protected abstract Boolean isInverted();
	protected abstract void setSliderValueToManagement(Integer value);
	protected abstract String getToolTip();
	
	protected void initComponentsMenu() {	
		lblLabel = new JLabel(this.getLabel());
		lblLabel.setIcon(this.getImageIconHelp());
		lblLabel.setToolTipText(getToolTip());
		
		lblImageIconLeft = new JLabel("");
		lblImageIconLeft.setIcon(this.getImageIconLeft());		
		
		lblImageIconRight = new JLabel("");
		lblImageIconRight.setIcon(this.getImageIconRight());				
		
		slider = new JSlider();
		slider.setMinimum(this.getMin());
		slider.setMaximum(this.getMax());
		slider.setInverted(this.isInverted());
		slider.setValue(this.getInit());
		
		slider.setMajorTickSpacing(this.getStep()); //Abstände im Großraster
		slider.setBackground(this.getBackground());
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setPaintLabels(false);
		//sliderSpeed.setMinorTickSpacing(10); //Abstände im Feinraster    	
    	updateSliderValue();    	
	}
	
	@Override
	protected void initLayout() {			
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblImageIconLeft)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(slider, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblImageIconRight)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(slider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblImageIconLeft, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblImageIconRight, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	@Override
	protected void initMethods() {
		ChangeListener changeSpeed = new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				updateSliderValue();
				updateAutomatic();
			}
		};
		slider.addChangeListener(changeSpeed);
	}
	
	private void updateAutomatic() {
		management.updateAllPanels();
	}	
	
	private void updateSliderValue() {
		Integer value = slider.getValue();
		this.setSliderValueToManagement(value);
	}
	
	@Override
	public void updatePanel() {
		if (management != null) {
			Boolean autoCheck = management.isAutomaticChecked();
			slider.setEnabled(autoCheck);			
		}
	}
	
	@Override
	public Integer getHeightMenu() {
		return 30;
	}
}
