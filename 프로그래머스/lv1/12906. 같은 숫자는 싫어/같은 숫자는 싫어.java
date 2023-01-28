import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.length; i++){
            if(s.isEmpty())
                s.push(arr[i]);
            if(s.peek() != arr[i])
                s.push(arr[i]);
        }
        
        int size = s.size();
        int[] answer = new int[size];
        for (int i = size - 1; i >= 0; i--)
            answer[i] = s.pop();
        
        return answer;
    }
}