package tddmicroexercises.telemetrysystem.implementation;

import tddmicroexercises.telemetrysystem.Client;
import tddmicroexercises.telemetrysystem.IClientConnection;
import tddmicroexercises.telemetrysystem.IReceiver;
import tddmicroexercises.telemetrysystem.ISender;

public class TelemetryClient implements Client {
	private final String DiagnosticChannelConnectionString = "*111#";
	public static final String DIAGNOSTIC_MESSAGE = "AT#UD";
	private String diagnosticInfo = "";
	private IClientConnection iconnect;
	private ISender isend;
	private IReceiver ireceive;
	
	public TelemetryClient(IClientConnection iconnect, ISender isend, IReceiver ireceive) {
		this.iconnect = iconnect;
		this.isend = isend;
		this.ireceive = ireceive;
	}
	
	public String getDiagnosticInfo() {
		return diagnosticInfo;
	}
	
	public void setDiagnosticInfo(String diagnosticInfo) {
		this.diagnosticInfo = diagnosticInfo;
	}
	
	@Override
	public void checkTransmission() throws Exception {
		diagnosticInfo = "";
		
		iconnect.disconnect();
		
		int retryLeft = 3;
		while (!iconnect.getOnlineStatus() && retryLeft > 0) {
			iconnect.connect(DiagnosticChannelConnectionString);
			retryLeft -= 1;
		}
		
		if (!iconnect.getOnlineStatus()) {
			throw new Exception("Unable to connect.");
		}
		
		isend.send(DIAGNOSTIC_MESSAGE);
		diagnosticInfo = ireceive.receive();
	}
}
