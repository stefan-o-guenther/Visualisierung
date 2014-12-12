/**
* @author: Stefan Otto Günther
* @date: 27.01.2014
*/

package Rechnernetze.Queueing_And_Loss;

import java.util.List;

import Base.ManagementPacket;

public interface ManagementQueueingAndLoss extends ManagementPacket {

	public List<PacketQal> getListInput();
	public List<PacketQal> getListOutput();
	public List<PacketQal> getListError();
	public List<PacketQal> getListRouter();
	public Integer getMaxRouter();
	public Integer getCountLoss();
	public Integer getCountTransfered();
	
	public Integer getProcessingTime();
	public void setProcessingTime(Integer time);
	
	public Integer getIntervalPacket();
	public void setIntervalPacket(Integer interval);
}
