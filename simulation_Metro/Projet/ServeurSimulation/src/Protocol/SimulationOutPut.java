package Protocol;

import java.io.OutputStream;
import java.io.PrintWriter;

public class SimulationOutPut implements Protocol{
	
	PrintWriter os;
	
	public SimulationOutPut(OutputStream out){
		this.os = new PrintWriter(out, true);
	}
	
	
	@Override
	public void sendName(String name) {
		Protocol.super.sendName(name);
		os.println("NAME");
		os.println(name);
	}
	
	
	
	@Override
	public void sendNameOK() {
		Protocol.super.sendNameOK();
		os.println("NAME OK");
	}
}
