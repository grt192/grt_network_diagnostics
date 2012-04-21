
public class Main {

	private static final int UPDATE_TIME = 300;
	
	private static final String ROBOT_IP = "10.1.92.119";
	private static final String COMPUTER_IP = "10.1.92.11";
	
	public static void main(String[] args){
		
		NetworkDiagnosticsWindow diagnostics = new NetworkDiagnosticsWindow(ROBOT_IP, COMPUTER_IP);
	
		diagnostics.addLoggedHost(COMPUTER_IP, "PC COMM", "DOWN");
		diagnostics.addLoggedHost(ROBOT_IP,"ROBOT COMM", "DOWN");
		
		
		System.out.println("Starting update thread...");
		NetworkDiagnosticsUpdater updater = new NetworkDiagnosticsUpdater(diagnostics, UPDATE_TIME);
		updater.start();
		
	}
	
}
