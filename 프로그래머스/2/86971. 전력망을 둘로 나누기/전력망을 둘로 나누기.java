import java.util.*;

class Solution {
    
    ArrayList<Integer>[] nodes;
    boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        nodes = new ArrayList[n + 1];
        
        for (int i = 0; i < n; i++) {
            nodes[i + 1] = new ArrayList<>();
        }
        
        for (int i = 0; i < n - 1; i++) {
            nodes[wires[i][0]].add(wires[i][1]);
            nodes[wires[i][1]].add(wires[i][0]);
        }
        
        for (int i = 0; i < n; i++) {
            for (Integer node : nodes[i + 1]) {
                visited = new boolean[n + 1];
                visited[node] = true;
                
                int result = dfs(i + 1);
                answer = Math.min(answer, Math.abs(n - result - result));
            }
        }
        
        return answer;
    }
    
    int dfs(int from) {
        int result = 1;
        visited[from] = true;
        
        for (Integer to : nodes[from]) {
            if (!visited[to]) {
                result += dfs(to);
            }
        }
        return result;
    }
}