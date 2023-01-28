import java.util.*;

class Solution {
    
    Queue<Paper> que = new LinkedList<>();
    
    public void init(int[] priorites, int location) {
        int cnt = 0;
        for (int prior : priorites){
            Paper p = new Paper(prior);
            if(cnt == location)
                p.check();
            que.offer(p);
            cnt++;
        }
    }// end of init
    
    public int process() {
        int ans = 1;
        while (!que.isEmpty()) {
            Paper cur = que.peek();
            
            boolean isBigger = false;
            Iterator iter = que.iterator();
            while(iter.hasNext()){
                Paper p = (Paper)iter.next();
                if(p.prior > cur.prior){
                    isBigger = true;
                    break;
                }
            }
            
            if(isBigger){
                que.offer(que.poll());
                continue;                
            }
            
            if(cur.isMy)
                return ans;
            
            que.poll();
            ans++;
            
        }
        
        return ans;
    }// end of process
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        init(priorities, location);
        answer = process();
        return answer;
    }
}

class Paper {
    int prior;
    boolean isMy = false;
    
    public Paper(int prior) {
        this.prior = prior;
    }
    
    public void check() {
        this.isMy = true;
    }
}