
public class NetworkDiagnosticsUpdater extends Thread {
	
	private NetworkDiagnosticsWindow diags;
	private int sleepTime = 500;	//Time in between updates. Defaults to 500 milliseconds
	
	public NetworkDiagnosticsUpdater(NetworkDiagnosticsWindow window, int sleepTime){
		this.diags = window;
		this.sleepTime = sleepTime;
	}
	
	public void run(){
		while (true){
			diags.updateData();
			
			try {
				Thread.sleep(sleepTime);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}

}
