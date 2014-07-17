package Rechnernetze.Pipeline_Protocol;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Base.ImageLoader;
import Base.ManagementAutomatic;
import Base.ManagementAutomaticTestImpl;
import Base.PanelMenuAutomaticControlAbstract;
import Base.ToolTipManagerAutomatic;
import Base.ToolTipManagerAutomaticTestImpl;

public class PanelRNPipelineProtocolMenuAutomaticControlImpl extends PanelMenuAutomaticControlAbstract {	
	
	public PanelRNPipelineProtocolMenuAutomaticControlImpl(ManagementPipelineProtocol management, ToolTipManagerPipelineProtocol tooltip) {
		super(management, tooltip);
		this.initPanel();
	}
	
	private PanelRNPipelineProtocolMenuAutomaticControlImpl() {
		super(new ManagementAutomaticTestImpl(), new ToolTipManagerAutomaticTestImpl());
		this.initComponents();
		this.initLayout();
	}
	
	private Color background;
	private JLabel lblRabbit;
	private JSlider sliderSpeed;
	private JLabel lblToolTip;
	private JLabel lblToolTip2;
	private JLabel lblTimeout1;
	private JLabel lblTimeout2;
	private JSlider slider;
	private JLabel lblTurtle;	
	
	private ManagementPipelineProtocol management;
	private ToolTipManagerPipelineProtocol tooltip;
	
	private Integer maxWait = 2000;
	private Integer minWait = 125;
	private Integer step = 125;
	private Integer initWait = 1000;	
	
	protected void initComponents() {
		this.management = (ManagementPipelineProtocol) this.getManagement();
		this.tooltip = (ToolTipManagerPipelineProtocol) this.getToolTipManager();
		
		lblToolTip = new JLabel(" ");
		lblToolTip.setIcon(ImageLoader.getImageIconHelp16());
		lblToolTip.setToolTipText(tooltip.getToolTipSpeed());
		
		lblRabbit = new JLabel("");
		lblRabbit.setIcon(ImageLoader.getImageIconRabbit());
		
		sliderSpeed = new JSlider();
		sliderSpeed.setMinimum(this.minWait);
		sliderSpeed.setMaximum(this.maxWait);
		sliderSpeed.setInverted(true);
		sliderSpeed.setValue(this.initWait);
		
		sliderSpeed.setMajorTickSpacing(this.step); //Abst�nde im Gro�raster
		sliderSpeed.setBackground(background);
		sliderSpeed.setPaintTicks(true);
		sliderSpeed.setSnapToTicks(true);
		sliderSpeed.setPaintLabels(false);
		//sliderSpeed.setMinorTickSpacing(10); //Abst�nde im Feinraster
    	
    	sliderSpeed.addChangeListener(changeSpeed);
    	
    	setSpeed();    	
	}
	
	@Override
	protected void initLayout() {		
		
		lblToolTip2 = new JLabel(" ");
		lblToolTip2.setIcon(new ImageIcon(PanelRNPipelineProtocolMenuAutomaticControlImpl.class.getResource("/Base/img/16x16_help.png")));
		
		lblTimeout1 = new JLabel("");
		lblTimeout1.setIcon(new ImageIcon(PanelRNPipelineProtocolMenuAutomaticControlImpl.class.getResource("/Base/img/timeout1.png")));
		
		lblTimeout2 = new JLabel("");
		lblTimeout2.setIcon(new ImageIcon(PanelRNPipelineProtocolMenuAutomaticControlImpl.class.getResource("/Base/img/timeout2.png")));
		
		slider = new JSlider();
		
		lblTurtle = new JLabel("");
		lblTurtle.setIcon(new ImageIcon(PanelRNPipelineProtocolMenuAutomaticControlImpl.class.getResource("/Base/img/turtle.png")));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblToolTip)
						.addComponent(lblToolTip2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTimeout1)
						.addComponent(lblTurtle, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(sliderSpeed, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
						.addComponent(slider, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTimeout2)
						.addComponent(lblRabbit))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblRabbit)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblToolTip)
							.addComponent(lblTurtle))
						.addComponent(sliderSpeed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(lblTimeout2)
							.addComponent(lblTimeout1))
						.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblToolTip2))
					.addGap(346))
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
	
	protected Boolean isAutomaticChecked() {
		return true;
	}
	
	@Override
	public void updatePanel() {
		if (management != null) {
			Boolean autoChe = management.isAutomaticChecked();
			sliderSpeed.setEnabled(autoChe);
		}
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
