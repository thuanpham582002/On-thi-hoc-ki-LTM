package org.example.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) {
        try {
            RemoteInterfaceImpl remoteInterface = new RemoteInterfaceImpl();
            UnicastRemoteObject.exportObject(remoteInterface, 1097);
            Registry registry = LocateRegistry.createRegistry(1097);
            registry.rebind("remote1097", remoteInterface);
            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }

}
