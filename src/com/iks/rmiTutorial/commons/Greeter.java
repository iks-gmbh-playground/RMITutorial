package com.iks.rmiTutorial.commons;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Greeter extends Remote {
	
	String greetMe(String name) throws RemoteException;

	String greetMe(Person person) throws RemoteException;

}
