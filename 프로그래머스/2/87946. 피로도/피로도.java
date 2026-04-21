import java.util.*;

class Solution {
    
    int n, k;
    boolean[] visited;
    int[] arr;
    int answer = 0;
    int[][] dungeons;
    
    public int solution(int k, int[][] dungeons) {
        this.k = k;
        this.dungeons = dungeons;
        n = dungeons.length;
        visited = new boolean[n];
        arr = new int[n];
        
        dfs(0);
        return answer;
    }
    
    void dfs(int depth) {
        if (depth == n) {
            // for (int i = 0; i < n; i++) {
            //     System.out.print(arr[i] + " ");
            // }
            // System.out.println();
            answer = Math.max(answer, search());
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            
            visited[i] = true;
            arr[depth] = i;
            dfs(depth + 1);
            
            visited[i] = false;
        }
    }
    
    int search() {
        int cur = k;
        int cnt = 0;
        
        // System.out.println("======");
        for (int i = 0; i < n; i++) {
            int idx = arr[i];
            
            if (cur >= dungeons[idx][0]) {
                cur -= dungeons[idx][1];
                cnt++;
                
                // System.out.println(dungeons[idx][0] + " " + dungeons[idx][1]);
            }
        }
        return cnt;
    }
}