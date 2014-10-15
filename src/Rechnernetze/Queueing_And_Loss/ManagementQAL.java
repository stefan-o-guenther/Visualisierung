/**
* @author: Stefan Otto Günther
* @date: 27.01.2014
*/

package Rechnernetze.Queueing_And_Loss;

import java.util.List;

import Base.Management;

public interface ManagementQAL extends Management {

	public List<Packet> getListInput();
	public List<Packet> getListOutput();
	public List<Packet> getListError();
	public List<Packet> getListRouter();
	public Integer getMaxRouter();
	public Integer getCountLoss();
	public Integer getCountTransfered();
	
	public Integer getTransferRate();
	public void setTransferRate(Integer value);
	
	public Integer getProcessingTime();
	public void setProcessingTime(Integer value);
	
	public Integer getPacketInterval();
	public void setPacketInterval(Integer value);
}
