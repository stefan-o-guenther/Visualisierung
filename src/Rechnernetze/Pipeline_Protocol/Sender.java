package Rechnernetze.Pipeline_Protocol;

public interface Sender extends Actor {

	public EnumARQSender getType();
	public void resetTimer();
	public void incTimer();
	public Integer getTimer();
	public void setSent();
	public Boolean isSent();
}
