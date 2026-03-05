import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[][] matrix;
	static int N;
	static boolean[][] click;
	static int[] dy = new int[] { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dx = new int[] { 0, 0, -1, 1, -1, 1, -1, 1 };
	static Queue<int[]> queue = new ArrayDeque<>();
	static int answer;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			queue.clear();
			N = Integer.parseInt(br.readLine());
			matrix = new char[N][N];
			click = new boolean[N][N];
			answer = 0;

			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					matrix[i][j] = input.charAt(j);
				}
			}

			setMatrix();
			addQueue(true);
			addQueue(false);

//			print();
			while (!queue.isEmpty()) {
				int[] cur = queue.poll();
				
				if (click[cur[0]][cur[1]]) {
					continue;
				}
				
				spread(cur[0], cur[1]);
				answer++;
//				printClick();
//				System.out.println("answer = " + answer);
			}

			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb);
	}

	static void setMatrix() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (matrix[i][j] == '*')
					continue;

				int boom = findBoom(i, j);
				matrix[i][j] = Character.forDigit(boom, 10);
			}
		}
	}

	static int findBoom(int y, int x) {
		int result = 0;
		for (int i = 0; i < 8; i++) {
			int curY = y + dy[i];
			int curX = x + dx[i];

			if (isIn(curY, curX) && matrix[curY][curX] == '*') {
				result++;
			}
		}
		return result;
	}

	static void addQueue(boolean isFirst) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (isFirst) {
					if (matrix[i][j] == '0') {
						queue.add(new int[] { i, j });
					}
				} else {
					if (matrix[i][j] != '0' && Character.isDigit(matrix[i][j])) {
						queue.add(new int[] { i, j });
					}
				}
			}
		}
	}

	static void spread(int y, int x) {
		if (!isIn(y, x) || matrix[y][x] == '*' || click[y][x])
			return;

		click[y][x] = true;

		if (matrix[y][x] == '0') {
			for (int i = 0; i < 8; i++) {
				spread(y + dy[i], x + dx[i]);
			}
		}
	}

	static boolean isIn(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}
	
	static void print() {
		System.out.println("=============");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void printClick() {
		System.out.println("=============");
		System.out.println("cick print");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print((click[i][j] ? 1 : 0) + " ");
			}
			System.out.println();
		}
	}
}
