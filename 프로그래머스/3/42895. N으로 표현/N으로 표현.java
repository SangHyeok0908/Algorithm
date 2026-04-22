import java.util.*;

class Solution {

    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }
        
        Set<Integer>[] dp = new HashSet[9];
        int base = 0;
        
        for (int i = 1; i <= 8; i++) {
            dp[i] = new HashSet<>();
            base = base * 10 + N;
            dp[i].add(base);
        }
        
        for (int i = 2; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                int k = i - j;
                
                for (int n1 : dp[j]) {
                    for (int n2 : dp[k]) {
                        dp[i].add(n1 + n2);
                        dp[i].add(n1 - n2);
                        dp[i].add(n1 * n2);  
                        if (n2 != 0) {
                            dp[i].add(n1 / n2);
                        }
                    }
                }
            }
            
            if (dp[i].contains(number)) {
                return i;
            }
        }
        return -1;
    }
}