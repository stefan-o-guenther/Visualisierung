/**
 * @author:	Stefan Otto G�nther
 * @date:	27.01.2014
 */

package Base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public abstract class BasePanelTitle extends JPanel {
	
	public BasePanelTitle(IManagement vManagement) {
		super();		
		management = vManagement;
		initComponents();
		updateColor();
	}
	
	protected ActionListener actionColor = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			updateColor();
		}	
	};
	
	protected static final long serialVersionUID = 1L;
	
	protected ButtonGroupColor groupColor;
	protected JRadioButton rdbtnColored;	
	protected JRadioButton rdbtnGray;	
	protected JLabel lblTitle;	
	
	protected IManagement management;
	
	protected abstract String getToolTip();
	protected abstract String getTitle();
	
	protected void updateColor() {
		management.setSurface(groupColor.getSelectedButton());
	}
	
	protected void initComponents() {
		String title = getTitle();
		String tooltip = getToolTip();
		ImageIcon imgIconHelp = ImageLoader.getImageIconHelp22();	
		
		groupColor = new ButtonGroupColor("farbig", "grau", actionColor);
		rdbtnColored = groupColor.geRadioButtonColored();
		rdbtnGray = groupColor.getRadioButtonGray();		
				
		lblTitle = new JLabel(title);
		lblTitle.setFont(lblTitle.getFont().deriveFont(36f));
		lblTitle.setIcon(imgIconHelp);
		lblTitle.setToolTipText(tooltip);		
		
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