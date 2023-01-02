//  n, n+1, n+2, ... 공차가 1인 등차수열의 구간합
class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        int n = 0;
        int cnt = 0;    
        int sum = 0;
        
        //  구간합 구하기
        for(int i=0; i<num; i++){
            sum += i;
            cnt++;
        }
        
        //  cnt * n + sum = total
        n = (total - sum) / cnt;
        for(int i=0; i<num; i++){
            answer[i] += n + i;
        }
        
        return answer;
    }
}