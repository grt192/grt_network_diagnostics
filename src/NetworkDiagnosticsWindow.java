import java.awt.TextArea;
import java.util.ArrayList;

import javax.swing.JFrame;

public class NetworkDiagnosticsWindow extends JFrame{
	
	private String robotHost, pcHost;
	
	//Graphical stuff
	private TextArea data;
	private ArrayList<String> keys;
	private ArrayList<String> hosts;
	private ArrayList<String> values;
	
	public NetworkDiagnosticsWindow(String robotHost, String pcHost){
		super("GRT 2012 Diagnostics");
		setSize(400,400);
		
		setVisible(true);
		
		this.robotHost = robotHost;
		this.pcHost = pcHost;
		
		initTools();
	}
	
	public void editKey(String key, String newVal){
		int pos = keys.indexOf(key);
		if (pos >= 0){
			values.set(pos, newVal);
		}
	}
	
	public void addLoggedHost(String host, String key, String value){
		hosts.add(host);
		keys.add(key);
		values.add(value);
	}
	
	public void initTools(){
		data = new TextArea("");
		
		hosts = new ArrayList<String>();
		keys = new ArrayList<String>();
		values = new ArrayList<String>();
		
		data.setSize(200,200);
		
		data.setEditable(false);
		
		data.setVisible(true);
		
		add(data);
	}
	
	public void updateData(){
		
		System.out.println("Updating logged data...");
		
		

		
		String print = "";	//Text to be printed in text area
		
		//Update all key values
		for (int i=0; i < keys.size(); i++){
			
			//Update our ping info:
			editKey(keys.get(i), NetUtil.ping(hosts.get(i), 500) ? "CONNECTED" : "DOWN");
			
			//DEBUG
			System.out.println(keys.get(i) + " = " + values.get(i));
			
			
			//Now we do our formatted printing:
			print += keys.get(i) + "\t:\t" + values.get(i) + "\n";
		}
		
		this.data.setText(print);
	}
	
}
