package Base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelTitle extends JPanel {
	
	private ButtonGroup groupColor = new ButtonGroup();
	private JRadioButton rdbtnColored;	
	private JRadioButton rdbtnGray;
	
	private JLabel lblTitle;	
	private String title = "";	
	private EnumSurface color = EnumSurface.COLORED;
	private BasePanelModel model = null;
	
	private ActionListener ActionColor = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			String s = e.getActionCommand();
			if (s == "colored") {
				color = EnumSurface.COLORED;
			} else if (s == "gray") {
				color = EnumSurface.GRAY;				
			}
			updateModel();
		}	
	};
	
	private void updateModel() {
		if (model != null) {
			model.updateColor(color);
		}		
	}
	
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
			lblTitle.setFont(lblTitle.getFont().deriveFont(48f));
			
			GroupLayout groupLayout = new GroupLayout(this);
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(rdbtnColored)
							.addComponent(rdbtnGray, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
						.addGap(42)
						.addComponent(lblTitle)
						.addGap(1023))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(lblTitle)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(rdbtnColored)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(rdbtnGray)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			setLayout(groupLayout);
	}
	
	public PanelTitle(String value, BasePanelModel panel) {
		if ((value != null) && (panel != null)) {
			title = value;
			model = panel;			
			initComponents();
		}				
	}	
}
