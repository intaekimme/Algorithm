import java.util.*;

class Solution {
    
    Queue<Feat> que = new LinkedList<>();
    
    public void init(int[] progresses, int[] speeds) {
        int len = speeds.length;
        for (int i = 0; i < len; i++) {
            que.offer(new Feat(progresses[i], speeds[i]));
        }
    }// end of init
    
    public int[] process() {
        
        List<Integer> res = new ArrayList<>();
        while(!que.isEmpty()){
            int cnt = 0;    //  하루 배포량
            //  하루 작업
            for (int i = 0; i < que.size(); i++){
                Feat feat = que.poll();
                feat.prog += feat.speed;
                que.offer(feat);
            }
            
            while(!que.isEmpty() && que.peek().prog >= 100){
                que.poll();
                cnt++;
            }
            
            if(cnt > 0)
                res.add(cnt);
        }
        
        int[] ans = new int[res.size()];
        int idx = 0;
        for (Integer cnt : res){
            ans[idx++] = cnt;
        }
        
        return ans;
    }// end of process
    
    public int[] solution(int[] progresses, int[] speeds) {
        init(progresses, speeds);
        int[] answer = process();
        return answer;
    }
}// end of class


class Feat {
    int prog;
    int speed;
    
    public Feat(int prog, int speed) {
        this.prog = prog;
        this.speed = speed;
    }
}// end of class