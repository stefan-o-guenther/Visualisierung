/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Base;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;


public class PanelTitleImpl extends PanelAbstract {
	
	public PanelTitleImpl(Management management, ToolTipManager tooltip) {
		super(management, tooltip);
	}
	
	@Override
	public void updatePanel() {
		// nothing
	}	

	protected ButtonGroupColorImpl groupColor;
	protected JRadioButton rdbtnColored;	
	protected JRadioButton rdbtnGray;	
	protected JLabel lblTitle;	
	
	@Override
	protected void initComponents() {
		ImageIcon imgIconHelp = ImageLoader.getImageIconHelp22();	
		
		groupColor = new ButtonGroupColorImpl(management);
		rdbtnColored = groupColor.getRadioButtonColored();
		rdbtnGray = groupColor.getRadioButtonGray();
		groupColor.selectRadioButtonColored();
		
		lblTitle = new JLabel(management.getTitle());
		lblTitle.setFont(lblTitle.getFont().deriveFont(36f));
		lblTitle.setIcon(imgIconHelp);
		lblTitle.setToolTipText(tooltip.getToolTipTitle());
	}
	
	@Override
	protected void initLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(rdbtnGray, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(rdbtnColored, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(lblTitle))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rdbtnColored)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnGray))
						.addComponent(lblTitle)))
		);
		setLayout(groupLayout);
	}
}