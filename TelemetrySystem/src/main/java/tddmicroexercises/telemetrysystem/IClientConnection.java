package tddmicroexercises.telemetrysystem;

public interface IClientConnection {
	boolean connect(String telementryServerConnectionString);
	void disconnect();
	
	boolean getOnlineStatus();
}
