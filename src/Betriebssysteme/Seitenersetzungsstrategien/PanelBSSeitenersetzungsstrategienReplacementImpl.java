/**
 * @author:	Stefan Otto Günther
 * @date:	22.10.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.ImageLoader;
import Base.ManagementFactory;
import Base.PanelLayoutAbstract;

public class PanelBSSeitenersetzungsstrategienReplacementImpl extends PanelLayoutAbstract {

	private static final long serialVersionUID = 1L;
	
	public PanelBSSeitenersetzungsstrategienReplacementImpl() {
		super();		
		///this.initializeExtra();
		this.createPanel();
	}
	
	/*
	private void initializeExtra() {
		this.initializeComponents();
		this.initializeLayout();
	}
	*/
	
	private JLabel lblReplacementLabel;
	private JLabel lblReplacementValue;
	
	private ManagementPaging paging;
	private ToolTipManagerPaging tooltip;

	@Override
	protected void createComponents() {
		this.paging = ManagementFactory.getManagementPaging();
		this.tooltip = ToolTipManagerPagingImpl.getInstance();
		
		ImageIcon imgHelp = ImageLoader.getImageIconHelp16();
		
		lblReplacementLabel = new JLabel(LabelingPaging.COUNT_PAGING+":");
		lblReplacementLabel.setIcon(imgHelp);	
		lblReplacementLabel.setToolTipText(tooltip.getToolTipPagingError());
		lblReplacementValue = new JLabel(" ");
	}

	@Override
	public void updatePanel() {
		lblReplacementLabel.setEnabled(true);
		lblReplacementValue.setEnabled(true);
		lblReplacementValue.setText(paging.getErrorCount().toString());
	}

	@Override
	public Integer getPanelHeight() {
		return 30;
	}

	@Override
	public Integer getPanelWidth() {
		return 100;
	}

	@Override
	protected void createLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblReplacementLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblReplacementValue)
					.addContainerGap(260, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReplacementLabel)
						.addComponent(lblReplacementValue))
					.addContainerGap(275, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
