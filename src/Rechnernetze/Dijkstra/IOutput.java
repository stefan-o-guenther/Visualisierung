package Rechnernetze.Dijkstra;


public interface IOutput extends IColorGetter {
	EnumOutputStatus getStatus();
	void setStatus(EnumOutputStatus value);
}
