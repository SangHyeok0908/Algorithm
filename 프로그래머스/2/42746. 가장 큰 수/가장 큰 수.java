import java.util.*;

class Solution {    
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        StringBuilder answer = new StringBuilder();
        
        for (int n : numbers) {
            list.add(n + "");
        }
        
        Collections.sort(list, (a, b) -> (b + a).compareTo(a + b));
        
        if(list.get(0).equals("0")) return "0";
        
        for(String l : list) {
            answer.append(l);
        }
        return answer.toString();
    }
}