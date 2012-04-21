
public class DiagnosticsUpdater extends Thread {
	
	private DiagnosticsWindow diags;
	
	public DiagnosticsUpdater(DiagnosticsWindow window){
		this.diags = window;
	}
	
	public void run(){
		while (true){
			diags.updateData();
			
			try {
				Thread.sleep(500);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}

}
