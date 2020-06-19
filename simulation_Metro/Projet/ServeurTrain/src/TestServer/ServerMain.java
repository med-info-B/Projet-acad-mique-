package TestServer;

import java.io.IOException;

import ModelServeur.ServerCore;


public class ServerMain  {
	
	public static void main(String[] args) {
		int port = args.length == 1?
				Integer.parseInt(args[0]): 1234;
				try {
					ServerCore core = new ServerCore(port);
				}catch(IOException e){
					System.out.println("Error during initialisation:"+e.toString());
				}
	}

}
