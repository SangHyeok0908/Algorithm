import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> cntMap = new HashMap<>();
        Map<String, List<Integer>> idxMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            List<Integer> idxValue = idxMap.getOrDefault(genres[i], new ArrayList<>());
            idxValue.add(i);
            
            cntMap.put(genres[i], cntMap.getOrDefault(genres[i], 0) + plays[i]);
            idxMap.put(genres[i], idxValue);
        }
        
        while(cntMap.size() > 0) {
            int max = 0;
            String maxName = null;
            
            for (String s : cntMap.keySet()) {
                int temp = cntMap.get(s);
                if (temp > max) {
                    max = temp;
                    maxName = s;
                }    
            }
            
            cntMap.remove(maxName);
            
            List<int[]> playList = new ArrayList<>();
            for (int i : idxMap.get(maxName)) {
                playList.add(new int[]{i, plays[i]});
            }
            
            playList.sort((a, b) -> {
                if (a[1] < b[1]) return 1;
                if (b[1] < a[1]) return -1;
                return a[0] - b[0];
            });
            
            answer.add(playList.remove(0)[0]);
            if (!playList.isEmpty())
                answer.add(playList.remove(0)[0]);
        }
        
        return answer.stream()
            .mapToInt(a -> a)
            .toArray();
    }
}