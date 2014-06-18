/**
 * @author:	Stefan Otto Günther
 * @date:	21.02.2014
 */

package Base;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelMenuAutomaticControlImpl extends PanelMenuAutomaticAbstract implements PanelMenuAutomaticControl {	
	
	public PanelMenuAutomaticControlImpl(ManagementAutomatic management, ToolTipManagerAutomatic tooltip) {
		super(management, tooltip);
		this.initPanel();
	}
	
	private Color background;
	private JLabel lblToolTip;
	private JLabel lblTurtle;
	private JLabel lblRabbit;
	private JCheckBox chckbxAutomatic;
	private JSlider sliderSpeed;
	
	private ManagementAutomatic management;
	private ToolTipManagerAutomatic tooltip;
	
	private Integer maxWait = 2000;
	private Integer minWait = 125;
	private Integer step = 125;
	private Integer initWait = 1000;	
	
	protected void initComponents() {
		this.management = (ManagementAutomatic) this.getManagement();
		this.tooltip = (ToolTipManagerAutomatic) this.getToolTipManager();
		
		lblToolTip = new JLabel(" ");
		lblToolTip.setIcon(ImageLoader.getImageIconHelp16());
		lblToolTip.setToolTipText(tooltip.getToolTipSpeed());
		
		lblTurtle = new JLabel(" ");
		lblTurtle.setIcon(ImageLoader.getImageIconTurtle());
		
		lblRabbit = new JLabel(" ");
		lblRabbit.setIcon(ImageLoader.getImageIconRabbit());
		
		chckbxAutomatic = new JCheckBox("automatischer Durchlauf");
		chckbxAutomatic.setBackground(background);
		chckbxAutomatic.addActionListener(actionAuto);
		
		sliderSpeed = new JSlider();
		sliderSpeed.setMinimum(this.minWait);
		sliderSpeed.setMaximum(this.maxWait);
		sliderSpeed.setInverted(true);
		sliderSpeed.setValue(this.initWait);
		
		sliderSpeed.setMajorTickSpacing(this.step); //Abstände im Großraster
		sliderSpeed.setBackground(background);
		sliderSpeed.setPaintTicks(true);
		sliderSpeed.setSnapToTicks(true);
		sliderSpeed.setPaintLabels(false);
		//sliderSpeed.setMinorTickSpacing(10); //Abstände im Feinraster
    	
    	sliderSpeed.addChangeListener(changeSpeed);
    	
    	setSpeed();    	
	}
	
	@Override
	protected void initLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(lblToolTip))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTurtle)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(sliderSpeed, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblRabbit))
						.addComponent(chckbxAutomatic))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblRabbit)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxAutomatic)
								.addComponent(lblToolTip))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblTurtle)
								.addComponent(sliderSpeed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(231, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}		
	
	private void updateAutomatic() {
		updatePanel();
		management.updateAllPanels();
	}	
	
	private void setSpeed() {
		Integer value = sliderSpeed.getValue();
		if (management != null) {
			management.setSpeed(value);
		}		
	}
	
	private Boolean isAutomaticChecked() {
		return chckbxAutomatic.isSelected();
	}
	
	@Override
	public void updatePanel() {
		if (management != null) {
			Boolean autoChe = management.isAutomaticChecked();
			chckbxAutomatic.setSelected(autoChe);
			sliderSpeed.setEnabled(autoChe);
		}		
		chckbxAutomatic.setEnabled(management.isAutomaticEnabled());	
	}
	

	
	private ActionListener actionAuto = new ActionListener() {
		public void actionPerformed (ActionEvent e) {
			if (management != null) {
				management.setAutomaticChecked(isAutomaticChecked());
			}			
			updateAutomatic();
		}
	};
	
	private ChangeListener changeSpeed = new ChangeListener() {
		public void stateChanged(ChangeEvent arg0) {
			setSpeed();
			updateAutomatic();
		}
	};

	@Override
	public Integer getHeightMenu() {
		return 10;
	}
}
