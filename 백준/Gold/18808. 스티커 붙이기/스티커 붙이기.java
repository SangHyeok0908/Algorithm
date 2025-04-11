import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, K;
    static int[][] noteBook;
    static int[] dy = new int[]{0, 0, -1, 1};
    static int[] dx = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        int answer = 0;
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        K = Integer.parseInt(s[2]);
        noteBook = new int[N][M];

        for (int k = 0; k < K; k++) {    // 스티커의 개수만큼 반복
            String[] s1 = br.readLine().split(" ");
            int R = Integer.parseInt(s1[0]);
            int C = Integer.parseInt(s1[1]);
            int[][] sticker = new int[R][C];

            for (int r = 0; r < R; r++) {
                sticker[r] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            func(sticker, 0);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (noteBook[i][j] == 1) answer++;
            }
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }

    static void print(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("============");
    }

    static void func(int[][] sticker, int cnt) {
        if (cnt == 4) return;

        boolean isBreak = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isBlank(sticker, i, j)) {
                    attachSticker(sticker, i, j);
                    isBreak = true;
                    break;
                }
            }

            if (isBreak) break;
        }

        if (!isBreak) {
            func(rotateSticker(sticker), cnt + 1);
        }
    }

    static int[][] rotateSticker(int[][] sticker) {
        int rowSize = sticker.length;
        int colSize = sticker[0].length;
        int[][] result = new int[colSize][rowSize];

        for(int i = 0; i < rowSize; i++) {
            for(int j = 0; j < colSize; j++) {
                result[j][rowSize - 1 - i] = sticker[i][j];
            }
        }
        return result;
    }

    static boolean isFitSize(int[][] sticker, int startY, int startX) {
        return sticker.length <= N - startY && sticker[0].length <= M - startX;
    }

    static boolean isBlank(int[][] sticker, int startY, int startX) {
        if (!isFitSize(sticker, startY, startX)) return false;

        for (int i = startY, stickerY = 0; stickerY < sticker.length; i++, stickerY++) {
            for (int j = startX, stickerX = 0; stickerX < sticker[0].length; j++, stickerX++) {
                if (sticker[stickerY][stickerX] == 1 && noteBook[i][j] == 1) return false;
            }
        }
        return true;
    }

    static void attachSticker(int[][] sticker, int startY, int startX) {
        for (int i = startY, stickerY = 0; stickerY < sticker.length; i++, stickerY++) {
            for (int j = startX, stickerX = 0; stickerX < sticker[0].length; j++, stickerX++) {
                if (sticker[stickerY][stickerX] == 1) noteBook[i][j] = 1;
            }
        }
    }
}