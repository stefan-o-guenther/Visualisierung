package Rechnernetze.Queueing_And_Loss;

import Base.PanelMenuControlAbstract;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSlider;
import javax.swing.ImageIcon;

public class PanelRNQueueingAndLossControlImpl extends PanelMenuControlAbstract {
	
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
	
	

	public PanelRNQueueingAndLossControlImpl(ManagementQueueingAndLoss qal) {
		super(qal);
		this.initPanel();
	}
	
	private PanelRNQueueingAndLossControlImpl() {
		super(new ManagementQueueingAndLossImpl());		
		this.initComponents();
		this.initLayout();
	}

	@Override
	public void updatePanel() {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	protected void initComponentsMenu() {
		Integer maxWait = 2000;
		Integer minWait = 125;
		Integer step = 125;
		Integer initWait = 1000;
		
		lblTransferRateLabel = new JLabel("\u00DCbertragungsrate Eingang:");
		lblTransferRateLabel.setIcon(new ImageIcon(PanelRNQueueingAndLossControlImpl.class.getResource("/Base/img/16x16_help.png")));
		
		lblProcessingTimeLabel = new JLabel("Verarbeitungszeit:");
		lblProcessingTimeLabel.setIcon(new ImageIcon(PanelRNQueueingAndLossControlImpl.class.getResource("/Base/img/16x16_help.png")));
		
		lblArrivalRateLabel = new JLabel("Ankuftsrate (Paketabstand):");
		lblArrivalRateLabel.setIcon(new ImageIcon(PanelRNQueueingAndLossControlImpl.class.getResource("/Base/img/16x16_help.png")));
		
		lblTransferRateIcon1 = new JLabel(" ");
		lblTransferRateIcon1.setIcon(new ImageIcon(PanelRNQueueingAndLossControlImpl.class.getResource("/Base/img/turtle.png")));
		
		lblProcessingTimeIcon1 = new JLabel(" ");
		lblProcessingTimeIcon1.setIcon(new ImageIcon(PanelRNQueueingAndLossControlImpl.class.getResource("/Base/img/timeout01.png")));
		
		lblArrivalRateIcon1 = new JLabel(" ");
		lblArrivalRateIcon1.setIcon(new ImageIcon(PanelRNQueueingAndLossControlImpl.class.getResource("/Base/img/timeout01.png")));
		
		sliderTransferRateIcon = new JSlider();
		sliderTransferRateIcon.setMinimum(minWait);
		sliderTransferRateIcon.setMaximum(maxWait);
		sliderTransferRateIcon.setInverted(true);
		sliderTransferRateIcon.setValue(initWait);
		
		sliderTransferRateIcon.setMajorTickSpacing(step); //Abst‰nde im Groﬂraster
		sliderTransferRateIcon.setBackground(this.getBackground());
		sliderTransferRateIcon.setPaintTicks(true);
		sliderTransferRateIcon.setSnapToTicks(true);
		sliderTransferRateIcon.setPaintLabels(false);		
		
		sliderProcessingTime = new JSlider();
		sliderProcessingTime.setMinimum(minWait);
		sliderProcessingTime.setMaximum(maxWait);
		sliderProcessingTime.setInverted(true);
		sliderProcessingTime.setValue(initWait);
		
		sliderProcessingTime.setMajorTickSpacing(step); //Abst‰nde im Groﬂraster
		sliderProcessingTime.setBackground(this.getBackground());
		sliderProcessingTime.setPaintTicks(true);
		sliderProcessingTime.setSnapToTicks(true);
		sliderProcessingTime.setPaintLabels(false);		
		
		sliderArrivalRate = new JSlider();
		sliderArrivalRate.setMinimum(minWait);
		sliderArrivalRate.setMaximum(maxWait);
		sliderArrivalRate.setInverted(true);
		sliderArrivalRate.setValue(initWait);
		
		sliderArrivalRate.setMajorTickSpacing(step); //Abst‰nde im Groﬂraster
		sliderArrivalRate.setBackground(this.getBackground());
		sliderArrivalRate.setPaintTicks(true);
		sliderArrivalRate.setSnapToTicks(true);
		sliderArrivalRate.setPaintLabels(false);
		
		lblTransferRateIcon2 = new JLabel(" ");
		lblTransferRateIcon2.setIcon(new ImageIcon(PanelRNQueueingAndLossControlImpl.class.getResource("/Base/img/rabbit.png")));
		
		lblProcessingTimeIcon2 = new JLabel(" ");
		lblProcessingTimeIcon2.setIcon(new ImageIcon(PanelRNQueueingAndLossControlImpl.class.getResource("/Base/img/timeout02.png")));
		
		lblArrivalRateIcon = new JLabel(" ");
		lblArrivalRateIcon.setIcon(new ImageIcon(PanelRNQueueingAndLossControlImpl.class.getResource("/Base/img/timeout02.png")));		
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
	protected void initMethods() {		
		// nothing
	}
}
