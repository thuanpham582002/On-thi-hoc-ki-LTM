package org.example.tcp.b721;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Map;

import static org.example.Constants.STUDENTCODE;

public class Client {
    private static String code = STUDENTCODE + ";721";
    private static int port = 721;
    private static String address = "localhost";

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(address, port);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        writer.write(code+"\n");
        writer.flush();

        String message = reader.readLine().trim();
        Map<String, Integer> map = new java.util.HashMap<>();
        for (int i = 0; i < message.length(); i++) {
            String key = message.charAt(i) + "";
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        String result = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1)
                result += entry.getKey() + ":" + entry.getValue() + ",";
        }

        writer.write(result);
        writer.flush();
        // get first element and last- 1 and last element in set

        socket.close();
    }


}
