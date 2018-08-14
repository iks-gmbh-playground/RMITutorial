package com.iks.rmiTutorial.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.iks.rmiTutorial.commons.Greeter;

public class RMIPowerApp {
	private final static String DEFAULT_NAME = "Willi";
	private final static String DEFAULT_HOST = "localhost";
	private final static int DEFAULT_PORT = 1099;

	public static void main(String[] args) {
		String name = (args.length > 0) ? args[0] : DEFAULT_NAME;
		String host = (args.length > 1) ? args[1] : DEFAULT_HOST;
		int port = (args.length > 2) ? Integer.parseInt(args[2]) : DEFAULT_PORT;
		
        try {
        	System.out.println("Looking for registry on " + host + " port: " + port);
            Registry registry = LocateRegistry.getRegistry(host, port);
            Greeter stub = (Greeter) registry.lookup("Greeter");
            for (int i=1; i<=1000; i++) {
                String response = stub.greetMe(name + "_" + i);
                System.out.println("response: " + response);
                Thread.sleep(10);
            }
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

	}
	
}
