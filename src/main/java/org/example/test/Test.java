package org.example.test;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void forMap(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        System.out.println(sb.reverse().toString());
    }

    public static void loaiBoKiTuTrung(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (sb.indexOf(String.valueOf(s.charAt(i))) == -1) {
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }

    public static void loaiBoKiTuDacBiet(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }

    public static int gcd(int a, int b) {
        if (a == 0 || b == 0) return a + b;
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void solanxuathien(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (sb.indexOf(String.valueOf(s.charAt(i))) == -1) {
                sb.append(s.charAt(i));
            }
        }
        for (int i = 0; i < sb.length(); i++) {
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (sb.charAt(i) == s.charAt(j)) {
                    count++;
                }
            }
            System.out.println(sb.charAt(i) + " " + count);
        }
    }

    public static void solanxuathiennhieunhattrongchuoi(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (sb.indexOf(String.valueOf(s.charAt(i))) == -1) {
                sb.append(s.charAt(i));
            }
        }
        int max = 0;
        for (int i = 0; i < sb.length(); i++) {
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (sb.charAt(i) == s.charAt(j)) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
            }
        }
        for (int i = 0; i < sb.length(); i++) {
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (sb.charAt(i) == s.charAt(j)) {
                    count++;
                }
            }
            if (count == max) {
                System.out.println(sb.charAt(i) + " " + count);
            }
        }
    }

    public static void solanxuathiennhieunhattrongchuoi2(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        int max = Collections.max(countMap.values());

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == max) {
                System.out.println(entry.getKey() + " " + max);
            }
        }
    }

    /**
     * Tách s thành2 chuỗi
     * Chuỗi thứ nhất gồm các ký tự và sô
     * Chuỗi thứ 2 gồm các ký tự đặc biệt
     *
     * @param s
     */
    public static void tachchuoi(String s) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb1.append(s.charAt(i));
            } else {
                sb2.append(s.charAt(i));
            }
        }
        System.out.println(sb1.toString());
        System.out.println(sb2.toString());

    }

    /*
    65 -> A
     */
    public static Character intToChar(int n) {
        return (char) n;
    }


    public static int charToInt(char c) {
        return (int) c;
    }

    public static int charToInt(String s) {
        // A -> 65
        return (int) s.charAt(0);
    }


    public static int[] stringToIntArray(String s) {
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = charToInt(s.charAt(i));
        }
        return arr;
    }

    public static int[] stringToIntArray2(String s) {
        int[] arr = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
        return arr;
    }

    public static String chuanHoaChuoi(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split("[]
        for (int i = 0; i < arr.length; i++) {
            sb.append(Character.toUpperCase(arr[i].charAt(0)));
            sb.append(arr[i].substring(1).toLowerCase());
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static int[] sapXepMangTangDan(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    public static int[] sapXepMangGiamDan(int[] arr) {
        Arrays.sort(arr);
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[arr.length - 1 - i];
        }
        return arr2;
    }

    /**
     * Ví dụ z -> a dịch 1 kí tự
     * a -> b dịch 1 kí tự
     *
     * @param c
     * @param n
     * @return
     */
    public static char dichPhaiKiTu(char c, int n) {
        if (Character.isUpperCase(c)) {
            return (char) ((c + n - 65) % 26 + 65);
        } else {
            return (char) ((c + n - 97) % 26 + 97);
        }
    }

    public static char dichTraiKiTu(char c, int n) {
        if (Character.isUpperCase(c)) {

            return (char) ((c - n - 65) % 26 + 65);
        } else {
            return (char) ((c - n - 97) % 26 + 97);
        }
    }

    public static void TCPClient() throws IOException {
        Socket socket = new Socket("localhost", 701);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));


        InputStream byteIn = socket.getInputStream();
        OutputStream byteOut = socket.getOutputStream();

        DataInputStream dataInputStream = new DataInputStream(byteIn);
        DataOutputStream dataOutputStream = new DataOutputStream(byteOut);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteOut));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(byteIn));


        writer.write("701");
        writer.newLine();
        writer.flush();

        String message = reader.readLine().trim();
        System.out.println(message);
        socket.close();
    }

    public static void UDPClient() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        byte[] buffer = new byte[1024];
        String message = "701";
        buffer = message.getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("localhost"), 701);
        datagramSocket.send(datagramPacket);
        datagramPacket = new DatagramPacket(buffer, buffer.length);
        datagramSocket.receive(datagramPacket);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        objectInputStream.readObject();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);


        message = new String(datagramPacket.getData());
        System.out.println(message);
        datagramSocket.close();
    }

    public static void main(String[] args) {
        System.out.println(intToChar(65));
    }
}
