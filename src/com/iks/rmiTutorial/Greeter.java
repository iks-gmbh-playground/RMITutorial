package com.iks.rmiTutorial;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Greeter extends Remote {
	
	String greetMe(String name) throws RemoteException;

}
