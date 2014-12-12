package Base;

import Betriebssysteme.Belegungsstrategien.ManagementFragmentation;
import Betriebssysteme.Belegungsstrategien.ManagementFragmentationImpl;
import Betriebssysteme.Buddy_Systeme.ManagementBuddyMemoryAllocation;
import Betriebssysteme.Buddy_Systeme.ManagementBuddyMemoryAllocationImpl;
import Betriebssysteme.Seitenersetzungsstrategien.ManagementPaging;
import Betriebssysteme.Seitenersetzungsstrategien.ManagementPagingImpl;
import Rechnernetze.Congestion_Avoidance.ManagementCongestionAvoidance;
import Rechnernetze.Congestion_Avoidance.ManagementCongestionAvoidanceImpl;
import Rechnernetze.Dijkstra_Algorithmus.ManagementDijkstraAlgorithm;
import Rechnernetze.Dijkstra_Algorithmus.ManagementDijkstraAlgorithmImpl;
import Rechnernetze.Pipeline_Protocol.ManagementAutomaticRepeatRequest;
import Rechnernetze.Pipeline_Protocol.ManagementAutomaticRepeatRequestImpl;
import Rechnernetze.Queueing_And_Loss.ManagementQueueingAndLoss;
import Rechnernetze.Queueing_And_Loss.ManagementQueueingAndLossImpl;
import Rechnernetze.TCP_Fairness.ManagementTCPFairness;
import Rechnernetze.TCP_Fairness.ManagementTCPFairnessImpl;
import Rechnernetze.TCP_Retransmission.ManagementTCPRetransmission;
import Rechnernetze.TCP_Retransmission.ManagementTCPRetransmissionImpl;
import Visualisierungen.ManagementDefault;
import Visualisierungen.ManagementDefaultImpl;

public class ManagementFactory {

	private static ManagementFragmentation fragmentation;
	private static ManagementBuddyMemoryAllocation buddy;
	private static ManagementPaging paging;
	private static ManagementCongestionAvoidance congestion;
	private static ManagementDijkstraAlgorithm dijkstra;
	private static ManagementAutomaticRepeatRequest pipeline;
	private static ManagementQueueingAndLoss qal;
	private static ManagementTCPFairness fairness;
	private static ManagementTCPRetransmission retransmission;
	private static ManagementDefault management;
	
	
	// Betriebssysteme
	
	public static ManagementFragmentation getManagementFragmentation() {
		if (fragmentation == null) {
			fragmentation = new ManagementFragmentationImpl();
		}
		return fragmentation;
	}
	
	public static ManagementBuddyMemoryAllocation getManagementBuddyMemoryAllocation() {
		if (buddy == null) {
			buddy = new ManagementBuddyMemoryAllocationImpl();
		}
		return buddy;
	}
	
	public static ManagementPaging getManagementPaging() {
		if (paging == null) {
			paging = new ManagementPagingImpl();
		}
		return paging;
	}
	
	
	// Rechnernetze	
	
	public static ManagementCongestionAvoidance getManagementCongestionAvoidance() {
		if (congestion == null) {
			congestion = new ManagementCongestionAvoidanceImpl();
		}
		return congestion;
	}
	
	public static ManagementDijkstraAlgorithm getManagementDijkstraAlgorithm() {
		if (dijkstra == null) {
			dijkstra = new ManagementDijkstraAlgorithmImpl();
		}
		return dijkstra;
	}
	
	public static ManagementAutomaticRepeatRequest getManagementAutomaticRepeatRequest() {
		if (pipeline == null) {
			pipeline = new ManagementAutomaticRepeatRequestImpl();
		}
		return pipeline;
	}
	
	public static ManagementQueueingAndLoss getManagementQueueingAndLoss() {
		if (qal == null) {
			qal = new ManagementQueueingAndLossImpl();
		}
		return qal;
	}
	
	public static ManagementTCPFairness getManagementTCPFairness() {
		if (fairness == null) {
			fairness = new ManagementTCPFairnessImpl();
		}
		return fairness;
	}
	
	public static ManagementTCPRetransmission getManagementTCPRetransmission() {
		if (retransmission == null) {
			retransmission = new ManagementTCPRetransmissionImpl();
		}
		return retransmission;
	}
	
	public static ManagementDefault getManagementDefault() {
		if (management == null) {
			management = new ManagementDefaultImpl();
		}
		return management;
	}
}
