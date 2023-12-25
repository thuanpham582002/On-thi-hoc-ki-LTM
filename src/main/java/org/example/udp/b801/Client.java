package org.example.udp.b801;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

import static org.example.Constants.STUDENTCODE;

public class Client {
    static int port = 801;
    static String code = STUDENTCODE + ";" + port;

    static String address = "localhost";

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        byte[] bufferReceive = new byte[1024];
        byte[] bufferSend = new byte[1024];

        bufferSend = code.getBytes();

        DatagramPacket packetSend = new DatagramPacket(bufferSend, bufferSend.length, InetAddress.getByName(address), port);
        socket.send(packetSend);

        DatagramPacket packetReceive = new DatagramPacket(bufferReceive, bufferReceive.length, InetAddress.getByName(address), port);
        socket.receive(packetReceive);
        int n = Integer.parseInt(new String(bufferReceive, 0, bufferReceive.length).trim());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            socket.receive(packetReceive);
            arr[i] = Integer.parseInt(new String(bufferReceive, 0, bufferReceive.length).trim());
            System.out.println(arr[i]);
        }
        String answer = "";
        for (int i = 1; i <= n; i++) {
            boolean hasContain = false;
            for (int j = 0; j < n; j++) {
                if (arr[j] == i) {
                    hasContain = true;
                    break;
                }
            }
            if (hasContain == false) {
                answer = answer + i + ",";
            }
        }
        answer = answer.substring(0, answer.length() - 1);
        bufferSend = answer.getBytes();
        packetSend = new DatagramPacket(bufferSend, bufferSend.length, InetAddress.getByName(address), port);
        socket.send(packetSend);
        socket.close();
    }
}
