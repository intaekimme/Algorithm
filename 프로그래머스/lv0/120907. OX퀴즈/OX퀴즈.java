import java.util.StringTokenizer;

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for(int i=0; i<quiz.length; i++){
            if(isValid(quiz[i]))
                answer[i] = "O";
            else
                answer[i] = "X";
        }
        
        return answer;
    }// end of solution
    
    public boolean isValid(String q){
        StringTokenizer st = new StringTokenizer(q);
        int x = Integer.parseInt(st.nextToken());
        String op = st.nextToken();
        int y = Integer.parseInt(st.nextToken());
        
        st.nextToken();
        int result = Integer.parseInt(st.nextToken());
        
        if(op.equals("-")){
            if(x-y == result) return true;
            return false;
        }
        if(x+y == result) return true;
        return false;
    }
}