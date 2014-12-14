package Rechnernetze.Pipeline_Protocol;

public class ReceiverImpl implements Receiver {

	public ReceiverImpl() {
		super();
		type = EnumARQReceiver.EMPTY;
	}
	
	private EnumARQReceiver type;
	
	@Override
	public EnumARQReceiver getType() {
		return this.type;
	}

	@Override
	public Boolean hasReceived() {
		return (type == EnumARQReceiver.RECEIVED);
	}

	@Override
	public void setReceived() {
		type = EnumARQReceiver.RECEIVED;
	}
}
