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

public class PanelTitle extends BasePanelUseModel {
	
	private ButtonGroup groupColor = new ButtonGroup();
	private JRadioButton rdbtnColored;	
	private JRadioButton rdbtnGray;
	
	private JLabel lblTitle;	
	private String title;
	private String tooltip;
	
	private IManagement management;
	
	private ImageIcon getHelp() {
		ImageIcon icon = null;
		try {
			InputStream stream = BasePanelMenu.class.getResourceAsStream("img/32x32_help.png");
			icon = new ImageIcon(ImageIO.read(stream));				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return icon;
	}
	
	private ActionListener ActionColor = new ActionListener() {
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
	
	private void initComponents() {
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
		lblTitle.setIcon(getHelp());
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
	
	public PanelTitle(IManagement vManagement, BasePanelModel model, String vTitle, String vToolTip) {
		super(model);
		title = "";
		if (vTitle != null) {
			title = vTitle;			
		}
		tooltip = "";
		if (vToolTip != null) {
			tooltip = vToolTip;
		}
		if (vManagement != null) {
			management = vManagement;
			management.setSurface(EnumSurface.COLORED);
		}		
		initComponents();
	}	
}
