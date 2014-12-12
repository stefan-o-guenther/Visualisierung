package Rechnernetze.Pipeline_Protocol;

public class ReceiverImpl implements Receiver {

	public ReceiverImpl() {
		
	}
	
	private EnumARQReceiver type;
	
	@Override
	public EnumARQReceiver getType() {
		return this.type;
	}

	@Override
	public void setType(EnumARQReceiver type) {
		try {
			if (type == null) {
				throw new NullPointerException();
			}
			this.type = type;
		} catch (Exception ex) {
			throw ex;
		}
	}
}
