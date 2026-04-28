import java.util.*;

class Solution {
    
    public long solution(int n, int[] works) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (int i = 0; i < works.length; i++) {
            queue.add(works[i]);
            sum += works[i];
        }
        
        if (sum <= n) {
            return 0;
        }
        
        for (int i = n; i > 0; i--) {
            int num = queue.poll() - 1;
            queue.add(num);
        }
        
        long answer = 0;
        while(!queue.isEmpty()) {
            answer += Math.pow(queue.poll(), 2);
        }
        
        return answer;
    }
}