import java.util.*;

class Solution {
    
    public int[] solution(int[] progresses, int[] speeds) {
        int idx = 0;
        int n = progresses.length;
        List<Integer> result = new ArrayList<>();
        
        while(idx < n) {            
            for (int i = idx; i < n; i++) {
                progresses[i] += speeds[i];
                // System.out.printf("i = %d, progress = %d\n", i, progresses[i]);
            }
            
            int cnt = 0;
            while(idx < n && progresses[idx] >= 100) {
                // System.out.printf("idx = %d, day = %d\n", idx, day);
                cnt++;
                idx++;
            }
            
            if (cnt != 0) {
                result.add(cnt);
            }
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}