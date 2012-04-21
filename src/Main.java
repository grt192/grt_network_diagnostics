
public class Main {

	private static final String ROBOT_IP = "10.1.92.122";
	private static final String COMPUTER_IP = "10.1.92.11";
	
	public static void main(String[] args){
		
		DiagnosticsWindow diagnostics = new DiagnosticsWindow(ROBOT_IP, COMPUTER_IP);
	
		diagnostics.addLoggedItem("PC COMM", "DOWN");
		diagnostics.addLoggedItem("ROBOT COMM", "DOWN");
		
		
		System.out.println("Starting update thread...");
		DiagnosticsUpdater updater = new DiagnosticsUpdater(diagnostics);
		updater.start();
		
	}
	
}
