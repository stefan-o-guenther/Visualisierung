package Rechnernetze.Queueing_And_Loss;

import Base.PanelMenuAutomaticControlAbstract;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSlider;
import javax.swing.ImageIcon;

public class PanelRNQueueingAndLossMenuAutomaticControlImpl extends PanelMenuAutomaticControlAbstract {
	
	private JLabel lblTransferRateLabel;
	private JLabel lblProcessingTimeLabel;
	private JLabel lblArrivalRateLabel;
	private JLabel lblTransferRateIcon1;
	private JLabel lblProcessingTimeIcon1;
	private JLabel lblArrivalRateIcon1;
	private JSlider sliderTransferRateIcon;
	private JSlider sliderProcessingTime;
	private JSlider sliderArrivalRate;
	private JLabel lblTransferRateIcon2;
	private JLabel lblProcessingTimeIcon2;
	private JLabel lblArrivalRateIcon;
	
	private Integer maxWait = 2000;
	private Integer minWait = 125;
	private Integer step = 125;
	private Integer initWait = 1000;

	public PanelRNQueueingAndLossMenuAutomaticControlImpl(ManagementQueueingAndLoss qal, ToolTipManagerQueueingAndLoss tooltip) {
		super(qal, tooltip);
		this.initPanel();
	}
	
	private PanelRNQueueingAndLossMenuAutomaticControlImpl() {
		super(new ManagementQueueingAndLossImpl(), new ToolTipManagerQueueingAndLossImpl());		
		this.initComponents();
		this.initLayout();
	}

	@Override
	public Integer getHeightMenu() {
		return 130;
	}

	@Override
	public void updatePanel() {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	protected void initComponents() {
		lblTransferRateLabel = new JLabel("\u00DCbertragungsrate Eingang:");
		lblTransferRateLabel.setIcon(new ImageIcon(PanelRNQueueingAndLossMenuAutomaticControlImpl.class.getResource("/Base/img/16x16_help.png")));
		
		lblProcessingTimeLabel = new JLabel("Verarbeitungszeit:");
		lblProcessingTimeLabel.setIcon(new ImageIcon(PanelRNQueueingAndLossMenuAutomaticControlImpl.class.getResource("/Base/img/16x16_help.png")));
		
		lblArrivalRateLabel = new JLabel("Ankuftsrate (Paketabstand):");
		lblArrivalRateLabel.setIcon(new ImageIcon(PanelRNQueueingAndLossMenuAutomaticControlImpl.class.getResource("/Base/img/16x16_help.png")));
		
		lblTransferRateIcon1 = new JLabel(" ");
		lblTransferRateIcon1.setIcon(new ImageIcon(PanelRNQueueingAndLossMenuAutomaticControlImpl.class.getResource("/Base/img/turtle.png")));
		
		lblProcessingTimeIcon1 = new JLabel(" ");
		lblProcessingTimeIcon1.setIcon(new ImageIcon(PanelRNQueueingAndLossMenuAutomaticControlImpl.class.getResource("/Base/img/timeout01.png")));
		
		lblArrivalRateIcon1 = new JLabel(" ");
		lblArrivalRateIcon1.setIcon(new ImageIcon(PanelRNQueueingAndLossMenuAutomaticControlImpl.class.getResource("/Base/img/timeout01.png")));
		
		sliderTransferRateIcon = new JSlider();
		sliderTransferRateIcon.setMinimum(this.minWait);
		sliderTransferRateIcon.setMaximum(this.maxWait);
		sliderTransferRateIcon.setInverted(true);
		sliderTransferRateIcon.setValue(this.initWait);
		
		sliderTransferRateIcon.setMajorTickSpacing(this.step); //Abst�nde im Gro�raster
		sliderTransferRateIcon.setBackground(background);
		sliderTransferRateIcon.setPaintTicks(true);
		sliderTransferRateIcon.setSnapToTicks(true);
		sliderTransferRateIcon.setPaintLabels(false);		
		
		sliderProcessingTime = new JSlider();
		sliderProcessingTime.setMinimum(this.minWait);
		sliderProcessingTime.setMaximum(this.maxWait);
		sliderProcessingTime.setInverted(true);
		sliderProcessingTime.setValue(this.initWait);
		
		sliderProcessingTime.setMajorTickSpacing(this.step); //Abst�nde im Gro�raster
		sliderProcessingTime.setBackground(background);
		sliderProcessingTime.setPaintTicks(true);
		sliderProcessingTime.setSnapToTicks(true);
		sliderProcessingTime.setPaintLabels(false);		
		
		sliderArrivalRate = new JSlider();
		sliderArrivalRate.setMinimum(this.minWait);
		sliderArrivalRate.setMaximum(this.maxWait);
		sliderArrivalRate.setInverted(true);
		sliderArrivalRate.setValue(this.initWait);
		
		sliderArrivalRate.setMajorTickSpacing(this.step); //Abst�nde im Gro�raster
		sliderArrivalRate.setBackground(background);
		sliderArrivalRate.setPaintTicks(true);
		sliderArrivalRate.setSnapToTicks(true);
		sliderArrivalRate.setPaintLabels(false);
		
		lblTransferRateIcon2 = new JLabel(" ");
		lblTransferRateIcon2.setIcon(new ImageIcon(PanelRNQueueingAndLossMenuAutomaticControlImpl.class.getResource("/Base/img/rabbit.png")));
		
		lblProcessingTimeIcon2 = new JLabel(" ");
		lblProcessingTimeIcon2.setIcon(new ImageIcon(PanelRNQueueingAndLossMenuAutomaticControlImpl.class.getResource("/Base/img/timeout02.png")));
		
		lblArrivalRateIcon = new JLabel(" ");
		lblArrivalRateIcon.setIcon(new ImageIcon(PanelRNQueueingAndLossMenuAutomaticControlImpl.class.getResource("/Base/img/timeout02.png")));		
	}

	@Override
	protected void initLayout() {		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblTransferRateLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblProcessingTimeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblArrivalRateLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblTransferRateIcon1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblProcessingTimeIcon1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblArrivalRateIcon1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(sliderTransferRateIcon, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
						.addComponent(sliderProcessingTime, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
						.addComponent(sliderArrivalRate, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblArrivalRateIcon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblProcessingTimeIcon2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTransferRateIcon2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblTransferRateLabel)
							.addComponent(lblTransferRateIcon1)
							.addComponent(lblTransferRateIcon2))
						.addComponent(sliderTransferRateIcon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblProcessingTimeIcon1)
							.addComponent(lblProcessingTimeIcon2)
							.addComponent(lblProcessingTimeLabel))
						.addComponent(sliderProcessingTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblArrivalRateLabel)
							.addComponent(lblArrivalRateIcon1)
							.addComponent(lblArrivalRateIcon))
						.addComponent(sliderArrivalRate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(388, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	@Override
	protected Boolean isAutomaticChecked() {
		return true;
	}
}
