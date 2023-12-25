package org.example.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteInterfaceImpl implements RemoteInterface {
    public String sayHello() throws java.rmi.RemoteException {
        return "Hello, world!";
    }
}
