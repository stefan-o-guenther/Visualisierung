package Rechnernetze.Pipeline_Protocol.Go_Back_N;

public class Packet
{
boolean on_way, reached_dest, acknowledged, packet_ack, selected;
int packet_pos;

Packet()
{
on_way = false;
selected = false;
reached_dest = false;
acknowledged = false;
packet_ack = true;
packet_pos = 0;
}

Packet(boolean onway, int packetpos)
{
on_way = onway;
selected = false;
reached_dest = false;
acknowledged = false;
packet_ack = true;
packet_pos = packetpos;
}
}
