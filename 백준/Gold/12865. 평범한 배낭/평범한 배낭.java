import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int[][] dp = new int[N + 1][K + 1];

        for(int i = 1; i <= N; i++) {
            String[] s1 = br.readLine().split(" ");
            int W = Integer.parseInt(s1[0]);
            int V = Integer.parseInt(s1[1]);

            for(int j = 1; j <= K; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= W) {
                    dp[i][j] = Math.max(dp[i][j], V + dp[i - 1][j - W]);
                }
            }
        }

        bw.write(dp[N][K] + "\n");
        br.close();
        bw.close();
    }
}