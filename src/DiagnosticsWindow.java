import java.awt.TextArea;
import java.util.ArrayList;

import javax.swing.JFrame;

public class DiagnosticsWindow extends JFrame{
	
	private String robotHost, pcHost;
	
	//Graphical stuff
	private TextArea data;
	private ArrayList<String> keys;
	private ArrayList<String> values;
	
	public DiagnosticsWindow(String robotHost, String pcHost){
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
	
	public void addLoggedItem(String key, String value){
		keys.add(key);
		values.add(value);
	}
	
	public void initTools(){
		data = new TextArea("");
		
		keys = new ArrayList<String>();
		values = new ArrayList<String>();
		
		data.setSize(200,200);
		
		data.setVisible(true);
		
		add(data);
	}
	
	public void updateData(){
		
		System.out.println("Updating logged data...");
		
		
		editKey("PC COMM", NetUtil.ping(pcHost, 2000) ? "CONNECTED" : "DOWN");
		editKey("ROBOT COMM", NetUtil.ping(robotHost, 2000) ? "CONNECTED" : "DOWN");
		
		String print = "";	//Text to be printed in text area
		
		//Update all key values
		for (int i=0; i < keys.size(); i++){
			
			//DEBUG
			System.out.println(keys.get(i) + " = " + values.get(i));
			
			print += keys.get(i) + "\t:\t" + values.get(i) + "\n";
		}
		
		this.data.setText(print);
	}
	
}
