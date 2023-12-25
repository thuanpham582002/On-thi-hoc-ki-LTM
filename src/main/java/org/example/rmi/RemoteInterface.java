package org.example.rmi;

import java.rmi.Remote;

public interface RemoteInterface  extends Remote {
    public String sayHello() throws java.rmi.RemoteException;
}
