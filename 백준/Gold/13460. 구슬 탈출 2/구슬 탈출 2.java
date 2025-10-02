import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  static int N, M;
  static char[][] matrix;

  public static void main(String[] args) throws Exception {
    int[] red = null, blue = null;
    int[] input = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt).toArray();
    N = input[0];
    M = input[1];
    matrix = new char[N][M];

    for (int i = 0; i < N; i++) {
      matrix[i] = br.readLine().toCharArray();

      for (int j = 0; j < M; j++) {
        if (matrix[i][j] == 'R') {
          red = new int[] { i, j };
        } else if (matrix[i][j] == 'B') {
          blue = new int[] { i, j };
        }
      }
    }

    int answer = bfs(red, blue);
    System.out.println(answer);
  }

  static int bfs(int[] initRed, int[] initBlue) {
    int[] dy = new int[] { -1, 1, 0, 0 };
    int[] dx = new int[] { 0, 0, -1, 1 };
    Queue<int[]> queue = new ArrayDeque<>();
    boolean[][][][] isVisited = new boolean[N][M][N][M];

    queue.add(new int[] { initRed[0], initRed[1], initBlue[0], initBlue[1], 0 });
    isVisited[initRed[0]][initRed[1]][initBlue[0]][initBlue[1]] = true;

    while (!queue.isEmpty()) {
      int[] poll = queue.poll();

      for (int i = 0; i < 4; i++) {
        int curRY = poll[0];
        int curRX = poll[1];
        int curBY = poll[2];
        int curBX = poll[3];
        int cnt = poll[4];
        boolean isRedGoal = false;
        boolean isBlueGoal = false;

        if (cnt >= 10) {
          return -1;
        }

        // 벽을 만나기 전까지 이동하기
        while (matrix[curRY + dy[i]][curRX + dx[i]] != '#') {
          curRY += dy[i];
          curRX += dx[i];

          // Red가 구멍을 만났다면 종료
          if (matrix[curRY][curRX] == 'O') {
            isRedGoal = true;
            break;
          }
        }

        while (matrix[curBY + dy[i]][curBX + dx[i]] != '#') {
          curBY += dy[i];
          curBX += dx[i];

          // Blue가 구멍을 만났다면 continue
          if (matrix[curBY][curBX] == 'O') {
            isBlueGoal = true;
            break;
          }
        }

        if (isBlueGoal) {
          continue;
        } else if (isRedGoal) {
          return cnt + 1;
        }

        // 이동한 후 Red와 Blue의 위치가 동일하다면
        if (curRY == curBY && curRX == curBX) {

          // 이동 거리를 비교해서 더 큰 이동거리를 가진 공을 한 칸 뒤로 이동시키기
          int rChanged = Math.abs(curRY - poll[0]) + Math.abs(curRX - poll[1]);
          int bChanged = Math.abs(curBY - poll[2]) + Math.abs(curBX - poll[3]);

          if (rChanged > bChanged) {
            curRY -= dy[i];
            curRX -= dx[i];
          } else {
            curBY -= dy[i];
            curBX -= dx[i];
          }
        }

        if (!isVisited[curRY][curRX][curBY][curBX]) {
          isVisited[curRY][curRX][curBY][curBX] = true;
          queue.add(new int[] { curRY, curRX, curBY, curBX, cnt + 1 });

          // System.out.println(
          // String.format("red(%d, %d), blue(%d, %d), cnt = %d",
          // curRY, curRX, curBY, curBX, cnt + 1));
        }
      }
    }

    return -1;
  }
}
