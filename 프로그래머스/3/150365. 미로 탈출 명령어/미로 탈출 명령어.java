import java.util.*;

class Solution {
    
    int[] dy = { 1, 0, 0, -1 };
    int[] dx = { 0, -1, 1, 0 };
    char[] direct = { 'd', 'l', 'r', 'u' }; // 우선순위: 아래, 왼쪽, 오른쪽, 위쪽
    int[][][] parent;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        Queue<int[]> q = new ArrayDeque<>();
        List<String> result = new ArrayList<>();
        parent = new int[n + 1][m + 1][k + 1];
        
        q.add(new int[] { x, y, 0 });
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                Arrays.fill(parent[i][j], -1);
            }
        }
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (cur[2] == k && cur[0] == r && cur[1] == c) {
                return getPath(r, c, x, y, k);
            }
            
            if (cur[2] >= k) {
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int nearY = cur[0] + dy[i];
                int nearX = cur[1] + dx[i];
                int nearCost = cur[2] + 1;
                
                if (nearY <= 0 || nearY > n || nearX <= 0 || nearX > m 
                    || parent[nearY][nearX][nearCost] != -1) {
                    continue;
                }
                
                q.add(new int[] { nearY, nearX, nearCost });
                parent[nearY][nearX][nearCost] = i;
            }
        }
        return "impossible";
    }
    
    String getPath(int startY, int startX, int endY, int endX, int k) {
        StringBuilder sb = new StringBuilder();
        int y = startY, x = startX;
        int cnt = k;
        
        while(cnt > 0) {
            int idx = parent[y][x][cnt--];
            
            sb.append(direct[idx]);
            y -= dy[idx];
            x -= dx[idx];
        }
        return sb.reverse().toString();
    }
}