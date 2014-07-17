/**
* @author: Stefan Otto Günther
* @date: 27.01.2014
*/

package Rechnernetze.Queueing_And_Loss;

import java.util.List;

import Base.ManagementAutomatic;

public interface ManagementQueueingAndLoss extends ManagementAutomatic {

	List<Packet> getListInput();
	List<Packet> getListOutput();
	List<Packet> getListError();
	List<Packet> getListRouter();
	Integer getMaxRouter();
}
