import java.io.*;
import java.util.*;

public class Main {

    static final int[] dx = new int[]{-1, 1, 0, 0};
    static final int[] dy = new int[]{0, 0, -1, 1};
    static int[][] graph;
    static Queue<int[]> startPointQueue = new ArrayDeque<>();
    static int N;
    static int islandCount = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1) {
                    classify(i, j);
                }
            }
        }

        int result = solve();
        if (result == Integer.MAX_VALUE) bw.write("0\n");
        else bw.write((result - 1) + "\n");
        bw.close();
    }

    /*
     각 대륙을 분류하는 함수
     분리는 2부터 시작하는 숫자로 1씩 증가하여 2 대륙, 3 대륙, 4 대륙..
     대륙에 인접하는 바다를 startPointQueue에 삽입
     */
    static void classify(int startY, int startX) {
        Queue<int[]> islandQueue = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[N][N];

        islandCount++;
        graph[startY][startX] = islandCount;
        islandQueue.add(new int[]{startY, startX});
        isVisited[startY][startX] = true;

        while (!islandQueue.isEmpty()) {
            int[] poll = islandQueue.poll();
            for (int i = 0; i < 4; i++) {
                int curX = poll[1] + dx[i];
                int curY = poll[0] + dy[i];

                if (!isInGraph(curY, curX) || isVisited[curY][curX]) continue;

                isVisited[curY][curX] = true;

                if (graph[curY][curX] == 0) {
                    startPointQueue.add(new int[]{curY, curX, islandCount});
                } else {
                    graph[curY][curX] = islandCount;
                    islandQueue.add(new int[]{curY, curX});
                }
            }
        }
    }

    static int solve() {
        int result = Integer.MAX_VALUE;

        while (!startPointQueue.isEmpty()) {
            int[] poll = startPointQueue.poll();

            result = Math.min(result, bfs(poll[0], poll[1], poll[2]));
        }
        return result;
    }

    static int bfs(int y, int x, int islandNumber) {
        int result = Integer.MAX_VALUE;
        int[][] distance = new int[N][N];
        Queue<int[]> seaQueue = new ArrayDeque<>();

        seaQueue.add(new int[]{y, x});
        distance[y][x] = 1;

        while (!seaQueue.isEmpty()) {
            int[] poll = seaQueue.poll();

            for (int i = 0; i < 4; i++) {
                int curX = poll[1] + dx[i];
                int curY = poll[0] + dy[i];

                if (!isInGraph(curY, curX) || distance[curY][curX] != 0) continue;


                if (graph[curY][curX] == 0) {
                    distance[curY][curX] = distance[poll[0]][poll[1]] + 1;
                    seaQueue.add(new int[]{curY, curX});
                } else if (graph[curY][curX] != islandNumber) {
                    distance[curY][curX] = distance[poll[0]][poll[1]] + 1;
                    result = Math.min(result, distance[curY][curX]);
                }
            }
        }
        return result;
    }

    static boolean isInGraph(int y, int x) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}