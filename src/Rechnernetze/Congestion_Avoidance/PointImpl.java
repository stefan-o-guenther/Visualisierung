/**
 * @author:	Stefan Otto Günther
 * @date:	12.05.2014
 */

package Rechnernetze.Congestion_Avoidance;

public class PointImpl implements Point {

	private Integer cwndTcpReno;
	private Integer cwndTcpTahoe;
	private Integer ssTreshTcpReno;
	private Integer ssTreshTcpTahoe;
	
	
	public PointImpl() {
		this(0,0,0,0);
	}
	
	public PointImpl(Integer cwndR, Integer cwndT, Integer ssTreshR, Integer ssTreshT) {
		this.setCwndTcpReno(cwndR);
		this.setCwndTcpTahoe(cwndT);
		this.setSsTreshTcpReno(ssTreshR);
		this.setSsTreshTcpTahoe(ssTreshT);
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

	@Override
	public Integer getSsTreshTcpReno() {
		return this.ssTreshTcpReno;
	}

	@Override
	public void setSsTreshTcpReno(Integer ssTresh) {
		if (ssTresh != null) {
			this.ssTreshTcpReno = ssTresh;
		}		
	}

	@Override
	public Integer getSsTreshTcpTahoe() {
		return this.ssTreshTcpTahoe;
	}

	@Override
	public void setSsTreshTcpTahoe(Integer ssTresh) {
		if (ssTresh != null) {
			this.ssTreshTcpTahoe = ssTresh;
		}
	}
}