package org.example.tcp.b913;

import TCP.Student;

import java.io.*;
import java.net.Socket;

import static org.example.Constants.STUDENTCODE;

public class Client {
    private static String code = STUDENTCODE + ";913";
    private static int port = 913;
    private static String address = "localhost";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket(address, port);
        ObjectOutputStream writer = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream reader = new ObjectInputStream(socket.getInputStream());
        writer.writeObject(code);
        Student student = (Student) reader.readObject();
        System.out.println(student);
        if (student.getGpa() < 1.0) {
            student.setGpaLetter("F");
        }
        if (student.getGpa() >= 1.0 && student.getGpa() < 2.0) {
            student.setGpaLetter("D");
        }
        if (student.getGpa() >= 2.0 && student.getGpa() < 3) {
            student.setGpaLetter("C");
        }
        if (student.getGpa() >= 3.0 && student.getGpa() < 3.7) {
            student.setGpaLetter("B");
        }
        if (student.getGpa() >= 3.7 && student.getGpa() <= 4.0) {
            student.setGpaLetter("A");
        }

        writer.writeObject(student);

        // get first element and last- 1 and last element in set

        socket.close();
    }


    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }


}
