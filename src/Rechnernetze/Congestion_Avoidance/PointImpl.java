package Rechnernetze.Congestion_Avoidance;

public class PointImpl implements Point {

	private Integer tr;
	private Integer cwndTcpReno;
	private Integer cwndTcpTahoe;
	
	public PointImpl() {
		this(0,0,0);
	}
	
	public PointImpl(Integer tr, Integer cwndR, Integer cwndT) {
		this.setTransmissionRound(tr);
		this.setCwndTcpReno(cwndR);
		this.setCwndTcpTahoe(cwndT);
	}	
	
	@Override
	public Integer getTransmissionRound() {
		return this.tr;
	}

	@Override
	public void setTransmissionRound(Integer tr) {
		if (tr != null) {
			this.tr = tr;
		}
	}

	@Override
	public Integer getCwndTcpReno() {
		return this.cwndTcpReno;
	}

	@Override
	public void setCwndTcpReno(Integer cwnd) {
		if (cwnd != null) {
			this.cwndTcpReno  = cwnd;
		}
	}

	@Override
	public Integer getCwndTcpTahoe() {
		return this.cwndTcpTahoe;
	}

	@Override
	public void setCwndTcpTahoe(Integer cwnd) {
		if (cwnd != null) {
			this.cwndTcpTahoe = cwnd;
		}
	}
}