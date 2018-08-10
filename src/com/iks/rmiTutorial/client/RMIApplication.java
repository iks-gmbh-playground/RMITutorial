package com.iks.rmiTutorial.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.iks.rmiTutorial.Greeter;

public class RMIApplication {

	public static void main(String[] args) {
		String name = (args.length < 1) ? "Willi" : args[0];
		System.out.println("name: " + name);
		
//		if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new SecurityManager());
//        }
		
        try {
            Registry registry = LocateRegistry.getRegistry();
            Greeter stub = (Greeter) registry.lookup("Greeter");
            String response = stub.greetMe(name);
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

	}

}
