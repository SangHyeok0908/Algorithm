import java.util.*;

class Solution {
    String[] nums;
    String[] dp;
    boolean[] isVisited;
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        nums = new String[numbers.length()];
        
        for (int i = 1; i <= numbers.length(); i++) {
            nums[i - 1] = numbers.substring(i - 1, i);
        }
        
        for (int i = 1; i <= numbers.length(); i++) {
            dp = new String[i];
            isVisited = new boolean[numbers.length()];
            recursion(0, i);
        }
        
        // System.out.println("set 출력");
        // for (Integer i : set) {
        //     System.out.println(i);
        // }
        // System.out.println("set 출력 end");
        
        int cnt = 0;
        for (Integer i : set) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    cnt++;
                    // System.out.println("제외 수 = " + i);
                    break;
                }
            }
        }
        
        return set.size() - cnt;
    }
    
    void recursion(int depth, int digit) {
        if (depth == digit) {
            String temp = "";
            
            for (String r : dp) {
                temp += r;
            }
            
            int result = Integer.parseInt(temp);
            
            // System.out.printf("조합된 수 = %d\n", result);
            
            for (int i = 2; i < result; i++) {
                if (result % i == 0) return;
            }
            
            if (result >= 2)
                set.add(result);
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // System.out.printf("depth = %d, i = %d\n", depth, i);
            
            if ((depth == 0 && nums[i].equals("0")) || isVisited[i]) continue;
            
            dp[depth] = nums[i];
            isVisited[i] = true;
            recursion(depth + 1, digit);
            isVisited[i] = false;
        }
    }
}