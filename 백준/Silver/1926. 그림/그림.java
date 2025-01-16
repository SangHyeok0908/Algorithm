import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static int n, m;
    static boolean[][] isVisited;

    static int bfs(int x, int y) {
        int result = 1;
        int[][] position = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x, y});
        isVisited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int[] pos : position) {
                int currentX = poll[0] + pos[0];
                int currentY = poll[1] + pos[1];

                if (currentX >= n || currentY >= m || currentX < 0 || currentY < 0) continue;

                if (graph[currentX][currentY] == 1 && !isVisited[currentX][currentY]) {
                    result++;
                    isVisited[currentX][currentY] = true;
                    queue.add(new int[]{currentX, currentY});
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        List<Integer> answer = new ArrayList<>();
        boolean isZero = true;

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        graph = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (isZero) {
                for(int j =0; j < graph[i].length; j++) {
                    if (graph[i][j] == 1) {
                        isZero = false;
                        break;
                    }
                }
            }
        }

        if (isZero) {
            bw.write("0\n0\n");
            bw.close();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisited[i][j] && graph[i][j] == 1) {
                    answer.add(bfs(i, j));
                }
            }
        }

        Collections.sort(answer);
        bw.write(answer.size() + "\n" + answer.get(answer.size() - 1) + "\n");
        bw.close();
    }
}