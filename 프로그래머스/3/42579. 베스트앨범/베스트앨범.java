import java.util.*;

class Solution {
    
    class Node {
        int play, id;
        
        Node(int play, int id) {
            this.play = play;
            this.id = id;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Queue<Node>> map = new HashMap<>();
        Map<String, Integer> cntMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            if (map.containsKey(genres[i])) {
                Queue<Node> q = map.get(genres[i]);
                q.add(new Node(plays[i], i));
                
                cntMap.put(genres[i], cntMap.get(genres[i]) + plays[i]);
                continue;
            }
            
            Queue<Node> q = new PriorityQueue<>((o1, o2) -> {
                if (o1.play != o2.play) {
                    return Integer.compare(o1.play, o2.play) * -1;
                }
                return Integer.compare(o1.id, o2.id);
            });

            q.add(new Node(plays[i], i));
            map.put(genres[i], q);
            
            cntMap.put(genres[i], plays[i]);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        while(!map.isEmpty()) {
            String genre = null;
            int max = 0;
            
            for (String key : cntMap.keySet()) {
                Integer play = cntMap.get(key);
                
                if (max < play) {
                    genre = key;
                    max = play;
                }
            }
            
            Queue<Node> q = map.remove(genre);
            cntMap.remove(genre);
            // System.out.println("key = " + genre);
            
            for (int i = 0; i < 2 && !q.isEmpty(); i++) {
                Node node = q.poll();
                
                // System.out.println(node.id + " " + node.play);
                list.add(node.id);
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}