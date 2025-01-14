import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        String[] input2 = br.readLine().split(" ");
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            array.add(Integer.parseInt(input2[i]));
        }

        while (!array.isEmpty()) {
            int idx = 0;
            for (Integer i : deque) {
                if (array.get(0) == i) {
                    break;
                }

                idx++;
            }

            while (array.get(0) != deque.getFirst()) {
                if (idx <= deque.size() - 1 - idx) {
                    deque.addLast(deque.pollFirst());
                } else {
                    deque.addFirst(deque.pollLast());
                }

                answer++;
            }

            deque.pop();
            array.remove(0);
        }

        bw.write(answer + "\n");
        bw.close();
    }
}