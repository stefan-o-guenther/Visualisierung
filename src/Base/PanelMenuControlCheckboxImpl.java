/**
 * @author:	Stefan Otto Günther
 * @date:	21.02.2014
 */

package Base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelMenuControlCheckboxImpl extends PanelMenuControlAbstract {	
		
	public PanelMenuControlCheckboxImpl(Management management, ToolTipManager tooltip) {
		super(management, tooltip);
	}
	
	private PanelMenuControlCheckboxImpl() {
		super(new ManagementTestImpl(), new ToolTipManagerTestImpl());
	}
	
	private JCheckBox chckbxAutomatic;	
	private JLabel lblToolTip;
	
	protected void initComponentsMenu() {		
		lblToolTip = new JLabel(" ");
		lblToolTip.setIcon(ImageLoader.getImageIconHelp16());
		lblToolTip.setToolTipText(tooltip.getToolTipAutomaticCheckbox());
		
		chckbxAutomatic = new JCheckBox("automatischer Durchlauf");
		chckbxAutomatic.setBackground(this.getBackground());
		//sliderSpeed.setMinorTickSpacing(10); //Abstände im Feinraster     	    	
	}
	
	@Override
	protected void initLayout() {		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblToolTip)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxAutomatic)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblToolTip)
						.addComponent(chckbxAutomatic))
					.addContainerGap(85, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	@Override
	protected void initMethods() {
		ActionListener actionAuto = new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if (management != null) {
					management.setAutomaticChecked(isAutomaticChecked());
				}
				updateAutomatic();
			}
		};		
		chckbxAutomatic.addActionListener(actionAuto);
	}
	
	private void updateAutomatic() {
		management.updateAllPanels();
	}	
	
	private Boolean isAutomaticChecked() {
		return chckbxAutomatic.isSelected();
	}
	
	@Override
	public void updatePanel() {
		if (management != null) {
			Boolean autoChe = management.isAutomaticChecked();
			chckbxAutomatic.setSelected(autoChe);			
		}		
		chckbxAutomatic.setEnabled(management.isAutomaticEnabled());	
	}	

	@Override
	public Integer getHeightMenu() {
		return 25;
	}
}
