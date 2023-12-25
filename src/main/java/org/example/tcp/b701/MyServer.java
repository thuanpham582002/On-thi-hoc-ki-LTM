package org.example.tcp.b701;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static org.example.Constants.STUDENTCODE;


public class MyServer {
    static String code = STUDENTCODE + ";701";

    public static void main(String[] args) throws IOException {
        try {
            ServerSocket server = new ServerSocket(701);
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
                InputStream byteIn = connection.getInputStream();
                byte[] buffer = new byte[1024];
                byteIn.read(buffer);
                String message = new String(buffer);
                System.out.println(message);
                if (!message.trim().equals(code)) {
                    connection.close();
                    return;
                }

                int[] arr = generateArray(10);
                StringBuilder arrString = new StringBuilder();
                for (int j : arr) {
                    arrString.append(j).append(",");
                }
                arrString = new StringBuilder(arrString.substring(0, arrString.length() - 1));
                OutputStream byteOut = connection.getOutputStream();
                byteOut.write(arrString.toString().getBytes());
                buffer = new byte[1024];
                byteIn.read(buffer);
                message = new String(buffer);
                System.out.println(message);
                connection.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static int[] generateArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = (int) (Math.random() * 100);
        return arr;
    }
}
