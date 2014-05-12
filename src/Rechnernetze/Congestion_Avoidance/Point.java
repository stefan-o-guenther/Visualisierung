package Rechnernetze.Congestion_Avoidance;

public interface Point {

	Integer getTransmissionRound();
	void setTransmissionRound(Integer tr);
	
	Integer getCwndTcpReno();
	void setCwndTcpReno(Integer cwnd);
	
	Integer getCwndTcpTahoe();
	void setCwndTcpTahoe(Integer cwnd);
}
