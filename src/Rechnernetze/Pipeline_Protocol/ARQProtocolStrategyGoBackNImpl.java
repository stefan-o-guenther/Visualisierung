package Rechnernetze.Pipeline_Protocol;

import Base.Checker;


public class ARQProtocolStrategyGoBackNImpl extends	ARQProtocolStrategyAbstract implements ARQProtocolStrategyGoBackN {

	public ARQProtocolStrategyGoBackNImpl(Integer max) {
		super(max);
		this.initialize();
	}
	
	private void initialize() {
		this.resetTimer(0);
	}
	
	@Override
	public EnumARQStrategy getStrategy() {
		return EnumARQStrategy.GO_BACK_N;
	}

	private Integer timer;
	
	private void resetTimer() {
		timer = 0;
	}
	
	private void incTimer() {
		timer += 1;
	}
	
	private Integer getTimer() {
		return timer;
	}
	
	@Override
	protected void resetTimer(Integer number) {
		Checker.checkIfIntegerNotLessZero(number);
		int n = number.intValue();
		int max = this.getMaxSender();
		if (n > max) {
			throw new IllegalArgumentException();
		}
		timer = 0;
	}

	private void acknowledge(Integer number) {
		Checker.checkIfIntegerNotLessZero(number);
		int n = number.intValue();
		int max = this.getMaxSender().intValue();
		int base = this.getBaseSender();
		if (n > max) {
			throw new IllegalArgumentException();
		}		
		for (int j = base; j <= n; j++) {
			Sender sender = this.getSender(j);
			sender.setReceived();
		}		
	}
	
	@Override
	protected void receiveAck(Integer number) {
		Checker.checkIfIntegerNotLessZero(number);
		this.acknowledge(number);
	}
	
	@Override
	protected void receiveNak(Integer number) {
		Checker.checkIfIntegerNotLessZero(number);
		if (number.intValue() > 0) {
			this.acknowledge(number - 1);
		}		
		this.sendAllSentAgain();
	}
	
	@Override
	protected void executeTimeout() {		
		int timeDif = this.getTimeout() - this.getTimer();
		if ((timeDif <= 0) && (this.isAnySent())) {
			this.sendAllSentAgain();
		}
	}

	@Override
	protected void executeTimer() {
		if (this.isAnySent()) {
			this.incTimer();
		} else {
			this.resetTimer();
		}
	}	
	
	private void sendAllSentAgain() {
		int base = this.getBaseSender().intValue();
		int max = this.getMaxSender();
		for (int i = base; i <= max; i++) {
			Sender sender = this.getSender(i);
			if (sender.getType() == EnumARQSender.SENT) {
				this.send(i);
				this.resetTimer(i);
			}
		}
	}	
	
	@Override
	public void sendPacket() {
		if (this.canSendPacket()) {
			Sender sender;
			this.send(this.getNextSeqnum());
			sender = this.getSender(this.getNextSeqnum());
			sender.setSent();
			this.incNextSeqnum();
		}
	}
	
	@Override
	public Integer getWindowSizeReceiver() {
		return 1;
	}
	
	@Override
	public Integer getWindowSizeSender() {
		return 5;
	}
}
