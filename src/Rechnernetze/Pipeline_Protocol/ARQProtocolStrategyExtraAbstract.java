package Rechnernetze.Pipeline_Protocol;

import Base.Checker;


public abstract class ARQProtocolStrategyExtraAbstract extends	ARQProtocolStrategyAbstract {

	public ARQProtocolStrategyExtraAbstract(Integer max) {
		super(max);
		this.initialize();
	}
	
	private void initialize() {
		this.setTimeTimeout(0);	
	}
	
	private Long timeTimeout;		
	
	@Override
	protected void setTimeTimeout(Integer number) {
		Checker.checkIfIntegerNotLessZero(number);
		if (number.intValue() > this.getMaxSender().intValue()) {
			throw new IllegalArgumentException();
		}
		this.timeTimeout = System.currentTimeMillis();
	}
	
	@Override
	protected void acknowledgePacket(Integer number) {
		Checker.checkIfIntegerNotLessZero(number);
		if (number.intValue() > this.getMaxSender().intValue()) {
			throw new IllegalArgumentException();
		}
		for (int j = this.getBaseSender(); j <= number; j++) {
			Sender sender = this.getSender(j);
			sender.setType(EnumARQSender.ACK);
		}
	}
	
	@Override
	protected void executeTimeout() {
		long timeDif = System.currentTimeMillis() - timeTimeout;
		if (timeDif >= this.getTimeout().intValue()) {
			for (int i = this.getBaseSender(); i <= this.getMaxSender(); i++) {
				Sender sender = this.getSender(i);
				if (sender.getType() == EnumARQSender.SENT) {
					this.send(i);
					this.setTimeTimeout(i);
				}
			}
		}
	}
	
	@Override
	protected void executeReceived() {
		this.setTimeTimeout(0);
	}
	
	@Override
	public void sendPacket() {
		if (this.canSendPacket()) {
			Sender sender;
			this.send(this.getNextSeqnum());
			int window = this.getWindowSizeSender();
			int base = this.getBaseSender();
			int size = base + window;
			int countSent = 0;
			for (int i = base; i < size; i++) {
				sender = this.getSender(i);
				if (sender.getType() == EnumARQSender.SENT) {
					countSent += 1;
				}
			}
			if (countSent == 0) {
				this.setTimeTimeout(this.getNextSeqnum());
			}			
			sender = this.getSender(this.getNextSeqnum());
			sender.setType(EnumARQSender.SENT);
			this.incNextSeqnum();
		}
	}
	
	@Override
	public Integer getWindowSizeReceiver() {
		return 1;
	}
}
