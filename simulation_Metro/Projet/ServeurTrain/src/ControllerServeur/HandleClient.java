package ControllerServeur;

import java.io.IOException;
import java.net.Socket;

import ModelServeur.Model;
import Protocol.Protocol;
import Protocol.SimulationInput;
import Protocol.SimulationOutPut;

public class HandleClient implements Runnable, Protocol{

	private final Socket s;
	private SimulationInput in;
	private SimulationOutPut out;
	private Model model;
	private enum ClientState {
		St_INT, ST_Normal;
	}
	private boolean stop;
	public  HandleClient(Socket s) {
		this.s = s;
		this.model = new Model();
	}
	
	
	@Override
	public void sendName(String name) {
		Protocol.super.sendName(name);
		if(model.exitZone(name)) {
			out.sendNameOK();
		}else {
			out.sendRefus();
		}
	}
	
	
	@Override
	public void run() {
		try(Socket s1 = s){
			this.out = new SimulationOutPut(s1.getOutputStream());
			this.in = new SimulationInput(s1.getInputStream(), this);
			in.doRun();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
