package org.example.udp.b933;
import UDP.Student933;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import static org.example.Constants.STUDENTCODE;

public class Client {
    static int port = 933;
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
        ByteArrayInputStream bis = new ByteArrayInputStream(bufferReceive);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Student933 student = null;
        try {
            student = (Student933) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        student.setId("933");
        student.setName("Thuan");
        student.setEmail("tienthuan05082002@gmail.com");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(student);

        bufferSend = baos.toByteArray();
        packetSend = new DatagramPacket(bufferSend, bufferSend.length, InetAddress.getByName(address), port);
        socket.send(packetSend);
        socket.close();
    }
}
