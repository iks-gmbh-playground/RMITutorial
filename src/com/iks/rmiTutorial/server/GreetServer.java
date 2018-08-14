package com.iks.rmiTutorial.server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.iks.rmiTutorial.commons.Greeter;
import com.iks.rmiTutorial.commons.Person;

public class GreetServer implements Greeter {
	
	private final static int PORT = 1099;

	protected GreetServer() throws RemoteException {
		super();
	}

	@Override
	public String greetMe(String name) throws RemoteException {
		log("Request received for name: " + name);
		return "Hello " + name + "! How are you?";
	}
	
	@Override
	public String greetMe(Person person) {
		log("Request received for person: " + person);
		return "Hello " + person.getFullname() + "! How are you?";
	}

	public void log(String message) {
		String extMessage = message + " - " + Thread.currentThread().getName();
		System.out.println(extMessage);
		PrintWriter log = null;
		try {
			log = new PrintWriter(new BufferedWriter(new FileWriter("./logs/log.txt", true)));
			log.println(extMessage);
		} catch (IOException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			if (log != null) log.close();
		}
		
	}

	public static void main(String[] args) {
		try {
			GreetServer server = new GreetServer();
			Greeter stub = (Greeter) UnicastRemoteObject.exportObject(server, 0);
			Registry registry = LocateRegistry.createRegistry(PORT);
			registry.rebind("Greeter", stub);
			
			System.out.println("GreetServer started on " + getIPAddress() + " port: " + PORT);
			System.out.println("Ready! Waiting for rquests...");
		} catch (Exception e) {
			System.out.println("Server Exception: " + e.toString());
			e.printStackTrace();
		}

	}
	
	private static String getIPAddress() {
		  InetAddress ip;
		  try {

			ip = InetAddress.getLocalHost();
			return ip.getHostAddress();

		  } catch (UnknownHostException e) {
			e.printStackTrace();
		  }
		  
		  return ("Unknown Host");
	}

}
