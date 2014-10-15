/**
 * @author:	Stefan Otto Günther
 * @date:	22.10.2014
 */

package Betriebssysteme.Seitenersetzungsstrategien;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import Base.EnumVisualizationStatus;
import Base.PanelMenuAbstract;

public class PanelBSSeitenersetzungsstrategienRMImpl extends PanelMenuAbstract {

	private static final long serialVersionUID = 1L;

	public PanelBSSeitenersetzungsstrategienRMImpl() {
		super();
		//this.initializeExtra();
		this.createPanel();
	}

	/*
	private void initializeExtra() {
		this.initializeMenuComponents();
		this.initializeLayout();
	}
	*/
	
	private JLabel lblToolTipR;
	private JLabel lblToolTipM;
	private JLabel lblOldStates;
	
	private JButton btnR;
	private JButton btnM;

	private JCheckBox chckbxkOldStates;
	
	private ManagementPaging paging;
	private ToolTipManagerPaging tooltip;
	
	@Override
	public void updatePanel() {
		Boolean isRmVisible = paging.isRmVisible();
		Boolean isRmEnabled = paging.isRmEnabled();
		Boolean oldStates = paging.isViewOldStatesEnabled();
		chckbxkOldStates.setSelected(oldStates);
		EnumVisualizationStatus status = paging.getStatus();
		switch (status) {
			case START: {
				btnR.setEnabled(false);
				btnR.setVisible(false);
				btnM.setEnabled(false);
				btnM.setVisible(false);
				chckbxkOldStates.setEnabled(false);
				chckbxkOldStates.setVisible(false);
				lblOldStates.setEnabled(false);
				lblOldStates.setVisible(false);				
				lblToolTipR.setEnabled(false);
				lblToolTipR.setVisible(false);
				lblToolTipM.setEnabled(false);
				lblToolTipM.setVisible(false);
				break;
			}
			case RUN: {				
				btnR.setEnabled(isRmEnabled);
				btnR.setVisible(isRmVisible);
				btnM.setEnabled(isRmEnabled);				
				btnM.setVisible(isRmVisible);
				chckbxkOldStates.setEnabled(isRmVisible);
				chckbxkOldStates.setVisible(isRmVisible);
				lblOldStates.setEnabled(isRmVisible);
				lblOldStates.setVisible(isRmVisible);
				lblToolTipR.setEnabled(isRmVisible);
				lblToolTipR.setVisible(isRmVisible);
				lblToolTipM.setEnabled(isRmVisible);
				lblToolTipM.setVisible(isRmVisible);	
				break;
			}
			case FINISHED: {
				btnR.setEnabled(isRmVisible);
				btnR.setVisible(isRmVisible);
				btnM.setEnabled(isRmVisible);				
				btnM.setVisible(isRmVisible);
				chckbxkOldStates.setEnabled(isRmVisible);
				chckbxkOldStates.setVisible(isRmVisible);
				lblOldStates.setEnabled(isRmVisible);
				lblOldStates.setVisible(isRmVisible);
				lblToolTipR.setEnabled(isRmVisible);
				lblToolTipR.setVisible(isRmVisible);
				lblToolTipM.setEnabled(isRmVisible);
				lblToolTipM.setVisible(isRmVisible);
				break;
			}
			default: {
				break;
			}
		}		
	}

	@Override
	public Integer getPanelHeight() {
		return 40;
	}

	@Override
	public Integer getPanelWidth() {
		return 100;
	}

	@Override
	protected void createMenuComponents() {
		this.paging = ManagementPagingImpl.getInstance();
		this.tooltip = ToolTipManagerPagingImpl.getInstance();
		
		ImageIcon imgHelp = super.getImageIconHelp();
		
		lblToolTipR = new JLabel(" ");
		lblToolTipR.setIcon(imgHelp);
		lblToolTipR.setToolTipText(tooltip.getToolTipR());
		
		btnR = new JButton(LabelingPaging.RESET_R_BITS);		
		
		lblToolTipM = new JLabel(" ");
		lblToolTipM.setIcon(imgHelp);
		lblToolTipM.setToolTipText(tooltip.getToolTipM());
		
		btnM = new JButton(LabelingPaging.SET_M_BIT);		
		
		lblOldStates = new JLabel(" ");
		lblOldStates.setIcon(imgHelp);
		lblOldStates.setToolTipText(tooltip.getToolTipOldStates());
		
		chckbxkOldStates = new JCheckBox(LabelingPaging.OLD_STATES);
		chckbxkOldStates.setBackground(Color.WHITE);
	}

	@Override
	protected void createLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblToolTipR)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnR)
					.addGap(18)
					.addComponent(lblToolTipM)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnM)
					.addGap(18)
					.addComponent(lblOldStates)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxkOldStates)
					.addContainerGap(237, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblToolTipR)
						.addComponent(btnR)
						.addComponent(lblToolTipM)
						.addComponent(btnM)
						.addComponent(lblOldStates)
						.addComponent(chckbxkOldStates))
					.addContainerGap(275, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	@Override
	protected void createMenuMethods() {
		ActionListener actionResetR = new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				paging.resetRBits();
				updatePanel();
			}
		};

		ActionListener actionSetM = new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				paging.setMBit();
				updatePanel();
			}
		};
		
		ActionListener actionOldStates = new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				paging.setViewOldStatesEnabled(chckbxkOldStates.isSelected());
				updatePanel();
			}
		};
		
		btnR.addActionListener(actionResetR);
		btnM.addActionListener(actionSetM);
		chckbxkOldStates.addActionListener(actionOldStates);
	}
}
