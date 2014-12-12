package Rechnernetze.Pipeline_Protocol;


public class ARQProtocolStrategyStopAndWaitImpl extends ARQProtocolStrategyExtraAbstract implements ARQProtocolStrategyStopAndWait {

	public ARQProtocolStrategyStopAndWaitImpl(Integer max) {
		super(max);
		this.initialize();
	}	
	
	@Override
	public EnumARQStrategy getStrategy() {
		return EnumARQStrategy.STOP_AND_WAIT;
	}

	private void initialize() {
		
	}

	@Override
	public Integer getWindowSizeSender() {
		return 1;
	}
}
