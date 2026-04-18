class Solution {
    
    boolean[] visited;
    String target;
    String[] words;
    int n;
    
    public int solution(String begin, String target, String[] words) {
        int answer = Integer.MAX_VALUE;
        this.n = words.length;
        this.target = target;
        this.words = words;

        for (int i = 0; i < n; i++) {
            if (possibleChange(begin, words[i])) {
                // System.out.println("start = " + words[i]);

                visited = new boolean[n];
                visited[i] = true;
                                
                int result = dfs(words[i], 1);
                answer = Math.min(answer, result);
            }
        }
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    int dfs(String str, int depth) {
        int result = Integer.MAX_VALUE;
        
        // System.out.println("change str = " + str);
        
        if (str.equals(target)) {
            return depth;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i] && possibleChange(str, words[i])) {
                visited[i] = true;
                result = Math.min(result, dfs(words[i], depth + 1));
                visited[i] = false;
            }
        }
        return result;
    }
    
    boolean possibleChange(String str1, String str2) {
        char[] o = str1.toCharArray();
        char[] t = str2.toCharArray();
        int cnt = 0;
        
        for (int i = 0; i < o.length; i++) {
        
            if (o[i] == t[i]) {
                cnt++;
            }    
        }
        
        return cnt == o.length - 1;
    }
}