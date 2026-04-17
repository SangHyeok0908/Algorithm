import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, List<String>> map = new HashMap<>();
        int answer = 1;
        int size = clothes.length;
        
        for (String[] s : clothes) {
            if (map.containsKey(s[1])) {
                List<String> list = map.get(s[1]);
                list.add(s[0]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s[0]);
                map.put(s[1], list);
            }
        }
        
        for (String key : map.keySet()) {
            answer *= map.get(key).size() + 1;
            // for (String s : map.get(key)) {
            //     System.out.println(s);
            // }
            // System.out.println("===========");
        }
        
        return answer - 1;
    }
}