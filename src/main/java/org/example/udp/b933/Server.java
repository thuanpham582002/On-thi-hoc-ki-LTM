package org.example.udp.b933;

import UDP.Student933;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import static org.example.Constants.STUDENTCODE;

public class Server {
    static int port = 933;
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


                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(new Student933("933"));
                bufferSend = baos.toByteArray();
                DatagramPacket packetSend = new DatagramPacket(bufferSend, bufferSend.length, packetReceive.getAddress(), packetReceive.getPort());

                socket.send(packetSend);

                bufferReceive = new byte[1024];
                packetReceive = new DatagramPacket(bufferReceive, bufferReceive.length);
                socket.receive(packetReceive);

                ByteArrayInputStream bis = new ByteArrayInputStream(bufferReceive);
                ObjectInputStream ois = new ObjectInputStream(bis);
                Student933 student = (Student933) ois.readObject();
                System.out.println(student);

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {


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
