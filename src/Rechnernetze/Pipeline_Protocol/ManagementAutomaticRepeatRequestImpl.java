/**
 * @author:	Stefan Otto Günther
 * @date:	27.01.2014
 */

package Rechnernetze.Pipeline_Protocol;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Base.Checker;
import Base.EnumAutomaticChecked;
import Base.EnumSurface;
import Base.EnumVisualizationStatus;
import Base.ManagementGeometryAbstract;
import Base.ToolTipManager;

public class ManagementAutomaticRepeatRequestImpl extends ManagementGeometryAbstract implements ManagementAutomaticRepeatRequest {

	public ManagementAutomaticRepeatRequestImpl() {
    	super();
    }
 
    private ARQProtocolStrategy arq;
	private Integer speedPacket;
	private Integer timeout;
	
	@Override
	protected void initialize() {	
		arq = null;
	}
	
	@Override
	protected void create() {		
		
	}

	@Override
	protected Boolean execute() {
		if (arq != null) {
			arq.execute();
		}		
		return true;
	}	
	
	@Override
	public String getTitle() {
		return "Pipeline Protocol";
	}

	@Override
	protected void showErrorMessage() {
		
	}

	@Override
	protected void updateSize() {	
		
	}
	
	@Override
	public List<PacketArq> getListPacket() {
		if (arq != null) {
			return arq.getListPacket();
		} else {
			return new ArrayList<PacketArq>();
		}
	}

	@Override
	public Integer getPositionStart() {
		return this.getY0();
	}

	@Override
	public Integer getPositionTarget() {
		return this.getYMax();
	}

	@Override
	public Integer getPacketHeight() {
		return 40;
	}

	@Override
	public Integer getPacketWidth() {
		return 20;
	}

	@Override
	protected EnumAutomaticChecked keepAutomaticChecked() {
		return EnumAutomaticChecked.ALWAYS;
	}
	
	@Override
	public Integer getGapBetweenX() {
		return this.getPacketWidth() + this.getGapBetweenPackets();
	}

	@Override
	public Integer getGapBetweenY() {
		return 1;
	}

	@Override
	public Integer getIntervalX() {
		return 1;
	}

	@Override
	public Integer getIntervalY() {
		return 1;
	}

	@Override
	public Integer getPositionX0() {
		return this.getGapLeft();
	}

	@Override
	public Integer getPositionY0() {
		return this.getGapTop();
	}

	@Override
	public Integer getPositionXMax() {
		return (this.getPositionX0() + this.getAxisXLength());
	}

	@Override
	public Integer getPositionYMax() {
		return (this.getPositionY0() + this.getAxisYLength());
	}

