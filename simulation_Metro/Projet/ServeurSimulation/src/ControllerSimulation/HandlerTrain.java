package ControllerSimulation;

import java.io.IOException;
import java.net.Socket;

import Protocol.Protocol;
import Protocol.SimulationInput;
import Protocol.SimulationOutPut;

public class HandlerTrain extends Thread implements Protocol{
	
	private Socket sock;
	private SimulationInput in;
	private SimulationOutPut out;
	private Ordinateur ord;
	
	public HandlerTrain(Socket s, Ordinateur ord) throws IOException {
		this.ord = ord;
		this.sock = s;
		this.out = new SimulationOutPut(s.getOutputStream());
	}
	

	
	@Override
	public void run() {
		super.run();
		try(Socket s1 = sock){
			in = new SimulationInput(s1.getInputStream(), this);
			in.doRun();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void sendName(String name) {
		Protocol.super.sendName(name);
		ord.initalisation();
	}
	
	
}
