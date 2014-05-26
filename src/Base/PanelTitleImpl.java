/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


public class PanelTitleImpl extends PanelAbstract implements PanelTitle {
	
	public PanelTitleImpl(Management management, ToolTipManager tooltip) {
		super(management, tooltip);
		this.initPanel();
	}
	
	@Override
	public void updatePanel() {
		// nothing
	}	

	protected ButtonGroupColorImpl groupColor;
	protected JRadioButton rdbtnColored;	
	protected JRadioButton rdbtnGray;	
	protected JLabel lblTitle;	
	
	protected void updateColor() {
		try {
			if (management != null) {
				management.setSurface(groupColor.getSelectedButton());
			}			
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Override
	protected void initComponents() {
		ImageIcon imgIconHelp = ImageLoader.getImageIconHelp22();	
		
		groupColor = new ButtonGroupColorImpl(actionColor);
		rdbtnColored = groupColor.geRadioButtonColored();
		rdbtnGray = groupColor.getRadioButtonGray();		
				
		lblTitle = new JLabel(management.getTitle());
		lblTitle.setFont(lblTitle.getFont().deriveFont(36f));
		lblTitle.setIcon(imgIconHelp);
		lblTitle.setToolTipText(tooltip.getToolTipTitle());
		
		updateColor();
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
	
	protected ActionListener actionColor = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			updateColor();
		}	
	};
}