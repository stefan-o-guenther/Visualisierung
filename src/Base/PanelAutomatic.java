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
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelAutomatic extends JPanel implements IPanelAutomatic {	
	
	public PanelAutomatic(IManagementAutomatic management, BasePanelMenuAutomatic panelMenu, Color background) {
		super();
		this.management = management;
		this.panelMenu = panelMenu;
		this.background = background;
		this.setBackground(background);
		initComponents();
		updateComponents();
	}
	
	public void setManagement(IManagementAutomatic management) {
		this.management = management;
	}
	
	public void setPanelMenu(BasePanelMenuAutomatic panelMenu) {
		this.panelMenu = panelMenu;
	}
	
	private Color background;
	private JLabel lblToolTip;
	private JLabel lblTurtle;
	private JLabel lblRabbit;
	private JCheckBox chckbxAutomatic;
	private JSlider sliderSpeed;
	
	private BasePanelMenuAutomatic panelMenu;
	private IManagementAutomatic management;
	private AutomaticThread tAuto; //= new AutoThread();
	
	private Boolean enabled;
	
	private void initComponents() {
		enabled = true;
		
		lblToolTip = new JLabel(" ");
		lblToolTip.setIcon(ImageLoader.getImageIconHelp16());
		lblToolTip.setToolTipText(ToolTipManager.getToolTipSpeed());
		
		lblTurtle = new JLabel(" ");
		lblTurtle.setIcon(ImageLoader.getImageIconTurtle());
		
		lblRabbit = new JLabel(" ");
		lblRabbit.setIcon(ImageLoader.getImageIconRabbit());
		
		chckbxAutomatic = new JCheckBox("automatischer Durchlauf");
		chckbxAutomatic.setBackground(background);
		chckbxAutomatic.addActionListener(actionAuto);
		
		sliderSpeed = new JSlider(0, 100, 50);
		sliderSpeed.setBackground(background);
		sliderSpeed.setPaintTicks(true);
		sliderSpeed.setSnapToTicks(true);
		sliderSpeed.setPaintLabels(false);
		sliderSpeed.setMinorTickSpacing(10); //Abstände im Feinraster
    	sliderSpeed.setMajorTickSpacing(20); //Abstände im Großraster
    	sliderSpeed.addChangeListener(changeSpeed);
    	
    	setSpeed();
		
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
	
	private void updateComponents() {
		if (management != null) {
			Boolean autoChe = management.isAutomaticChecked();
			chckbxAutomatic.setSelected(autoChe);
			sliderSpeed.setEnabled(autoChe);
		}		
		chckbxAutomatic.setEnabled(enabled);	
	}
	
	private void setSpeed() {		
		Integer speed = 2500 - (sliderSpeed.getValue() * 20);
		if (management != null) {
			management.setSpeed(speed);
		}		
	}
	
	private Boolean isAutomaticChecked() {
		return chckbxAutomatic.isSelected();
	}
	
	public void updateAutomatic() {
		updateComponents();
		if (panelMenu != null) {
			panelMenu.updateMenu();
		}		
	}
	
	public void startAutomatic() {
		if ((management != null) && (!(management.isAutomaticRunning())) && (management.isAutomaticChecked())) {
			management.setAutomaticRunning(true);
			tAuto = new AutomaticThread(management, this);
			tAuto.start();
		}
		updateAutomatic();
	}
	
	public void stopAutomatic() {
		if ((management != null) && (management.isAutomaticRunning())) {
			management.setAutomaticRunning(false);
			management.setAutomaticChecked(false);
		}
		updateAutomatic();
	}
	
	public void switchAutomatic() {
		if ((management != null) && (management.isAutomaticRunning())) {
			stopAutomatic();
		} else {
			startAutomatic();
		}
		updateAutomatic();
	}
	
	public void error() {
		if (panelMenu != null) {
			panelMenu.error();
		}	
	}	
	
	public void setAutomaticEnabled(Boolean enabled) {
		this.enabled = enabled;
		updateComponents();
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
}
