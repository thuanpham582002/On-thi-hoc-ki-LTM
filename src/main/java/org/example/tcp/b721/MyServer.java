package org.example.tcp.b721;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static org.example.Constants.STUDENTCODE;


public class MyServer {
    static String code = STUDENTCODE + ";721";

    public static void main(String[] args) throws IOException {
        try {
            ServerSocket server = new ServerSocket(721);
            while (true) {
                Socket connection = server.accept();
                new Process(connection).run();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    static class Process implements Runnable {
        Socket connection;

        public Process(Socket connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            try {
                System.out.println("Connected");
                BufferedReader byteIn = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                BufferedWriter byteOut = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
                System.out.println("Connected");
                String message = byteIn.readLine().trim();
                System.out.println(message);
                if (!message.trim().equals(code)) {
                    connection.close();
                    return;
                }

                String arr = generateString(10);
                byteOut.write(arr);
                message = byteIn.readLine();
                System.out.println(message);
                connection.close();
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
