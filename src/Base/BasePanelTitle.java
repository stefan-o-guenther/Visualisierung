/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public abstract class BasePanelTitle extends BasePanelUseModel {
	
	public BasePanelTitle(IManagement vManagement, BasePanelModel model) {
		super(model);
		
		
		
		if (vManagement != null) {
			management = vManagement;
			management.setSurface(EnumSurface.COLORED);
		}		
		initComponents();
	}	
	
	protected static final long serialVersionUID = 1L;
	
	protected ButtonGroup groupColor = new ButtonGroup();
	protected JRadioButton rdbtnColored;	
	protected JRadioButton rdbtnGray;	
	protected JLabel lblTitle;	
	
	protected IManagement management;
	
	protected abstract String getToolTip();
	protected abstract String getTitle();
		
	protected ActionListener ActionColor = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			String s = e.getActionCommand();
			if (s == "colored") {
				management.setSurface(EnumSurface.COLORED);
			} else if (s == "gray") {
				management.setSurface(EnumSurface.GRAY);
			}
			updateModel();
		}	
	};
	
	protected void initComponents() {
		String title = getTitle();
		String tooltip = getToolTip();
		ImageIcon imgIconHelp = ImageLoader.getImageIconHelp22();
		
		rdbtnColored = new JRadioButton("farbig");
		rdbtnColored.setActionCommand("colored");
		rdbtnColored.addActionListener(ActionColor);
		rdbtnGray = new JRadioButton("grau");
		rdbtnGray.setActionCommand("gray");
		rdbtnGray.addActionListener(ActionColor);
		groupColor.add(rdbtnColored);
		groupColor.add(rdbtnGray);
		rdbtnColored.setSelected(true);	
				
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
