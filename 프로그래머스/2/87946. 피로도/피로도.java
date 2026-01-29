import java.util.*;

class Solution {
    int[][] dungeons;
    int[][] arr;
    boolean[] isVisited;
    int k;
    int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        this.k = k;
        arr = new int[dungeons.length][2];
        isVisited = new boolean[dungeons.length];
        
        bruteForce(0);
        return answer;
    }
    
    void bruteForce(int depth) {
        if (depth == dungeons.length) {
            // System.out.println("=========");
            // for (int i = 0; i < arr.length; i++) {
            //     System.out.println(arr[i][0] + " " + arr[i][1]);
            // }
            
            int dungeon = k;
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][0] > dungeon || arr[i][1] > dungeon) continue;
                
                dungeon -= arr[i][1];
                cnt++;
            }
            
            answer = Math.max(answer, cnt);
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (isVisited[i]) continue;
            
            arr[depth] = dungeons[i];
            isVisited[i] = true;
            bruteForce(depth + 1);
            isVisited[i] = false;
        }
    }
}