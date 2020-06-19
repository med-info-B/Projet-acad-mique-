package Protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SimulationInput {

	private Protocol handler;
	private boolean stop = false;
	private InputStream in ;
	public SimulationInput(InputStream in, Protocol handler) {
		this.in = in ;
		this.handler = handler;
	}
	
	
	
	public void doRun() throws IOException {
		String msg="", test="";
		try(BufferedReader is = new BufferedReader(new InputStreamReader(in))){
			while(!stop) {
				String line =  is.readLine();
				switch(line) {
				
				case "NAME" :    msg = is.readLine();
								 handler.sendName(msg);
				break;
				case "NAME OK" : handler.sendNameOK();
				                 
				
				
				
				
				
				
				
				}
			}
		}
	}
}
