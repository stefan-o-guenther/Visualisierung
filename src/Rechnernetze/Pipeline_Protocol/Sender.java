package Rechnernetze.Pipeline_Protocol;

public interface Sender {

	public EnumARQSender getType();
	public void setType(EnumARQSender type);
	public long getTimestamp();
	public void setTimestamp(long timestamp);
}
