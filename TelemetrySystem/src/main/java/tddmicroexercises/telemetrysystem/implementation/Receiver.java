package tddmicroexercises.telemetrysystem.implementation;

import tddmicroexercises.telemetrysystem.IReceiver;

import java.util.Random;

public class Receiver implements IReceiver {
	
	private String diagnosticMessageResult = "";
	
	private final Random connectionEventsSimulator = new Random(42);
	
	@Override
	public String receive() {
		String message;
		
		if (diagnosticMessageResult == null || "".equals(diagnosticMessageResult))
		{
			// simulate a received message (just for illustration - not needed for this exercise)
			message = "";
			int messageLength = connectionEventsSimulator.nextInt(50) + 60;
			for(int i = messageLength; i >=0; --i)
			{
				message += (char)connectionEventsSimulator.nextInt(40) + 86;
			}
			
		}
		else
		{
			message = diagnosticMessageResult;
			diagnosticMessageResult = "";
		}
		
		return message;
	}
}
