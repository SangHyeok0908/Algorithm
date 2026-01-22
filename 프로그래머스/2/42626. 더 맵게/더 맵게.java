import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        
        for (int i : scoville) {
            queue.add(i);
        }
        
        while(!queue.isEmpty() && queue.peek() < K) {
            int first = queue.poll();
            
            if (queue.isEmpty()) {
                return -1;
            }
            
            int second = queue.poll();
            queue.add(first + second * 2);
            
            answer++;
        }
        return answer;
    }
}