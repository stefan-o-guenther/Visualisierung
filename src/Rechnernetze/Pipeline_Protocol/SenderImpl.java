package Rechnernetze.Pipeline_Protocol;


public class SenderImpl implements Sender {

	public SenderImpl() {
		super();
		type = EnumARQSender.EMPTY;
		timer = 0;
	}
	
	private EnumARQSender type;
	private Integer timer;
	
	@Override
	public EnumARQSender getType() {
		return this.type;
	}

	@Override
	public Boolean hasReceived() {
		return (type == EnumARQSender.ACK);
	}

	@Override
	public void resetTimer() {
		timer = 0;
	}

	@Override
	public void incTimer() {
		if (type == EnumARQSender.SENT) {
			timer += 1;
		}		
	}

	@Override
	public Integer getTimer() {
		return timer;
	}

	@Override
	public void setReceived() {
		type = EnumARQSender.ACK;
	}

	@Override
	public void setSent() {
		type = EnumARQSender.SENT;
	}
}
