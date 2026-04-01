import java.util.*;

class Solution {
    
    int[][] triangle;
    int[][] dp;
    int h;
    
    public int solution(int[][] triangle) {
        this.triangle = triangle;
        h = triangle.length;
        dp = new int[h][];
        
        for (int i = 0; i < h; i++) {
            dp[i] = new int[triangle[i].length];
        }
        
        for (int i = 0; i < triangle[h - 1].length; i++) {
            dp[h - 1][i] = triangle[h - 1][i];
        }
        
        for (int i = h - 2; i >= 0; i--) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        
        // for (int i = 0; i < h; i++) {
        //     for (int j = 0; j < dp[i].length; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        return dp[0][0];
    }
}