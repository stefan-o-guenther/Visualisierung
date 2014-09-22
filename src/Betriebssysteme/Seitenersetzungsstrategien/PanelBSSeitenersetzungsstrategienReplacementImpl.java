/**
 * @author:	Stefan Otto Günther
 * @date:	22.10.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import Base.Labeling;
import Base.PanelMenuAbstract;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelBSSeitenersetzungsstrategienReplacementImpl extends PanelMenuAbstract {

	private static final long serialVersionUID = 1L;
	
	public PanelBSSeitenersetzungsstrategienReplacementImpl(ManagementPaging paging) {
		super(paging);
	}	
	
	public PanelBSSeitenersetzungsstrategienReplacementImpl() {
		super(new ManagementPagingImpl());		
		this.initComponentsMenu();
		this.initLayout();
	}
	
	private JLabel lblReplacementLabel;
	private JLabel lblReplacementValue;
	
	private ManagementPaging paging;
	private ToolTipManagerPaging tooltip;

	@Override
	protected void initComponentsMenu() {
		this.paging = (ManagementPaging) this.getManagement();
		this.tooltip = (ToolTipManagerPaging) paging.getToolTipManager();
		
		ImageIcon imgHelp = super.getImageIconHelp();
		
		lblReplacementLabel = new JLabel(Labeling.COUNT_PAGING+":");
		lblReplacementLabel.setIcon(imgHelp);	
		lblReplacementLabel.setToolTipText(tooltip.getToolTipPagingError());
		lblReplacementValue = new JLabel(" ");
	}

	@Override
	protected void initMethods() {
		// TODO Auto-generated method stub
		
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
	protected void initLayout() {
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
