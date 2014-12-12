package Rechnernetze.Pipeline_Protocol;

public class SenderImpl implements Sender {

	public SenderImpl() {
		type = EnumARQSender.EMPTY;
		timestamp = System.currentTimeMillis();
	}
	
	private EnumARQSender type;	
	private long timestamp;
	
	@Override
	public EnumARQSender getType() {
		return this.type;
	}

	@Override
	public void setType(EnumARQSender type) {
		try {
			if (type == null) {
				throw new NullPointerException();
			}
			this.type = type;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	@Override
	public long getTimestamp() {
		return this.timestamp;
	}

	@Override
	public void setTimestamp(long timestamp) {
		try {
			if (timestamp < 0) {
				throw new IllegalArgumentException();
			}
			this.timestamp = timestamp;
		} catch (Exception ex) {
			throw ex;
		}
	}
}
