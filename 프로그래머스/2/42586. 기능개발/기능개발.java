import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < speeds.length; i++) {
            int progress = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) progress++;
            
            deque.addLast(progress);    
        }
        
        // for (Integer i : deque) {
        //     System.out.println(i);
        // }
        // System.out.println("====");
        
        int prev = deque.pollFirst();
        int cnt = 1;
        while(!deque.isEmpty()) {
            int cur = deque.pollFirst();
            
            if (prev >= cur) {
                cnt++;
            }else {
                result.add(cnt);
                // System.out.printf("prev = %d, cur = %d, cnt = %d\n", prev, cur, cnt);
                cnt = 1;
                prev = cur;
            }
        }
        result.add(cnt);
        
        // for(int i : result) {
        //     System.out.println(i);    
        // }
        // System.out.println("=========");
        
        return result.stream()
            .mapToInt(a -> a)
            .toArray();
    }
}