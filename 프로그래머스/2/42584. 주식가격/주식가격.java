class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length - 1; i++) {
            int cur = prices[i];
            int cnt = 0;
            
            for (int j = i + 1; j < prices.length; j++) {
                int next = prices[j];
                
                if (cur <= next) {
                    cnt++;
                } else {
                    break;
                }
            }
            
            if (cnt == prices.length - i - 1)
                answer[i] = cnt;
            else
                answer[i] = cnt + 1;
        }
        return answer;
    }
}