package Rechnernetze.Pipeline_Protocol;


public class ARQProtocolStrategyGoBackNImpl extends ARQProtocolStrategyExtraAbstract	implements ARQProtocolStrategyGoBackN {

	public ARQProtocolStrategyGoBackNImpl(Integer max) {
		super(max);
		this.initialize();
	}
	
	@Override
	public EnumARQStrategy getStrategy() {
		return EnumARQStrategy.GO_BACK_N;
	}

	private void initialize() {
		
	}

	@Override
	public Integer getWindowSizeSender() {
		return 5;
	}
}
