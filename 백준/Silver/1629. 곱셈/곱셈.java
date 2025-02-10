import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int A = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);
        int C = Integer.parseInt(s[2]);

        bw.write((pow(A, B, C) % C) + "\n");
        br.close();
        bw.close();
    }

    static long pow(long A, long B, int C) {
        if (B == 1) return A;

        long x = pow(A, B / 2, C);

        if (B % 2 == 1) return ((x * x % C) * A % C) % C;

        return x * x % C;
    }
}