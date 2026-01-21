import java.util.*;

class Truck {
    public int bridgeIdx = 1;
    public int weight;
    
    public Truck(int weight) {
        this.weight = weight;
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int weightTotal = 0;
        List<Truck> truckOnBridge = new ArrayList<>();
        Queue<Integer> pendingQueue = new ArrayDeque<>();
        
        for (int i : truck_weights) {
            pendingQueue.add(i);
        }
        
        while(!pendingQueue.isEmpty() || !truckOnBridge.isEmpty()) {
            answer++;
            
            // 다리에 있는 트럭 건너기
            int removedIdx = -1;
            for (int i = 0; i < truckOnBridge.size(); i++) {
                Truck truck = truckOnBridge.get(i);
                truck.bridgeIdx++;
                
                if (truck.bridgeIdx > bridge_length) {
                    removedIdx = i;
                }
            }
            
            if (removedIdx != -1) {
                Truck truck = truckOnBridge.remove(removedIdx); 
                weightTotal -= truck.weight;
            }
            
            if (pendingQueue.isEmpty() || 
                truckOnBridge.size() >= bridge_length) {
                continue;
            }
            
            // bridge에 truck 올리기
            if (weightTotal + pendingQueue.peek() <= weight) {
                int w = pendingQueue.poll();
                weightTotal += w;
                truckOnBridge.add(new Truck(w));  
            }
            
//             System.out.println("=======");
//             System.out.println("answer = " + answer);
//             System.out.print("대기 트럭: ");
//             for (Integer i : pendingQueue) {
//                 System.out.print(i + " ");
//             }
//             System.out.println();
            
//             System.out.print("다리 위 트럭: ");
//             for (Truck t : truckOnBridge) {
//                 System.out.printf("idx = %d, weight = %d /// ", t.bridgeIdx, t.weight);
//             }
//             System.out.println();
        }
        return answer;
    }
}