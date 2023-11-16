package tddmicroexercises.telemetrysystem.implementation;

import tddmicroexercises.telemetrysystem.IClientConnection;

import java.util.Random;

public class ClientConnection implements IClientConnection {
	
	private boolean onlineStatus;
	
	private final Random connectionEventsSimulator = new Random(42);
	
	@Override
	public boolean connect(String telementryServerConnectionString) {
		
		if (telementryServerConnectionString == null || "".equals(telementryServerConnectionString))
		{
			throw new IllegalArgumentException();
		}
		
		// simulate the operation on a real modem
		boolean success = connectionEventsSimulator.nextInt(10) <= 8;
		
		onlineStatus = success;
		return onlineStatus;
	}
	
	@Override
	public void disconnect() {
		onlineStatus = false;
	}
	
	@Override
	public boolean getOnlineStatus() {
		return onlineStatus;
	}
}
