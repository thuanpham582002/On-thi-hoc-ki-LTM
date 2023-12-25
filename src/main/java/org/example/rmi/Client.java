package org.example.rmi;

import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = java.rmi.registry.LocateRegistry.getRegistry("localhost", 1097);

            RemoteInterface remoteInterface = (RemoteInterface) registry.lookup("remote1097");
            System.out.println(remoteInterface.sayHello());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Nên dùng registry thay vì Naming.lookup() vì registry có thể chạy trên nhiều port khác nhau, còn Naming.lookup() chỉ chạy trên port 1099