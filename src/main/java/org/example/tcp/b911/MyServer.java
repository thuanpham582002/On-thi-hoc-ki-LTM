package org.example.tcp.b911;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static org.example.Constants.STUDENTCODE;


public class MyServer {
    static String code = STUDENTCODE + ";911";

    public static void main(String[] args) throws IOException {
        try {
            ServerSocket server = new ServerSocket(911);
            while (true) {
                Socket connection = server.accept();
                new Process(connection).run();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    static class Process implements Runnable {
        Socket socket;

        public Process(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                System.out.println("Connected");
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
                DataInputStream reader = new DataInputStream(socket.getInputStream());
                System.out.println("Connected");
                String message = reader.readUTF().trim();
                System.out.println(message);
                if (!message.trim().equals(code)) {
                    socket.close();
                    return;
                }

                writer.writeInt(10);
                writer.writeInt(20);
                message = reader.readInt() + " " + reader.readInt() + " " + reader.readInt() + " " + reader.readInt();
                System.out.println(message);
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static String generateString(int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            while (true) {
                int random = (int) (Math.random() * 100);
                if (Character.isDigit((char) random) || Character.isLetter((char) random)) {
                    result.append((char) random);
                    break;
                }
            }
        }
        return result.toString();
    }
}
