import java.util.*;

class Solution {
    Queue<int[]> jobQueue = new ArrayDeque<>();
    PriorityQueue<int[]> waitQueue = new PriorityQueue<>((a, b) -> {
       if (a[2] < b[2]) {
                return -1;
            } else if (a[2] > b[2]) {
                return 1;
            }
            
            if (a[1] < b[1]) {
                return -1;
            } else if (a[1] > b[1]) {
                return 1;
            }
            
            if (a[0] < b[0])
                return -1; 
            return 1;
    });
    
    public int solution(int[][] jobs) {
        int answer = 0;     
        
        Arrays.sort(jobs, (a, b) -> {
            if (a[0] < b[0]) {
                return -1;
            } else if (a[0] > b[0]) {
                return 1;
            }
            
            if (a[1] < b[1]) {
                return -1;
            } else if (a[1] > b[1]) {
                return 1;
            }
            
            return -1;
        });

        for (int i = 0; i < jobs.length; i++) {
            jobQueue.add(new int[]{i, jobs[i][0], jobs[i][1]});   
        }
        
        // for (int[] i : jobQueue) {
        //     System.out.println(i[0] + " " + i[1] + " " + i[2]);
        // }

        int[] first = jobQueue.poll();
        int time = first[1];
        waitQueue.add(first);
        
        while(!jobQueue.isEmpty() || !waitQueue.isEmpty()) {
            int[] poll = waitQueue.poll();
            
            time += poll[2];
            answer += time - poll[1];
            
            // System.out.println(String.format("time = %d, poll = %d [%d, %d], answer = %d", 
            //                                  time, poll[0], poll[1], poll[2], answer));
            
            while(!jobQueue.isEmpty() && jobQueue.peek()[1] <= time) {
                waitQueue.add(jobQueue.poll());
            }
            
            if (waitQueue.isEmpty() && !jobQueue.isEmpty()) {
                int[] nextPoll = jobQueue.poll();
                time = nextPoll[1];
                waitQueue.add(nextPoll);
            }
        }
        
        return answer / jobs.length;
    }
}