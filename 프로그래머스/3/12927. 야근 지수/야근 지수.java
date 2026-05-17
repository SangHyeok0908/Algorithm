import java.util.*;

class Solution {
    
    public long solution(int n, int[] works) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int w : works) {
            queue.add(w);
        }
        
        while(n > 0) {
            int poll = queue.poll();
            
            if (poll == 0) {
                break;
            }
            
            queue.add(poll - 1);
            n--;
        }
        
        long answer = 0;
        while(!queue.isEmpty()) {
            int poll = queue.poll();
            // System.out.println(poll);
            answer += Math.pow(poll, 2);
        }
        return answer;
    }
}