import java.util.*;

class Solution {
    
    int colCnt, rowCnt;
    List<Set<Integer>> answer = new ArrayList<>();
    
    public int solution(String[][] relation) {
        rowCnt = relation.length;
        colCnt = relation[0].length;
        
        for (int i = 1; i <= colCnt; i++) {
            bruthForce(relation, new int[i], 0, 0);
        }
        
        return answer.size();
    }
    
    void bruthForce(String[][] relation, int[] arr, int depth, int start) {
        if (arr.length == depth) {
            // System.out.println("arr size = " + arr.length);
            // for (int i = 0; i < arr.length; i++) {
            //     System.out.print(arr[i] + " ");
            // }
            // System.out.println();
            for (Set<Integer> set : answer) {
                int cnt = 0;
                
                for (int i : arr) {
                    if (set.contains(i)) {
                        cnt++;
                    }
                }
                
                if (cnt == set.size()) {
                    return;
                }
            }
            
            if (isUnique(relation, arr)) {
                Set<Integer> set = new HashSet<>();

                for (int i : arr) {
                    set.add(i);
                }
                answer.add(set);
            }
            return;
        }
        
        for (int i = start; i < colCnt; i++) {
            arr[depth] = i;
            bruthForce(relation, arr, depth + 1, i + 1);
        }
    }
    
    boolean isUnique(String[][] relation, int[] arr) {
        Set<String> set = new HashSet<>();
        
        for (String[] r : relation) {
            String value = "";
            
            for (int i : arr) {
                value += r[i];
            }   
            set.add(value);
        }
        return set.size() == rowCnt;
    }
}