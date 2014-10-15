/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Base;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;


public class PanelTitleImpl extends PanelLayoutAbstract {
	
	private static final long serialVersionUID = 1L;

	public PanelTitleImpl(Management management) {
		super();
		try {
			if (management == null) {
				throw new NullPointerException();
			}
			this.management = management;
			this.createPanel();
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Override
	public void updatePanel() {
		// nothing
	}	

	private Management management;
	
	private ButtonGroupColorImpl groupColor;
	private JRadioButton rdbtnColored;	
	private JRadioButton rdbtnGray;	
	private JLabel lblTitle;	
	
	@Override
	protected void createComponents() {
		ImageIcon imgIconHelp = ImageLoader.getImageIconHelp22();		
		ToolTipManager tooltip = management.getToolTipManager();
		
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
	protected void createLayout() {
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

	@Override
	public Integer getPanelHeight() {
		return 50;
	}

	@Override
	public Integer getPanelWidth() {
		return 50;
	}
}