package Rechnernetze.Pipeline_Protocol;

import Base.Checker;


public class ARQProtocolStrategySelectiveRepeatImpl extends	ARQProtocolStrategyAbstract implements ARQProtocolStrategySelectiveRepeat {

	public ARQProtocolStrategySelectiveRepeatImpl(Integer max) {
		super(max);
	}

	@Override
	public EnumARQStrategy getStrategy() {
		return EnumARQStrategy.SELECTIVE_REPEAT;
	}

	@Override
	public void sendPacket() {
		if (this.canSendPacket()) {
			Sender sender;
			this.send(this.getNextSeqnum());
			sender = this.getSender(this.getNextSeqnum());
			sender.setType(EnumARQSender.SENT);
			this.setTimeTimeout(this.getNextSeqnum());
			this.incNextSeqnum();
		}
	}

	@Override
	public Integer getWindowSizeSender() {
		return 5;
	}

	@Override
	public Integer getWindowSizeReceiver() {
		return 5;
	}

	@Override
	protected void executeTimeout() {
		for (int i = this.getBaseSender().intValue(); i <= this.getMaxSender().intValue(); i++) {
			Sender sender = this.getSender(i);
			if (sender.getType() == EnumARQSender.SENT) {
				long timeDif = System.currentTimeMillis() - sender.getTimestamp();
				if (timeDif >= this.getTimeout().intValue()) {
					this.send(i);
					this.setTimeTimeout(i);
				}
			}
		}
	}

	@Override
	protected void executeReceived() {
		
	}

	@Override
	protected void setTimeTimeout(Integer number) {
		Checker.checkIfIntegerNotLessZero(number);
		if (number.intValue() > this.getMaxSender().intValue()) {
			throw new IllegalArgumentException();
		}
		Sender sender = this.getSender(number);
		sender.setTimestamp(System.currentTimeMillis());
	}

	@Override
	protected void acknowledgePacket(Integer number) {
		Checker.checkIfIntegerNotLessZero(number);
		if (number.intValue() > this.getMaxSender().intValue()) {
			throw new IllegalArgumentException();
		}
		Sender sender = this.getSender(number);
		sender.setType(EnumARQSender.ACK);
	}
}
