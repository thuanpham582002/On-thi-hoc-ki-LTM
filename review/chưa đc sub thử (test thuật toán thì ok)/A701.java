
import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class A701 {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("203.162.10.109", 2206);
            InputStream is = client.getInputStream();
            OutputStream os = client.getOutputStream();
            String msv = "" ;
            byte[] send = msv.getBytes();
            os.write(send);

            byte[] receive = new byte[1024];
            is.read(receive);
            String[] s = new String(receive).split(",");
            int[] a = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                a[i] = Integer.parseInt(s[i].trim());
            }
            Arrays.sort(a);
            int Min = Integer.MAX_VALUE;
            int vt1 = 0;
            int vt2 = 0;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i + 1] - a[i] < Min) {
                    Min = a[i + 1] - a[i];
                    vt1 = i;
                    vt2 = i + 1;
                }
            }
            String result = Min + ", " + vt1 + ", " + vt2;
            byte[] sendBytes = result.getBytes();
            os.write(sendBytes);
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
