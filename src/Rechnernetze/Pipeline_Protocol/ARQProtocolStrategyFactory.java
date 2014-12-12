package Rechnernetze.Pipeline_Protocol;

import Base.Checker;

public class ARQProtocolStrategyFactory {

	public static ARQProtocolStrategy getStrategy(EnumARQStrategy enumStrategy, Integer max) {
		try {
			Checker.checkIfNotNull(enumStrategy);
			Checker.checkIfNotNull(max);
			ARQProtocolStrategy strategy = null;
			switch (enumStrategy) {
				case STOP_AND_WAIT: {
					strategy = new ARQProtocolStrategyStopAndWaitImpl(max);
					break;
				}
				case GO_BACK_N: {
					strategy = new ARQProtocolStrategyGoBackNImpl(max);
					break;
				}
				case SELECTIVE_REPEAT: {
					strategy = new ARQProtocolStrategySelectiveRepeatImpl(max);
					break;
				}
				default: {
					strategy = null;
					break;
				}
			}
			return strategy;
		} catch (Exception ex) {
			throw ex;
		}		
	}
}