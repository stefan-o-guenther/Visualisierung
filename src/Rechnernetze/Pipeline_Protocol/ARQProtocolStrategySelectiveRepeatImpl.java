package Rechnernetze.Pipeline_Protocol;

import Base.Checker;


public class ARQProtocolStrategySelectiveRepeatImpl extends	ARQProtocolStrategyAbstract implements ARQProtocolStrategySelectiveRepeat {

	public ARQProtocolStrategySelectiveRepeatImpl(Integer max) {
		super(max);
		this.initialize();
	}

	private void initialize() {
			
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
			sender.setSent();
			this.resetTimer(this.getNextSeqnum());
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
				int timeDif = this.getTimeout() - sender.getTimer();
				if (timeDif <= 0) {
					this.sendSentAgain(i);
				}
			}
		}
	}
	
	private void sendSentAgain(Integer number) {
		Checker.checkIfIntegerNotLessZero(number);
		this.send(number);
		this.resetTimer(number);
	}

	@Override
	protected void resetTimer(Integer number) {
		Checker.checkIfIntegerNotLessZero(number);
		if (number.intValue() > this.getMaxSender().intValue()) {
			throw new IllegalArgumentException();
		}
		Sender sender = this.getSender(number);
		sender.resetTimer();
	}

	@Override
	protected void receiveAck(Integer number) {
		Checker.checkIfIntegerNotLessZero(number);
		if (number.intValue() > this.getMaxSender().intValue()) {
			throw new IllegalArgumentException();
		}
		Sender sender = this.getSender(number);
		sender.setReceived();
	}
	
	@Override
	protected void receiveNak(Integer number) {
		Checker.checkIfIntegerNotLessZero(number);
		if (number.intValue() > this.getMaxSender().intValue()) {
			throw new IllegalArgumentException();
		}
		this.sendSentAgain(number);
	}

	@Override
	protected void executeTimer() {
		int base = this.getBaseSender();
		int max = this.getMaxSender();
		for (int i = base; i <= max; i++) {
			Sender sender = this.getSender(i);
			sender.incTimer();
		}
	}
}
