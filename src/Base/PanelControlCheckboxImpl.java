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

public class PanelControlCheckboxImpl extends PanelControlAbstract {	
		
	private static final long serialVersionUID = 1L;
	
	public PanelControlCheckboxImpl(Management management) {
		super(management);
		this.createPanel();
	}
	
	private PanelControlCheckboxImpl() {
		super(ManagementTestImpl.getInstance());
		this.createMenuComponents();
		this.createLayout();
	}
	
	private JCheckBox chckbxAutomatic;	
	private JLabel lblToolTip;
	
	protected void createMenuComponents() {
		ToolTipManager tooltip = management.getToolTipManager();
		lblToolTip = new JLabel(" ");
		lblToolTip.setIcon(ImageLoader.getImageIconHelp16());
		lblToolTip.setToolTipText(tooltip.getToolTipAutomaticCheckbox());
		
		chckbxAutomatic = new JCheckBox("automatischer Durchlauf");
		chckbxAutomatic.setBackground(this.getBackground());
		//sliderSpeed.setMinorTickSpacing(10); //Abstände im Feinraster     	    	
	}
	
	@Override
	protected void createLayout() {		
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
	protected void createMenuMethods() {
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
		management.updateViews();
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
	public Integer getPanelHeight() {
		return 25;
	}

	@Override
	public Integer getPanelWidth() {
		return 10;
	}
}
