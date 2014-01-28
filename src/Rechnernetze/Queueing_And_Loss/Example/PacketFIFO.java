package Rechnernetze.Queueing_And_Loss.Example;

public class PacketFIFO {

	private int length;
	private Packet[] content;

	public PacketFIFO() {
		length = 0;
	}

	public int getLength() {
		return length;
	}

	public void add(Packet P) {
		if (length==0) {
			content=new Packet[1];
			content[0]=P;
		} else {
			Packet[] temp=new Packet[length+1];
			for (int i = 0; i < length; i++) {
				temp[i] = content[i];
			}
			temp[length] = P;
			content = temp;
		}
		length++;
	}

	public void rem() {
		Packet[] temp=new Packet[length-1];
		for (int i=0;i<length-1;i++) {
			temp[i]=content[i+1];
		}
		content = temp;
		length -= 1;
	}

	public Packet getPacket(int index) {
		return content[index];
	}
	
	public Packet getFirstPacket() {
		return content[0];
	}
}


