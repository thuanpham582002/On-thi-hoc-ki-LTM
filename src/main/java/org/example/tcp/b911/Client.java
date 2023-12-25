package org.example.tcp.b911;

import java.io.*;
import java.net.Socket;
import java.util.Map;

import static org.example.Constants.STUDENTCODE;

public class Client {
    private static String code = STUDENTCODE + ";911";
    private static int port = 911;
    private static String address = "localhost";

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(address, port);
        DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
        DataInputStream reader = new DataInputStream(socket.getInputStream());
        writer.writeUTF(code);
        int a, b;
        a = reader.readInt();
        b = reader.readInt();
        writer.writeInt(gcd(a, b));
        writer.writeInt(lcm(a, b));
        writer.writeInt(a + b);
        writer.writeInt(a * b);
        // get first element and last- 1 and last element in set

        socket.close();
    }


    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }


}
