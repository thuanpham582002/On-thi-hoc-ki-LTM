package org.example.tcp.b701;

import java.io.*;
import java.net.Socket;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.example.Constants.STUDENTCODE;

public class Client {
    private static String code = STUDENTCODE + ";701";
    private static int port = 701;
    private static String address = "localhost";

    public static void main(String[] args) throws IOException {
        Socket myServer = new Socket(address, port);
        OutputStream byteOut = myServer.getOutputStream();
        byteOut.write(code.getBytes());
        InputStream byteIn = myServer.getInputStream();
        byte[] buffer = new byte[1024];
        byteIn.read(buffer);
        String message = new String(buffer);
        String[] arrString = message.trim().split(",");
        int[] arr = new int[arrString.length];
        for (int i = 0; i < arrString.length; i++) {
            arr[i] = Integer.parseInt(arrString[i]);
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }

        List<Integer> list = new java.util.ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        list.sort((o1, o2) -> o1 - o2);
        System.out.println();
        for (int i : list) {
            System.out.print(i + " ");
        }

        String result = "";
        result += list.get(0) + "," + list.get(list.size() - 1) + "," + list.get(list.size() - 2);
        System.out.println();
        System.out.println(result);
        byteOut.write(result.getBytes());
        // get first element and last- 1 and last element in set

        myServer.close();
    }


}
