import java.util.*;

class Solution {

    public int solution(int n, int[] stations, int w) {
        List<Integer> sizeList = new ArrayList<>();
        int prev = 1;
        
        for (int st : stations) {
            int end = st - w - 1;
            
            if (end >= prev) {
                sizeList.add(end - prev + 1);    
            }
            
            prev = st + w + 1;
        }
        
        if (stations[stations.length - 1] + w + 1 <= n) {
            sizeList.add(n - (stations[stations.length - 1] + w + 1) + 1);    
        }
        
        // for (int i : sizeList) {
        //     System.out.print(i + " ");
        // }
        // System.out.println();
        
        int answer = 0;
        int range = w + w + 1;
        for (int size : sizeList) {
            // System.out.println(size + " " + range);
            if (size % range > 0) {
                answer += size / range + 1;
            } else {
                answer += size / range;
            }
        }
        return answer;
    }
}