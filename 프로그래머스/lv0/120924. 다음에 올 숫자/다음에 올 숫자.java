import java.lang.Math;

class Solution {
    public int solution(int[] common) {
        int answer = 0;
        
        if(judge(common)){
            //  등차수열이면
            answer = arithmetic(common);
        } else{
            answer = geometric(common);
        }
        
        return answer;
    }
    
    public boolean judge(int[] arr){
        //  등차수열이다.
        if(arr[0] + arr[2] == 2*arr[1]) return true;
        //  등비수열이다.
        return false;
    }
    
    public int arithmetic(int[] arr){
        int a1 = arr[0];
        int n = arr.length + 1;
        int d = arr[1] - arr[0];
        return a1 + (n - 1) * d; 
    }
    
    public int geometric(int[] arr){
        int a1 = arr[0];
        int n = arr.length + 1;
        int r = arr[1]/arr[0];
        return (int)(a1 * Math.pow(r, n - 1));
    }
}