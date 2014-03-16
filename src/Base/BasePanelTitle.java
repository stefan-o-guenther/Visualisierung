/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public abstract class BasePanelTitle extends BasePanel implements IPanelTitle {
	
	public BasePanelTitle(IManagement management) {
		super();		
		this.management = management;
		initComponents();
		updateColor();
	}
	
	public void setManagement(IManagement management) {
		this.management = management;
	}
	
	protected ActionListener actionColor = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			updateColor();
		}	
	};
	
	protected ButtonGroupColor groupColor;
	protected JRadioButton rdbtnColored;	
	protected JRadioButton rdbtnGray;	
	protected JLabel lblTitle;	
	
	protected IManagement management;
	
	public void updateColor() {
		management.setSurface(groupColor.getSelectedButton());
	}
	
	public void initComponents() {
		ImageIcon imgIconHelp = ImageLoader.getImageIconHelp22();	
		
		groupColor = new ButtonGroupColor(actionColor);
		rdbtnColored = groupColor.geRadioButtonColored();
		rdbtnGray = groupColor.getRadioButtonGray();		
				
		lblTitle = new JLabel(getTitle());
		lblTitle.setFont(lblTitle.getFont().deriveFont(36f));
		lblTitle.setIcon(imgIconHelp);
		lblTitle.setToolTipText(getToolTip());		
		
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