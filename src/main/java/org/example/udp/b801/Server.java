package org.example.udp.b801;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import static org.example.Constants.STUDENTCODE;

public class Server {
    static int port = 801;
    static String code = STUDENTCODE + ";" + port;

    public static void main(String[] args) throws SocketException {
        DatagramSocket socket = new DatagramSocket(port);
        listening(socket);
    }

    private static void listening(DatagramSocket socket) {
        byte[] bufferReceive = new byte[1024];
        byte[] bufferSend = new byte[1024];
        while (true) {
            try {
                DatagramPacket packetReceive = new DatagramPacket(bufferReceive, bufferReceive.length);
                socket.receive(packetReceive);
                String message = new String(packetReceive.getData(), 0, packetReceive.getLength());
                System.out.println(message);
                if (!message.trim().equals(code)) {
                    socket.close();
                    return;
                }


                bufferSend = "5".getBytes();
                DatagramPacket packetSend = new DatagramPacket(bufferSend, bufferSend.length, packetReceive.getAddress(), packetReceive.getPort());

                socket.send(packetSend);
                int[] array = generateArray(5);
                for (int i = 0; i < array.length; i++) {
                    bufferSend = (array[i] + "").getBytes();
                    packetSend = new DatagramPacket(bufferSend, bufferSend.length, packetReceive.getAddress(), packetReceive.getPort());
                    socket.send(packetSend);
                }

                bufferReceive = new byte[1024];
                packetReceive = new DatagramPacket(bufferReceive, bufferReceive.length);
                socket.receive(packetReceive);
                message = new String(packetReceive.getData(), 0, packetReceive.getLength());
                System.out.println(message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static int[] generateArray(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int random = (int) (Math.random() * 100);
            // if random contains in array, generate again
            for (int j = 0; j < i; j++) {
                if (result[j] == random) {
                    random = (int) (Math.random() * 100);
                    j = -1;
                }
            }
            result[i] = random;
        }
        return result;
    }
}
