/**
 * @author:	Stefan Otto Günther
 * @date:	22.10.2014
 */

package Rechnernetze.Pipeline_Protocol;

import Base.Checker;
import Base.PacketAbstract;

public abstract class PacketArqAbstract extends PacketAbstract implements PacketArq {

	public PacketArqAbstract(Integer number, Integer position) {
		super(position);
		try {
			Checker.checkIfIntegerNotLessZero(number);
			this.number = number;
		} catch (Exception ex) {
			throw ex;
		}
		initialize();
	}
	
	protected Integer number;
	protected EnumPacketStatus status;
	
	
	private void initialize() {
		this.status = EnumPacketStatus.OK;
	}
	
	@Override
	public Integer getNumber() {
		return number;
	}

	@Override
	public EnumPacketStatus getPacketStatus() {
		return status;
	}

	@Override
	public void setPacketStatus(EnumPacketStatus status) {
		try {
			Checker.checkIfNotNull(status);
			this.status = status;
		} catch (Exception ex) {
			throw ex;
		}
	}
}
