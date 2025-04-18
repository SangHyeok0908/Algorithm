import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[M];

        recursion(0, 0);
        br.close();
        bw.close();
    }

    static void recursion(int depth, int startIdx) throws IOException {
        if (depth == M) {
            for(int i : arr) {
                bw.write((i + 1) + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = startIdx; i < N; i++) {
            arr[depth] = i;
            recursion(depth + 1, i + 1);
        }
    }
}