package com.iks.rmiTutorial.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.iks.rmiTutorial.Greeter;

public class GreetServer implements Greeter {

	protected GreetServer() throws RemoteException {
		super();
	}

	@Override
	public String greetMe(String name) throws RemoteException {
		return "Hello " + name + "! How are you?";
	}

	public static void main(String[] args) {
		try {
			GreetServer server = new GreetServer();
			Greeter stub = (Greeter) UnicastRemoteObject.exportObject(server, 0);
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind("Greeter", stub);
			
			System.out.println("Ready! Waiting for rquests...");
		} catch (Exception e) {
			System.out.println("Server Exception: " + e.toString());
			e.printStackTrace();
		}

	}

}
