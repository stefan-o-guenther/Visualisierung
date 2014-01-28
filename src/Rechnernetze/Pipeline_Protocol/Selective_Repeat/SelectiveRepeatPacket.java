package Rechnernetze.Pipeline_Protocol.Selective_Repeat;

public class SelectiveRepeatPacket 
{
    boolean on_way; // is Packet in transit
    boolean reached_dest; // true if Packet reached the destination
    boolean acknowledged; // used by drawing function -false will use Packet
    // color -true will use ack color
    boolean Packet_ack; // is this Packet an ack? if false Packet is assumed to
    // be a message
    boolean selected; // true if Packet was selected by user false otherwise
    boolean received; // true if Packet was received
    boolean out_of_order; // Packet arrived out of order and an ack from the
    // base needs to be sent
    int Packet_pos; // location of Packet in diagram
    int ackFor; // carries the number of the Packet the ack is for
    boolean buffered;
    // individual packet timer used to signal packet loss and a retransmission
    // is needed. For SelectiveRepeat, each packet has its own timer
    SelectiveRepeat.PacketTimerTask packet_timer_task;
    
    SelectiveRepeatPacket() 
    {
		on_way = false;
		selected = false;
		reached_dest = false;
		acknowledged = false;
		Packet_ack = true;
		received = false;
		out_of_order = false;
		Packet_pos = 0;
		ackFor = 0;
		buffered = false;
    }
    
    SelectiveRepeatPacket(boolean onway, int Packetpos, int nextseq) 
    {
		on_way = onway;
		selected = false;
		reached_dest = false;
		acknowledged = false;
		Packet_ack = true;
		received = false;
		out_of_order = false;
		Packet_pos = Packetpos;
		ackFor = nextseq;
		buffered = false;
    }
}