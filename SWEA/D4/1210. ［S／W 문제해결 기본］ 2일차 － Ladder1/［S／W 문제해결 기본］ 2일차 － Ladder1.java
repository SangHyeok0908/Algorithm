import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] ladder;
    static int N = 100;
    static boolean[][] isVisited;

    public static void main(String[] args) throws Exception {
        StringBuilder answer = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            br.readLine();
            ladder = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                if (ladder[0][i] == 1) {
                    isVisited = new boolean[N][N];
                    if (dfs(0, i)) {
                        answer.append("#" + t + " " + i + "\n");
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static boolean dfs(int y, int x) {
        isVisited[y][x] = true;

        if (y == N - 1) {
            if (ladder[y][x] == 2)
                return true;
            return false;
        }

        if (x - 1 >= 0 && ladder[y][x - 1] == 1 && !isVisited[y][x - 1])
            return dfs(y, x - 1);

        if (x + 1 < N && ladder[y][x + 1] == 1 && !isVisited[y][x + 1])
            return dfs(y, x + 1);

        return dfs(y + 1, x);
    }
}