/**
 * @author:	Stefan Otto Günther
 * @date:	12.05.2014
 */

package Rechnernetze.Congestion_Avoidance;

public interface Point {

	public Integer getCwndTcpReno();
	public void setCwndTcpReno(Integer cwnd);
	
	public Integer getCwndTcpTahoe();
	public void setCwndTcpTahoe(Integer cwnd);
	
	public Integer getSsTreshTcpReno();
	public void setSsTreshTcpReno(Integer ssTresh);
	
	public Integer getSsTreshTcpTahoe();
	public void setSsTreshTcpTahoe(Integer ssTresh);
}
