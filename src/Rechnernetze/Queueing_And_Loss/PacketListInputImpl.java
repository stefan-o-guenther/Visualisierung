package Rechnernetze.Queueing_And_Loss;

public class PacketListInputImpl extends PacketListAbstract implements PacketListInput {

	public PacketListInputImpl(long term, long timestamp, int max) {
		super(term, timestamp, max);
	}
	
	private Router router;
	
	@Override
	protected void putPacket(Packet packet) {
		if (router != null) {
			
		}
	}	

	@Override
	public Router getRouter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRouter(Router router) {
		try {
			if (router == null) {
				throw new NullPointerException();
			}
			this.router = router;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Integer getMinDistance() {
		// TODO Auto-generated method stub
		return null;
	}
}
