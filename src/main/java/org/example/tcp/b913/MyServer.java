package org.example.tcp.b913;

import TCP.Student;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static org.example.Constants.STUDENTCODE;


public class MyServer {
    static String code = STUDENTCODE + ";913";

    public static void main(String[] args) throws IOException {
        try {
            ServerSocket server = new ServerSocket(913);
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
                ObjectOutputStream writer = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream reader = new ObjectInputStream(socket.getInputStream());
                String message = (String) reader.readObject();
                System.out.println(message);
                if (!message.trim().equals(code)) {
                    socket.close();
                    return;
                }
                Student student = new Student(1, message.split(";")[0], 1, "a");

                writer.writeObject(student);
                Student student1 = (Student) reader.readObject();
                System.out.println(student1);
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {


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
