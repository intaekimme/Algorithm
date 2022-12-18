import java.util.*;
import java.lang.*;

class Solution {
    public static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public static ArrayList<Integer> arr = new ArrayList<>();
    
    public int[] solution(int k, int[] score) {
        for(int i = 0; i < score.length; i++){
            pq.add(score[i]);
            arr.add(findMyeongYeMin(k));
        }
        
        return arr.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    public int findMyeongYeMin(int k) {
        ArrayList<Integer> tmp = new ArrayList<>(k);
        for(int i = 0; i < k; i++){
            if(pq.isEmpty()) break;
            tmp.add(pq.poll());
        }
        
        Collections.sort(tmp);
        int res = tmp.get(0);
        
        while(!tmp.isEmpty()){
            pq.add(tmp.remove(0));
        }
        
        return res;
    }
}