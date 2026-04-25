import java.util.*;

class Solution {
    
    class Node {
        List<Integer> top = new ArrayList<>(), bottom = new ArrayList<>();
    }
    
    Node[] nodes;
    boolean[] visited;
    
    public int solution(int n, int[][] results) {
        nodes = new Node[n + 1];
        
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node();
        }
        
        for (int[] result : results) {
            nodes[result[0]].bottom.add(result[1]);
            nodes[result[1]].top.add(result[0]);
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            int topCnt = dfs(i, true) - 1;
            
            visited = new boolean[n + 1];
            int bottomCnt = dfs(i, false) - 1;
            
            // System.out.printf("%d top = %d, bottom = %d\n", i, topCnt, bottomCnt);
            
            if (topCnt + bottomCnt == n - 1) {
                answer++;
            }
        }
        
        return answer;
    }
    
    int dfs(int cur, boolean isTop) {
        int result = 1;
        
        if (visited[cur]) {
            return 0;
        }
        
        visited[cur] = true;
        
        if (isTop) {
            for (int t : nodes[cur].top) {
                result += dfs(t, isTop);        
            }
        } else {
            for (int b : nodes[cur].bottom) {
                result += dfs(b, isTop);
            }
            
        }
        return result;
    }
}