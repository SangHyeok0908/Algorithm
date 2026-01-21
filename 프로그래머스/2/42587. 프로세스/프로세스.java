import java.util.*;

class Process {
    public int idx, priority;
    
    public Process(int idx, int priority) {
        this.idx = idx;
        this.priority = priority;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Process> queue = new ArrayDeque<>();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Process(i, priorities[i]));
        }
        
        while(!queue.isEmpty()) {
            Process poll = queue.poll();
            boolean isBack = false;
            
            for (Process i : queue) {
                if (poll.priority < i.priority) {
                    queue.add(poll);
                    isBack = true;
                    break;
                }
            }
            
            if (!isBack) {
                if (poll.idx == location)
                    return answer;
                answer++;
            }
        }
        return answer;
    }
}