	@Override
	public Integer XToPositionX(Integer x) {
		try {
			if (x == null) {
				throw new NullPointerException();
			}
			Integer x0 = this.getPositionX0();
			Integer xp = x0 + (x * this.getGapBetweenX());
			return xp;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Integer YToPositionY(Integer y) {
		try {
			if (y == null) {
				throw new NullPointerException();
			}
			Integer y0 = this.getPositionY0();
			Integer yp = y0 + (y * this.getGapBetweenY());
			return yp;
		} catch (Exception ex) {
			throw ex;
		}	
	}

	@Override
	public Boolean isSameLength() {
		return false;
	}

	@Override
	protected Integer getGapLeft() {
		return 10;
	}

	@Override
	protected Integer getGapRight() {
		return 0;
	}

	@Override
	protected Integer getGapTop() {
		return 10 + this.getPacketHeight() + 25;
	}

	@Override
	protected Integer getGapBottom() {
		return 10 + (2 * this.getPacketHeight()) + 25;
	}

	@Override
	protected Integer getGapHorizontal() {
		return 0;
	}

	@Override
	protected Integer getGapVertical() {
		return 0;
	}

	@Override
	public Integer getGapBetweenPackets() {
		return 10;
	}

	@Override
	public Sender[] getArraySender() {
		if (arq != null) {
			return arq.getArraySender();
		} else {
			return new Sender[0];
		}
	}

	@Override
	public Receiver[] getArrayReceiver() {
		if (arq != null) {
			return arq.getArrayReceiver();
		} else {
			return new Receiver[0];
		}
	}

	@Override
	public void assume(EnumARQStrategy strategy) {
		try {
			Checker.checkIfNotNull(strategy);
			this.arq = ARQProtocolStrategyFactory.getStrategy(strategy, this.getXMax());
			this.arq.setSpeedPacket(speedPacket);
			this.arq.setTimeout(timeout);
			this.setStatus(EnumVisualizationStatus.RUN);
			this.updateViews();
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Boolean canSendPacket() {
		if (arq != null) {
			return arq.canSendPacket();
		} else {
			return false;
		}
	}

	@Override
	public void sendPacket() {
		if (arq != null) {
			arq.sendPacket();
		}
	}

	@Override
	public void setSpeedPacket(Integer speed) {
		try {
			Checker.checkIfNotNull(speed);
			if (this.arq != null) {
				this.arq.setSpeedPacket(speed);
			}
			this.speedPacket = speed;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public void setTimeout(Integer timeout) {
		try {
			Checker.checkIfIntegerNotLessZero(timeout);
			Integer t = timeout * 1000;
			if (arq != null) {
				arq.setTimeout(t);
			}
			this.timeout = t;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public void deletePacket(PacketArq packet) {
		try {
			Checker.checkIfNotNull(packet);
			this.arq.deletePacket(packet);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public void disablePacket(PacketArq packet) {
		try {
			Checker.checkIfNotNull(packet);
			this.arq.disablePacket(packet);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public ToolTipManager getToolTipManager() {
		return ToolTipManagerARQImpl.getInstance();
	}

	@Override
	public Integer getWindowSenderBase() {
		if (arq != null) {
			return arq.getBaseSender();
		} else {
			return 0;
		}
	}

	@Override
	public Integer getWindowSenderSize() {
		if (arq != null) {
			return arq.getWindowSizeSender();
		} else {
			return 0;
		}
	}

	@Override
	public Integer getWindowReceiverBase() {
		if (arq != null) {
			return arq.getBaseReceiver();
		} else {
			return 0;
		}
	}

	@Override
	public Integer getWindowReceiverSize() {
		if (arq != null) {
			return arq.getWindowSizeReceiver();
		} else {
			return 0;
		}
	}

	@Override
	public Color getColorData() {
		if (surface == EnumSurface.COLORED) {
			return Color.CYAN;
		} else {
			return Color.WHITE;
		}
	}

	@Override
	public Color getColorAck() {
		if (surface == EnumSurface.COLORED) {
			return Color.YELLOW;
		} else {
			return Color.WHITE;
		}
	}

	@Override
	public Color getColorNak() {
		if (surface == EnumSurface.COLORED) {
			return Color.ORANGE;
		} else {
			return Color.LIGHT_GRAY;
		}
	}

	@Override
	public Color getColorBroken() {
		if (surface == EnumSurface.COLORED) {
			return Color.LIGHT_GRAY;
		} else {
			return Color.LIGHT_GRAY;
		}
	}

	@Override
	public Color getColorSenderOk() {
		if (surface == EnumSurface.COLORED) {
			return Color.BLUE;
		} else {
			return Color.BLACK;
		}
	}

	@Override
	public Color getColorReceiverOk() {
		if (surface == EnumSurface.COLORED) {
			return Color.RED;
		} else {
			return Color.BLACK;
		}
	}

	@Override
	public Integer getSpeedPacket() {
		return this.speedPacket;
	}

	@Override
	public String getMessage() {
		if (arq != null) {
			return arq.getMessage();
		} else {
			return "";//"Strategie auswählen";
		}
	}
}
